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
    
<<<<<<< HEAD
    public Personal(String name, String email) {
=======
    public Personal( int id,String name, String email) {
        this.id = id;
>>>>>>> 80e58854528ee0cd462d0b08bcac1fd219b3cd7d
        this.name = name;
        this.email = email;
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


    
    
    
}
