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
public class Personal {
    private String name;
    private String email;
    private int idKeahlian;

    public Personal(String name, String email, int idKeahlian) {
        this.name = name;
        this.email = email;
        this.idKeahlian = idKeahlian;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdKeahlian() {
        return idKeahlian;
    }

    public void setIdKeahlian(int idKeahlian) {
        this.idKeahlian = idKeahlian;
    }
    
    
    
}
