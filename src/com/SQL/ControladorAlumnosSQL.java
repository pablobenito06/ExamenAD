/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SQL;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pablo
 */
public class ControladorAlumnosSQL {

    private String URL;
    Connection conexion = null;

    static {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (Exception e) {
        }
    }

    public ControladorAlumnosSQL(String fileName) throws Exception {
        this.URL = "jdbc:sqlite:" + fileName;
        this.conexion = DriverManager.getConnection(URL);
    }

    public void crearAlumno(Alumno a) {
        String sql = "INSERT INTO ALUMNOS(NOMBRE,APELLIDO,DIRECCION,EMAIL,EDAD,MATRICULA,NOTA_MEDIA,ELIMINADO) VALUES(?,?,?,?,?,?,?,?) ";
        try (PreparedStatement ps = this.conexion.prepareStatement(sql)) {
            ps.setString(1, a.getNombre());
            ps.setString(1, a.getApellido());
            ps.setString(3, a.getDireccion());
            ps.setString(4, a.getEmail());
            ps.setInt(5, a.getEdad());
            ps.setLong(6, a.getId_matricula());
            ps.setFloat(7, a.getNota_media());
            ps.setBoolean(8, a.isEliminado());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorAlumnosSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarAlumno(int id) {
        String sql = "UPDATE ALUMNOS SET ELIMINADO = ? WHERE ID = ?";
        try (PreparedStatement ps = this.conexion.prepareStatement(sql)) {
            ps.setBoolean(1, true);
            ps.setInt(2, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorAlumnosSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarAlumno(int id, Alumno a) {
        String sql = "UPDATE ALUMNOS SET NOMBRE = ?, APELLIDO = ?, DIRECCION = ?, EMAIL = ?,EDAD = ?, MATRICULA = ?, NOTA_MEDIA = ? WHERE ID = ?";
        try (PreparedStatement ps = this.conexion.prepareStatement(sql)) {
            ps.setString(1, a.getNombre());
            ps.setString(2, a.getApellido());
            ps.setString(3, a.getDireccion());
            ps.setString(4, a.getEmail());
            ps.setInt(5, a.getEdad());
            ps.setLong(6, a.getId_matricula());
            ps.setFloat(7, a.getNota_media());
            ps.setInt(8, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ControladorAlumnosSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void consultarMediaGeneral(){
        String sql = "SELECT AVG(NOTA_MEDIA) FROM ALUMNOS WHERE ID = ID";
        ResultSet res = null;
        try (PreparedStatement ps = this.conexion.prepareStatement(sql)) {
            res = ps.executeQuery();
            while(res.next()){
                res.getFloat(1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorAlumnosSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void consultarTodos(){
        String sql = "SELECT * FROM ALUMNOS";
        ResultSet res = null;
        try (PreparedStatement ps = this.conexion.prepareStatement(sql)) {
            res = ps.executeQuery();
            while(res.next()){
                System.out.print(res.getString("NOMBRE" + "|"));
                System.out.print(res.getString("APELLIDO"+ "|"));
                System.out.print(res.getString("DIRECCION"+ "|"));
                System.out.print(res.getString("EMAIL"+ "|"));
                System.out.print(res.getInt("EDAD"+ "|"));
                System.out.print(res.getLong("MATRICULA"+ "|"));
                System.out.print(res.getFloat("NOTA_MEDIA"));
                System.out.println("");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ControladorAlumnosSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
