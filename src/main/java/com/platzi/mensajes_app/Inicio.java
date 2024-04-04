/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.platzi.mensajes_app;

import java.sql.Connection;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class Inicio {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        int opcion = 0;
        
        do{
        
            System.out.println("---------");
            System.out.println("Aplicación de Mensajes");
            System.out.println("1. Crear mensaje");
            System.out.println("2. Listar mensajes");
            System.out.println("3. Editar mensaje");
            System.out.println("4. Eliminar mensaje");
            System.out.println("5. salir");
            
            opcion = scanner.nextInt();
            
            switch(opcion) {
                case 1 -> MensajesService.crearMensaje();
                case 2 -> MensajesService.listarMensaje();
                case 3 -> MensajesService.editarMensaje();
                case 4 -> MensajesService.borrarMensaje();
                case 5 -> {
                }
                default -> throw new AssertionError();
            }
        
        }while(opcion!=5);
        
//        Conexion conexion = new Conexion();
//        
//        try {
//            Connection cnx = conexion.getConnection();
//        } catch (Exception e) {
//            System.out.println(e);
//        }
    }
    
    
}
