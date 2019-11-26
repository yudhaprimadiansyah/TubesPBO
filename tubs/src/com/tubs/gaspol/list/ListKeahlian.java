/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tubs.gaspol.list;

import com.tubs.gaspol.db.Koneksi;
import com.tubs.gaspol.item.Keahlian;
import java.sql.Connection;
import java.sql.Date;
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
public class ListKeahlian {
    
    private ArrayList<Keahlian> listKeahlian;
    private final Connection conn;
    
    public ListKeahlian(){
        this.conn = Koneksi.bukaKoneksi();
        this.loadKeahlian();
        
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
                Logger.getLogger(ListKeahlian.class.getName()).log(Level.SEVERE, null, ex);
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
