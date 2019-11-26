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
    
    public int tambahDosen(String nama, String email, String idKeahlian, String kodeDosen,String nip){
        int hasil = 0;
        if(conn != null){
            try{
                String query = "INSERT INTO dosen(nama, email, id_keahlian, kode_dosen, nip) VALUES (?,?,?,?,?)";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, nama);
                ps.setString(2, email);
                ps.setString(3, idKeahlian);
                ps.setString(4, kodeDosen);
                ps.setString(5, nip);
                hasil = ps.executeUpdate();
                
            }catch(SQLException e){
                
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return hasil;
    }
    
    public void tambahMahasiswa(String nim, String nama, String email){
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
    
    public void tambahJadwalDosen(String jamMulai, String jamSelesai, int hariKe){
        if(conn != null){
            try{
                String query = "INSERT INTO jadwal_mengajar_dosen(jam_mulai, jam_selesai, hari_ke) VALUES (?,?,?)";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, jamMulai);
                ps.setString(2, jamSelesai);
                ps.setInt(3, hariKe);
                int hasil = ps.executeUpdate();
                
            }catch(SQLException e){
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    public void tambahJadwalSidang(String jamMulai, String jamSelesai, String tanggal, int idPenguji1, int idPenguji2, int idRuang, int idPa, int idPeriode){
        if(conn != null){
            try{
                String query = "INSERT INTO jadwal_sidang(jam_mulai, jam_selesai, tanggal, id_penguji1, id_penguji2, id_ruang, id_pa, id_periode) VALUES (?,?,?,?,?,?,?,?)";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, jamMulai);
                ps.setString(2, jamSelesai);
                ps.setString(3, tanggal);
                ps.setInt(4, idPenguji1);
                ps.setInt(5, idPenguji2);
                ps.setInt(6, idRuang);
                ps.setInt(7, idPa);
                ps.setInt(8, idPeriode);

                int hasil = ps.executeUpdate();
                
            }catch(SQLException e){
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    public void tambahKeahlian(String namaKeahlian){
        if(conn != null){
            try{
                String query = "INSERT INTO keahlian(nama_keahlian) VALUES (?)";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, namaKeahlian);
               
                int hasil = ps.executeUpdate();
                
            }catch(SQLException e){
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    public void tambahPengelola(String username, String password, String nama, String nip){
        if(conn != null){
            try{
                String query = "INSERT INTO pengelola(username, password, nama, nip) VALUES (?,?,?,?)";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, username);
                ps.setString(2, password);
                ps.setString(3, nama);
                ps.setString(4, nip);          

                int hasil = ps.executeUpdate();
                
            }catch(SQLException e){
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    public void tambahPeriodeSidang(String tahun, String tanggalAwal, String tanggalAkhir, String periode){
        if(conn != null){
            try{
                String query = "INSERT INTO periode_sidang(tahun, tanggal_awal, tanggal_akhir, periode_ke) VALUES (?,?,?,?)";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, tahun);
                ps.setString(2, tanggalAwal);
                ps.setString(3, tanggalAkhir);
                ps.setString(4, periode);          

                int hasil = ps.executeUpdate();
                
            }catch(SQLException e){
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    public void tambahPa(String judul, String idDosbing1, String idDosbing2, String keahlian){
        if(conn != null){
            try{
                String query = "INSERT INTO proyek_akhir(judul, id_dosbing1, id_dosbing2, id_keahlian, nim) VALUES (?,?,?,?,?)";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, judul);
                ps.setString(2, idDosbing1);
                ps.setString(3, idDosbing2);
                ps.setString(4, keahlian);          

                int hasil = ps.executeUpdate();
                
            }catch(SQLException e){
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    public void tambahRuang(String nama){
        if(conn != null){
            try{
                String query = "INSERT INTO ruangan(nama) VALUES (?)";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, nama);
                

                int hasil = ps.executeUpdate();
                
            }catch(SQLException e){
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, e);
            }
        }
    }
    
    public int updateDosen(int id, String nama, String email, String idKeahlian, String kodeDosen,String nip){
        int hasil = 0;
        if(conn != null){
            try{
                String query = "UPDATE dosen SET nama=?, email=?, id_keahlian=?, kode_dosen=?, nip=? WHERE id=?";
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, nama);
                ps.setString(2, email);
                ps.setString(3, idKeahlian);
                ps.setString(4, kodeDosen);
                ps.setString(5, nip);
                ps.setInt(6, id);
                hasil = ps.executeUpdate();
                
            }catch(SQLException e){
                Logger.getLogger(CRUD.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        return hasil;
    }
    
    public void updateMahasiswa(String nama, String email, String nim){
        if(conn != null){
            try{
                String query = "UPDATE mahasiswa nama=?, email=? WHERE nim=?";
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
    
    
    
    
}
