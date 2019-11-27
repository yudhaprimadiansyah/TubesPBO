/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tubs.gaspol.item;

import java.sql.Time;

/**
 *
 * @author DORIZU
 */
public class JadwalMengajarDosen extends Jadwal {
    private int hariKe;

    public JadwalMengajarDosen(int idJadwal,int hariKe, Time jamMulai, Time jamSelesai) {
        super(idJadwal, jamMulai, jamSelesai);
        this.hariKe = hariKe;
    }

    public int getHariKe() {
        return hariKe;
    }

    public void setHariKe(int hariKe) {
        this.hariKe = hariKe;
    }
    
    
    
}
