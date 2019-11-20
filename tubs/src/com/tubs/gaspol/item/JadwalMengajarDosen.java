/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tubs.gaspol.item;

/**
 *
 * @author DORIZU
 */
public class JadwalMengajarDosen {
    int id, hariKe;
    String jamMulai, jamSelesai;

    public JadwalMengajarDosen(int id, int hariKe, String jamMulai, String jamSelesai) {
        this.id = id;
        this.hariKe = hariKe;
        this.jamMulai = jamMulai;
        this.jamSelesai = jamSelesai;
    }

    public int getId() {
        return id;
    }

    public int getHariKe() {
        return hariKe;
    }

    public String getJamMulai() {
        return jamMulai;
    }

    public String getJamSelesai() {
        return jamSelesai;
    }
    
    
    
}
