/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tubs.gaspol.item;

import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author DORIZU
 */
public class JadwalSidang extends Jadwal{
    
    private int idRuangan;
    private int idPA;
    private Date tanggal;
    private String KDPenguji1;
    private String KDPenguji2;

    public JadwalSidang(int idRuangan, int idPA, Date tanggal, String KDPenguji1, String KDPenguji2, int idJadwal, Time jamMulai, Time jamSelesai) {
        super(idJadwal, jamMulai, jamSelesai);
        this.idRuangan = idRuangan;
        this.idPA = idPA;
        this.tanggal = tanggal;
        this.KDPenguji1 = KDPenguji1;
        this.KDPenguji2 = KDPenguji2;
    }

    public int getIdRuangan() {
        return idRuangan;
    }

    public void setIdRuangan(int idRuangan) {
        this.idRuangan = idRuangan;
    }

    public int getIdPA() {
        return idPA;
    }

    public void setIdPA(int idPA) {
        this.idPA = idPA;
    }

    public Date getTanggal() {
        return tanggal;
    }

    public void setTanggal(Date tanggal) {
        this.tanggal = tanggal;
    }

    public String getKDPenguji1() {
        return KDPenguji1;
    }

    public void setKDPenguji1(String KDPenguji1) {
        this.KDPenguji1 = KDPenguji1;
    }

    public String getKDPenguji2() {
        return KDPenguji2;
    }

    public void setKDPenguji2(String KDPenguji2) {
        this.KDPenguji2 = KDPenguji2;
    }
    
    public void registrasi(String nama,String nim,int idKeahlian,String email,
            String dosenPembimbing1,String dosenPembimbing2,String tahunSidangg,String periodSidang){
            //new ProyekAkhir()
    }
    
}
