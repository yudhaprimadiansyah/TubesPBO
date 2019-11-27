/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tubs.gaspol.list;

import com.tubs.gaspol.db.Koneksi;
import com.tubs.gaspol.item.*;
import com.tubs.gaspol.view.AdminDashboard;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author seifer
 */
public class ListData {
    private ArrayList<Dosen> listDosen;
    private ArrayList<Keahlian> listKeahlian;
    private ArrayList<Ruangan> listRuangan;
    private Connection conn;
    
    public ListData(){
        this.conn = new Koneksi().bukaKoneksi();
        loadDosen();
        loadKeahlian();
        loadRuangan();
    }
    
    public void loadDosen(){
        if(conn != null){
            listDosen = new ArrayList<>();
            String query = "SELECT * FROM dosen";
            try{
                PreparedStatement ps = conn.prepareStatement(query);
                ResultSet rs = ps.executeQuery();
                while(rs.next()){
                    int id = rs.getInt("id");
                    String nama = rs.getString("nama");
                    String kode = rs.getString("kode_dosen");
                    String nip = rs.getString("nip");
                    int idKeahlian = rs.getInt("id_keahlian");
                    String email = rs.getString("email");
                    Dosen dosen = new Dosen(kode,nip,nama,email,idKeahlian);
                    listDosen.add(dosen);
                }
                rs.close();
                ps.close();
            }catch(SQLException e){
                Logger.getLogger(AdminDashboard.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    public ArrayList<Dosen> getAllDosen(){
        return this.listDosen;
    }
    
    
    public Object[] getKodeAllDosen(){
        
        ArrayList<String> kodeDosen = new ArrayList<>();
        
        for(Dosen kd: listDosen){
                kodeDosen.add(kd.getKodeDosen());
            
            
        }
        Object[] listKodeDosen = kodeDosen.toArray();
        return listKodeDosen;
    }
    
    public Object[] getKodeAllDosenByKeahlian(int idKeahlian){
        
        ArrayList<String> kodeDosen = new ArrayList<>();
        
        for(Dosen kd: listDosen){
            if(kd.getIdKeahlian() == (idKeahlian)){
                kodeDosen.add(kd.getKodeDosen());
            }
            
        }
        Object[] listKodeDosen = kodeDosen.toArray();
        return listKodeDosen;
    }
    
    private void loadKeahlian(){
        System.out.println(conn);
        if(conn != null){
            String query = "SELECT * FROM keahlian";
            try {
                this.listKeahlian = new ArrayList<>();
                PreparedStatement ps = this.conn.prepareStatement(query);
                ResultSet res = ps.executeQuery();
                while(res.next()){
                    int id = res.getInt("id");
                    String namaKeahlian = res.getString("nama_keahlian");
                    this.listKeahlian.add(new Keahlian(id,namaKeahlian));
                }
                res.close();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(ListData.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
    }
    
     private void loadRuangan(){
        System.out.println(conn);
        if(conn != null){
            String query = "SELECT * FROM ruangan";
            try {
                this.listRuangan = new ArrayList<>();
                PreparedStatement ps = this.conn.prepareStatement(query);
                ResultSet res = ps.executeQuery();
                while(res.next()){
                    int id = res.getInt("id");
                    String namaRuangan = res.getString("nama");
                    this.listRuangan.add(new Ruangan(id,namaRuangan));
                }
                res.close();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(ListData.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
    }
    
    public String[][] getAllKeahlian(){
        String[][] keahlians = new String[2][listKeahlian.size()];
        ArrayList<String> idList = new ArrayList<>();
        ArrayList<String> keahlianList = new ArrayList<>();
        for(Keahlian k:this.listKeahlian){
            idList.add(Integer.toString(k.getId()));
            keahlianList.add(k.getNamaKeahlian());
        }
        
       idList.toArray(keahlians[0]);
       keahlianList.toArray(keahlians[1]);
       return keahlians;
    }
    
    public Object[] getAllRuangan(){
        ArrayList<Integer> idList = new ArrayList<>();
        for(Ruangan k:this.listRuangan){
            idList.add(k.getId());
        }
        
       Object ruangan[] = idList.toArray();
       return ruangan;
    }
    
  /*  public ArrayList<JadwalMengajarDosen> getAllJadwalDosen(){
        ArrayList<JadwalMengajarDosen> listJadwal = new ArrayList<>();
        String query = "SELECT * FROM jadwal_mengajar_dosen";
    }*/

    public ArrayList<Dosen> getDosenByKeahlian(int id_keahlian, String dosbing1, String dosbing2) {
        String query = "SELECT * FROM dosen WHERE id_keahlian="+id_keahlian+" AND kode_dosen != '"+dosbing1+"' AND kode_dosen != '"+dosbing2+"' ORDER BY jatah_sidang ASC"; //To change body of generated methods, choose Tools | Templates.
        ArrayList<Dosen> ld = new ArrayList<>();
        try {
            PreparedStatement ps = this.conn.prepareStatement(query);
            ResultSet res = ps.executeQuery();
            while(res.next()){
                String kode = res.getString("kode_dosen");
                String nama = res.getString("nama");
                String email = res.getString("email");
                String nip = res.getString("nip");
                int idKeahlian = res.getInt("id_keahlian");
                ld.add(new Dosen(kode,nip,nama,email,idKeahlian));
            }
        } catch (SQLException ex) {
            Logger.getLogger(ListData.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return ld;
    }
}
