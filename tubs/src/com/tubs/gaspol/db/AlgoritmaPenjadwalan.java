/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tubs.gaspol.db;

import com.tubs.gaspol.item.*;
import com.tubs.gaspol.list.ListData;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author seifer
 */
public class AlgoritmaPenjadwalan {
    private String jam[] = {"08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00"};
    private List<Date> tanggals;
    private PeriodeSidang periodeSidang;
    private Connection conn = Koneksi.bukaKoneksi();
    private JadwalSidang jadwalFix;
    private ArrayList<Dosen> dosenKeahlian;
    private Object[] Ruangan = new ListData().getAllRuangan();
    
    public AlgoritmaPenjadwalan(int id_keahlian, int tahun, int periode, String dosbing1, String dosbing2){
        dosenKeahlian = new ListData().getDosenByKeahlian(id_keahlian, dosbing1, dosbing2);
        getDataPeriodeSidang(tahun,periode);
        Date tanggalAwal;
        try {
            tanggalAwal = new SimpleDateFormat("yyyy-MM-dd").parse(periodeSidang.getTanggalAwal());
            Date tanggalAkhir = new SimpleDateFormat("yyyy-MM-dd").parse(periodeSidang.getTanggalAkhir());;
            tanggals = JarakTanggal(tanggalAwal,tanggalAkhir);
            getDosenFix();
            
            //ArrayList<Dosen> dosenDapat = new getDosenFix();
        } catch (ParseException ex) {
            Logger.getLogger(AlgoritmaPenjadwalan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //tambahJatah(dosen1,dosen2);
        
    }
    
    public List<Date> JarakTanggal(Date startDate, Date endDate) {
        List<Date> datesInRange = new ArrayList<>();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(startDate);

        Calendar endCalendar = new GregorianCalendar();
        endCalendar.setTime(endDate);

        while (calendar.before(endCalendar)) {
            Date result = calendar.getTime();
            datesInRange.add(result);
            calendar.add(Calendar.DATE, 1);
        }
        return datesInRange;
    }
    
    private void getDataPeriodeSidang(int tahun,int periode){
        String query = "SELECT * FROM periode_sidang WHERE tahun="+tahun+" AND periode_ke="+periode;
        try {
            PreparedStatement ps = this.conn.prepareStatement(query);
            ResultSet res = ps.executeQuery();
            while(res.next()){
                int id_periode = res.getInt("id_periode");
                int tahuns = res.getInt("tahun");
                String tanggal_awal = res.getString("tanggal_awal");
                String tanggal_akhir = res.getString("tanggal_akhir");
                int periodeKe = res.getInt("periode_ke");
                this.periodeSidang = new PeriodeSidang(id_periode,tahuns,tanggal_awal,tanggal_akhir,periodeKe);
                break;
            }
            res.close();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlgoritmaPenjadwalan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
    
   private void getDosenFix() throws ParseException{
        for(Dosen d:this.dosenKeahlian){
            System.out.println(d.getKodeDosen());
            for(Dosen d2:this.dosenKeahlian){
                if(d.getKodeDosen().equals(d2.getKodeDosen())){
                    continue;
                }
                else {
                    System.out.println(d2.getKodeDosen());
                    boolean ada = false;
                    boolean dapat = false;
                    System.out.println(dapat);
                    for(Date date: tanggals){
                        if(dapat == true){
                            break;
                        }
                        Calendar cal = Calendar.getInstance();
                        cal.setTime(date);
                        int hari = cal.get(Calendar.DAY_OF_WEEK);
                        System.out.println(hari);
                        for(String w: this.jam){
                            if(dapat == true){
                                break;
                            }
                            System.out.println(w.toString());
                            for(Object r: this.Ruangan){
                                if(dapat == true){
                                    break;
                                }
                                System.out.println("Ruangan : "+r);
                                String query = "SELECT * FROM jadwal_mengajar_dosen WHERE (TIME(\""+w+"\") BETWEEN jam_mulai AND jam_selesai) "
                                        + "AND (DATE_ADD(TIME(\""+w+"\"), interval 2 hour) BETWEEN jam_mulai AND jam_selesai) AND hari_ke="+hari+" "
                                        + "AND (kode_dosen='"+d.getKodeDosen()+"' OR kode_dosen='"+d2.getKodeDosen()+"')";
                                PreparedStatement ps;
                                System.out.println(query);
                                try {
                                    ps = this.conn.prepareStatement(query);
                                    ResultSet res = ps.executeQuery();
                                    while(res.next()){
                                        ada = true;
                                    }
                                    
                                    String query2 = "SELECT * FROM jadwal_sidang WHERE (TIME(\""+w+"\") BETWEEN jam_mulai AND jam_selesai) "
                                            + "AND (DATE_ADD(TIME(\""+w+"\"), interval 2 hour) BETWEEN jam_mulai AND jam_selesai) AND tanggal="+new SimpleDateFormat("yyyy-MM-dd").format(date)+" "
                                            + "AND (penguji1='"+d.getKodeDosen()+"' OR penguji1='"+d2.getKodeDosen()+"') "
                                            + "AND (penguji2='"+d.getKodeDosen()+"' OR penguji2='"+d2.getKodeDosen()+"') OR id_ruangan="+r;
                                            PreparedStatement ps2;
                                            System.out.println(query2);
                                    try {
                                        ps2 = this.conn.prepareStatement(query);
                                        ResultSet res2 = ps.executeQuery();
                                        while(res2.next()){
                                            ada = true;
                                        }
                                        res.close();
                                        ps.close();
                                        res2.close();
                                        ps2.close();
                                        if(ada == false){
                                            dapat = true;
                                            System.out.println("Dapat Jadwal, Pada Tanggal : "+date+", Dimulai Jam : "+w+", Dengan Dosen Penguji1 : "+d.getKodeDosen()+" Dan Dosen Penguji 2 "+d2.getKodeDosen());
                                            tambahJatah(d,d2);
                                            break;
                                        }
                                    }
                                    catch (SQLException ex) {
                                        Logger.getLogger(AlgoritmaPenjadwalan.class.getName()).log(Level.SEVERE, null, ex);
                                    }

                                    
                                } catch (SQLException ex) {
                                    Logger.getLogger(AlgoritmaPenjadwalan.class.getName()).log(Level.SEVERE, null, ex);
                                }
                                System.out.println("Ada : "+ada);
                            }
                        }
                    }
                }
            }
        }
    }
    
    private void tambahJatah(Dosen d1, Dosen d2){
        String query = "UPDATE dosen SET jatah_sidang=jatah_sidang+1 WHERE kode_dosen='"+d1.getKodeDosen()+"' OR kode_dosen='"+d2.getKodeDosen()+"'";
        try {
            PreparedStatement ps = this.conn.prepareStatement(query);
            ps.executeQuery();
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlgoritmaPenjadwalan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
    
   
}
