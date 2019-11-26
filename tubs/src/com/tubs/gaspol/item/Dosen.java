/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tubs.gaspol.item;

/**
 *
 * @author seifer
 */
public class Dosen extends Personal{
    private String kodeDosen;
    private int idKeahlian;
    private String nip;

    public Dosen(String kodeDosen, String nip, String name, String email, int idKeahlian) {
        super(name, email);
        this.kodeDosen = kodeDosen;
        this.idKeahlian = idKeahlian;
        this.nip = nip;
    }

    public String getKodeDosen() {
        return kodeDosen;
    }

    public void setKodeDosen(String kodeDosen) {
        this.kodeDosen = kodeDosen;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public int getIdKeahlian() {
        return idKeahlian;
    }

    public void setIdKeahlian(int idKeahlian) {
        this.idKeahlian = idKeahlian;
    }
    
    
    
    
    
}
