/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SQL;

import java.io.Serializable;

/**
 *
 * @author pablo
 */
public class Alumno implements Serializable {

    private String nombre;
    private String apellido;
    private String direccion;
    private String email;
    private int edad;
    private long id_matricula;
    private float nota_media;
    private boolean eliminado;

    public Alumno(String nombre, String apellido, String direccion, String email, int edad, long id_matricula, float nota_media) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.email = email;
        this.edad = edad;
        this.id_matricula = id_matricula;
        this.nota_media = nota_media;
        this.eliminado = false;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public long getId_matricula() {
        return id_matricula;
    }

    public void setId_matricula(long id_matricula) {
        this.id_matricula = id_matricula;
    }

    public float getNota_media() {
        return nota_media;
    }

    public void setNota_media(float nota_media) {
        this.nota_media = nota_media;
    }
}
