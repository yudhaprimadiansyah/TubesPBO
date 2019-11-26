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
import java.sql.SQLException;
import java.util.ArrayList;
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
    private Connection conn = Koneksi.bukaKoneksi();
    private ArrayList<Dosen> dosenKeahlian;
    
    public AlgoritmaPenjadwalan(int id_keahlian){
        dosenKeahlian = new ListData().getDosenByKeahlian(id_keahlian);
        ArrayList<Dosen> dosenDapat = new getDosenFix();
        //tambahJatah(dosen1,dosen2);
        
    }
    
    private ArrayList<Dosen> getDosenFix(){
        for(Dosen d:this.dosenKeahlian){
            for(Dosen d2:this.dosenKeahlian){
                if(d.getKodeDosen().equals(d2.getKodeDosen())){
                    continue;
                }
                else {
                    
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
