/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.platzi.mensajes_app;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public class MensajesService {
    
    public static void crearMensaje() {
        
        try (Scanner sc = new Scanner(System.in)) {
            System.out.println("Escribe tu mensaje:");
            String mensaje = sc.nextLine();
            
            System.out.println("Tu nombre: ");
            String autor = sc.nextLine();
            
            MensajesModel registro = new MensajesModel();
            registro.setMensaje(mensaje);
            registro.setAutor_mensaje(autor);
            MensajesDAO.createMensajeDB(registro);
        }
    }
    
    public static void listarMensaje() {
        
        ArrayList<MensajesModel> mensajes = MensajesDAO.leerMensajesDB();
        
        for (MensajesModel mensaje : mensajes) {
            System.out.println("============================");
                System.out.println("ID: "+mensaje.getId_mensaje());
                System.out.println("Mensaje: "+mensaje.getMensaje());
                System.out.println("Autor: "+mensaje.getAutor_mensaje());
                System.out.println("Fecha: "+mensaje.getFecha_mensaje());
            System.out.println("============================");
        }
        
    }
    
    public static void borrarMensaje() {
        
        System.out.println("Ingrese el ID de mensaje que desea Borrar: ");
        try (Scanner sc = new Scanner(System.in)) {
            int id_mensaje = sc.nextInt();
            
            System.out.println("¿Está seguro de eliminar el mensaje con ID: "+id_mensaje+"?");
            System.out.println("1. Sí, eliminar el mensaje");
            System.out.println("2. No, conservar el mensaje");
            
            int opcionEliminar = sc.nextInt();
            if(opcionEliminar==1){
                MensajesDAO.borrarMensajeDB(id_mensaje);
            }
        }
    }
    
    public static void editarMensaje() {
        
        Scanner sc = new Scanner(System.in);
            
            int id_mensaje;
            String mensaje;
            System.out.println("Ingrese el ID del mensaje a Editar: ");
            
            id_mensaje = Integer.parseInt(sc.nextLine());
            
            System.out.println("Ingrese el nuevo mensaje: ");
            mensaje = sc.nextLine();
            
            System.out.println("El mensaje es: "+mensaje);
            
            MensajesModel message = new MensajesModel();
            message.setId_mensaje(id_mensaje);
            message.setMensaje(mensaje);
            
            MensajesDAO.actualizarMensajeDB(message);
            
    }
    
}
