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
public class Dosen {
    
    private int id, id_keahlian;
    private String nama, kode_dosen, email, nip;

    public Dosen(int id, int id_keahlian, String nama, String kode_dosen, String email, String nip) {
        this.id = id;
        this.id_keahlian = id_keahlian;
        this.nama = nama;
        this.kode_dosen = kode_dosen;
        this.email = email;
        this.nip = nip;
    }

    public int getId() {
        return id;
    }

    public int getId_keahlian() {
        return id_keahlian;
    }

    public String getNama() {
        return nama;
    }

    public String getKode_dosen() {
        return kode_dosen;
    }

    public String getEmail() {
        return email;
    }

    public String getNip() {
        return nip;
    }
    
}
