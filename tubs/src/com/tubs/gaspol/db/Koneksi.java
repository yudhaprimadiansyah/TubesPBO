/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tubs.gaspol.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DORIZU
 */
public class Koneksi {
    private static Connection conn;
    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_NAME = "gaspol_tubes";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/"+DB_NAME;
    private static final String DB_UNAME = "tubes";
    private static final String DB_PASS = "tubes2019!";
    
    public static Connection bukaKoneksi(){
        if(conn == null){
            try{
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(DB_URL, DB_UNAME, DB_PASS);
            }catch(ClassNotFoundException e){
                System.err.format("Class Not Found");
            }catch(SQLException e){
                System.err.format("SQL Static : %s\n%s", e.getSQLState(), e.getMessage());
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }
        return conn;
    
    }
    
    
    
//    private static Connection MySQLConfig;
//    
//    public static Connection configDB()throws SQLException{
//        try{
//            String url = "jdbc:mysql://localhost:3306/db_desktop";
//            String user = "root";
//            String pass = "";
//            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
//            MySQLConfig = DriverManager.getConnection(url, user, pass);
//        }catch(SQLException e){
//            System.out.println("Koneksi DB Gagal : "+e.getMessage());
//        }
//        return MySQLConfig;
//    }
}
