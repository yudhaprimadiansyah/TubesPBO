/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tubs.gaspol.list;

import com.tubs.gaspol.db.Koneksi;
import com.tubs.gaspol.item.Dosen;
import com.tubs.gaspol.item.Keahlian;
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
    private Connection conn;
    
    public ListData(){
        this.conn = new Koneksi().bukaKoneksi();
        loadDosen();
        loadKeahlian();
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
}
