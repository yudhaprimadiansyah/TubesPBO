/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tubs.gaspol.db;

import com.tubs.gaspol.item.*;
import com.tubs.gaspol.list.ListData;
import java.sql.Connection;
import java.util.ArrayList;

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
    }
    
   
}
