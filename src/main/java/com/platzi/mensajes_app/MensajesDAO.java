/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.platzi.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class MensajesDAO {
    
    public static void createMensajeDB(MensajesModel mensaje) {
        
        Conexion dbConnect = new Conexion();
        
        try (Connection conexion = dbConnect.getConnection()){
            
            PreparedStatement ps = null;
            
            try {
                
                String query = "INSERT INTO `mensajes` (`mensaje`, `autor_mensaje`) VALUES (?, ?)";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setString(2, mensaje.getAutor_mensaje());
                ps.executeUpdate();
                System.out.println("Mensaje registrado correctamente");
                
            } catch (SQLException ex) {
                System.out.println(ex);
            } 
            
        } catch(SQLException e) {
            System.out.println(e);
        }
        
    }
    
    public static ArrayList<MensajesModel> leerMensajesDB() {
        
        Conexion dbConnect = new Conexion();
        ArrayList mensajes = new ArrayList<MensajesModel>();
        
        try (Connection conexion = dbConnect.getConnection()){
            
            ResultSet rs = null;
            PreparedStatement ps = null;
            
            String query = "SELECT * FROM mensajes";
            ps = conexion.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                
                MensajesModel message = new MensajesModel();
                message.setId_mensaje(rs.getInt("id_mensaje"));
                message.setMensaje(rs.getString("mensaje"));
                message.setAutor_mensaje(rs.getString("autor_mensaje"));
                message.setFecha_mensaje(rs.getString("fecha_mensaje"));
                
                mensajes.add(message);
            }
            
        }catch(SQLException e){
            System.out.println("No se recueperaron Datos");
            System.out.println(e);
        }
        return mensajes;
    }
    
    public static void borrarMensajeDB(int id_mensaje) {
        
        Conexion dbConnect = new Conexion();
        
        try (Connection conexion = dbConnect.getConnection()){
            
            PreparedStatement ps = null;
            
            String query = "DELETE FROM mensajes WHERE mensajes.id_mensaje = ?";
            ps = conexion.prepareStatement(query);
            ps.setInt(1, id_mensaje);
            int countRowsUpdated = ps.executeUpdate();
            if(countRowsUpdated>0){
                System.out.println("El mensaje con ID: " + id_mensaje+ " ha sido borrado");
            }else{
                System.out.println("No se encontró el mensaje con ID: "+id_mensaje);
            }
            
        }catch(SQLException e){
            System.out.println(e);
            
        }
        
    }
    
    public static void actualizarMensajeDB(MensajesModel mensaje) {
     
        Conexion dbConnect = new Conexion();
        
        try (Connection conexion = dbConnect.getConnection()){
        
            PreparedStatement ps = null;
            
            try {
                String query = "UPDATE mensajes SET mensajes.mensaje = ? WHERE mensajes.id_mensaje = ?";
                ps = conexion.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setInt(2, mensaje.getId_mensaje());
                ps.executeUpdate();
                
                System.out.println("Mensaje actualizado correctamente");
                
            } catch (SQLException ex) {
                System.out.println("No se pudo actualizar el mensaje");
                System.out.println(ex);
                
            }
            
        }catch(SQLException e){
            System.out.println(e);
        }
        
    }
    
}
