/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.RAF;

import java.io.Serializable;

/**
 *
 * @author pablo
 */
public class Alumno implements Serializable {

    private StringBuilder nombre;
    private StringBuilder apellido;
    private StringBuilder direccion;
    private StringBuilder email;
    private int edad;
    private long id_matricula;
    private float nota_media;
    private boolean eliminado;

    public Alumno(String nombre, String apellido, String direccion, String email, int edad, long id_matricula, float nota_media) {
        setNombre(nombre);
        setApellido(apellido);
        setDireccion(direccion);
        setEmail(email);
        this.edad = edad;
        this.id_matricula = id_matricula;
        this.nota_media = nota_media;
        this.eliminado = false;
    }

    public StringBuilder getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = new StringBuilder(nombre);
        this.nombre.setLength(30);
    }

    public StringBuilder getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = new StringBuilder(apellido);
        this.apellido.setLength(30);
    }

    public StringBuilder getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = new StringBuilder(direccion);
        this.direccion.setLength(30);
    }

    public StringBuilder getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = new StringBuilder(email);
        this.email.setLength(50);
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
    
    public static int getSize(){
        return 297;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }
}
