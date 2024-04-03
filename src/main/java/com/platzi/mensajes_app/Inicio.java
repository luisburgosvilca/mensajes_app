/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.platzi.mensajes_app;

import java.sql.Connection;

/**
 *
 * @author ASUS
 */
public class Inicio {
    
    public static void main(String[] args) {
        System.out.println("Hello Platzi");
        
        Conexion conexion = new Conexion();
        
        try {
            Connection cnx = conexion.getConnection();
        } catch (Exception e) {
            System.out.println(e);
        }
        
        
    }
    
}
