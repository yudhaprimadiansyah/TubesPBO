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
public class Mahasiswa {
    int id, idKeahlian;
    String nama, email, nim, judulPA;

    public Mahasiswa(int id, int idKeahlian, String nama, String email, String nim, String judulPA) {
        this.id = id;
        this.idKeahlian = idKeahlian;
        this.nama = nama;
        this.email = email;
        this.nim = nim;
        this.judulPA = judulPA;
    }

    public int getId() {
        return id;
    }

    public int getIdKeahlian() {
        return idKeahlian;
    }

    public String getNama() {
        return nama;
    }

    public String getEmail() {
        return email;
    }

    public String getNim() {
        return nim;
    }

    public String getJudulPA() {
        return judulPA;
    }
    
    
}
