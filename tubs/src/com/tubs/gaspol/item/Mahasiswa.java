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
public class Mahasiswa extends Personal {
   
    private String nim;

    public Mahasiswa(String nim, int id, String name, String email, int idKeahlian) {
        super(id, name, email, idKeahlian);
        this.nim = nim;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }
    
}
