/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tubs.gaspol.list;

import com.tubs.gaspol.db.Koneksi;
import com.tubs.gaspol.item.Dosen;
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
public class ListDosen {
    private ArrayList<Dosen> listDosen;
    private Connection conn;
    
    public ListDosen(){
        this.conn = new Koneksi().bukaKoneksi();
        loadDosen();
    }
    
    private void loadDosen(){
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
    
}
