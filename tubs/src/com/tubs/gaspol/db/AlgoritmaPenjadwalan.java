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
    private int hari[] = {1,2,3,4,5};
    private String jam[] = {"08:00", "09:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00"};
    private ArrayList<JadwalMengajarDosen> jadwalDosen;
    private ArrayList<JadwalSidang> jadwalSidang;
    private List<Date> tanggals;
    private PeriodeSidang periodeSidang;
    private Connection conn = Koneksi.bukaKoneksi();
    private ArrayList<Dosen> dosenKeahlian;
    
    public AlgoritmaPenjadwalan(int id_keahlian, int tahun, int periode){
        dosenKeahlian = new ListData().getDosenByKeahlian(id_keahlian);
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
            for(Dosen d2:this.dosenKeahlian){
                if(d.getKodeDosen().equals(d2.getKodeDosen())){
                    continue;
                }
                else {
                    for(Date date: tanggals){
                        Calendar cal = Calendar.getInstance();
                        cal.setTime(date);
                        int hari = cal.get(Calendar.DAY_OF_WEEK);
                        for(String w: this.jam){
                            String query = "SELECT * FROM `jadwal_mengajar_dosen` WHERE (TIME(\""+w+"\") BETWEEN jam_mulai AND jam_selesai) "
                                    + "AND (TIME(\""+Integer.parseInt(w.split(":", 1)[0])+":00"+"\") BETWEEN jam_mulai AND jam_selesai)";
                            System.out.println(query);
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
