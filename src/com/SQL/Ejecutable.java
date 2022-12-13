/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.SQL;

import com.RAF.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pablo
 */
public class Ejecutable {

    public static void main(String[] args) {

        Alumno a = new Alumno("pepe", "lopez", "calle ronda", "pepel@gmail.com", 20, 9943567, 9);
        Alumno a2 = new Alumno("ana", "garcia", "calle alamillo", "anag@gmail.com", 21, 1283485, 8);
        Alumno a2mod = new Alumno("ana", "garcia", "calle alamillo", "anag@gmail.com", 19, 1283485, 8);
        Alumno a3 = new Alumno("mario", "vazquez", "calle almendros", "mariov@gmail.com", 21, 6209665, 6);
        try {
            ControladorAlumnosSQL ca = new ControladorAlumnosSQL("./alumnos.db");
            ca.crearAlumno(a);
            ca.crearAlumno(a2);
            ca.consultarTodos();
            ca.eliminarAlumno(0);
            ca.modificarAlumno(1, a2mod);
            ca.consultarTodos();
            ca.crearAlumno(a3);
            ca.consultarMediaGeneral();
        } catch (Exception ex) {
            Logger.getLogger(Ejecutable.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
