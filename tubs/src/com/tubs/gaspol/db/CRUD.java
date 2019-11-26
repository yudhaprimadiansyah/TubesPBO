/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tubs.gaspol.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DORIZU
 */
public class CRUD {
    
    private Connection conn;
    private DefaultTableModel model = new DefaultTableModel();
    
    public CRUD(){
        conn = Koneksi.bukaKoneksi();
    
    }
    
    private void tambahDosen(String nama, String email, int idKeahlian, String kodeDosen,String nip){
        if(conn != null){
            try{
                String query = "INSERT INTO dosen(nama, email, id_keahlian, kode_dosen, nip) VALUES (?,?,?,?,?)";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, nama);
                ps.setString(2, email);
                ps.setInt(3, idKeahlian);
                ps.setString(4, kodeDosen);
                ps.setString(5, nip);
                int hasil = ps.executeUpdate();
                
            }catch(SQLException e){
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    private void tambahMahasiswa(String nama, String email, String nim){
        if(conn != null){
            try{
                String query = "INSERT INTO mahasiswa(nama, email, nim) VALUES (?,?,?)";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, nama);
                ps.setString(2, email);
                ps.setString(3, nim);
                int hasil = ps.executeUpdate();
                
            }catch(SQLException e){
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    private void updateDosen(int id, String nama, String email, int idKeahlian, String kodeDosen,String nip){
        if(conn != null){
            try{
                String query = "UPDATE dosen SET nama=?, email=?, id_keahlian=?, kode_dosen=?, nip=? WHERE id=?";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, nama);
                ps.setString(2, email);
                ps.setInt(3, idKeahlian);
                ps.setString(4, kodeDosen);
                ps.setString(5, nip);
                ps.setInt(6, id);
                int hasil = ps.executeUpdate();
                
            }catch(SQLException e){
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
}
