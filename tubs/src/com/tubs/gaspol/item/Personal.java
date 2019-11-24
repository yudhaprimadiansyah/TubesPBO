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
    private int id;
    private String name;
    private String email;
    private int idKeahlian;

    public Personal(int id, String name, String email, int idKeahlian) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.idKeahlian = idKeahlian;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
