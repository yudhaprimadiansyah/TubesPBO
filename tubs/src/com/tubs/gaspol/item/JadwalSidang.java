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
public class JadwalSidang {
    int id, idMhs, idDosbing1, idDOsbing2, idPenguji1, idPenguji2, idRuang;
    String jamMulai, jamSelesai, tanggal;

    public JadwalSidang(int id, int idMhs, int idDosbing1, int idDOsbing2, int idPenguji1, int idPenguji2, int idRuang, String jamMulai, String jamSelesai, String tanggal) {
        this.id = id;
        this.idMhs = idMhs;
        this.idDosbing1 = idDosbing1;
        this.idDOsbing2 = idDOsbing2;
        this.idPenguji1 = idPenguji1;
        this.idPenguji2 = idPenguji2;
        this.idRuang = idRuang;
        this.jamMulai = jamMulai;
        this.jamSelesai = jamSelesai;
        this.tanggal = tanggal;
    }

    public int getId() {
        return id;
    }

    public int getIdMhs() {
        return idMhs;
    }

    public int getIdDosbing1() {
        return idDosbing1;
    }

    public int getIdDOsbing2() {
        return idDOsbing2;
    }

    public int getIdPenguji1() {
        return idPenguji1;
    }

    public int getIdPenguji2() {
        return idPenguji2;
    }

    public int getIdRuang() {
        return idRuang;
    }

    public String getJamMulai() {
        return jamMulai;
    }

    public String getJamSelesai() {
        return jamSelesai;
    }

    public String getTanggal() {
        return tanggal;
    }
    
    
    
    
}
