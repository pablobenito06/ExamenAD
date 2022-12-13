/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.RAF;

import java.io.RandomAccessFile;

/**
 *
 * @author pablo
 */
public class ControladorAlumnos {

    String fichero;

    public ControladorAlumnos(String fichero) {
        this.fichero = fichero;
    }

    public void crearAlumno(Alumno a) {
        try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw");) {
            raf.seek(raf.length());
            escribirAlumno(raf, a);
        } catch (Exception ex) {
            System.out.println("Error al crear la multa");
        }
    }

    public void eliminarAlumno(int i) {
        try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {
            raf.seek(i * Alumno.getSize());
            Alumno aux = auxiliar(i);
            aux.setEliminado(true);
            escribirAlumno(raf, aux);
        } catch (Exception ex) {
            System.out.println("Error al eliminar la multa");
        }
    }

    public void modificarAlumno(int i, Alumno a) {
        try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {
            raf.seek(i * Alumno.getSize());
            escribirAlumno(raf, a);
        } catch (Exception ex) {
            System.out.println("Error al modificar la multa");
        }
    }

    public float consultarMediaGeneral() {
        try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {
            float mediaGeneral;
            double total;
            float suma = 0;
            int contador = 0;
            total = raf.length() / Alumno.getSize();//para saber cuantos objetos hay
            for (int j = 0; j < total; j++) {
                try {
                    byte[] arrayNombre = new byte[60];
                    raf.read(arrayNombre);
                    String nombre = new String(arrayNombre);
                    byte[] arrayApellido = new byte[60];
                    raf.read(arrayApellido);
                    String apellido = new String(arrayApellido);
                    byte[] arrayDireccion = new byte[60];
                    raf.read(arrayDireccion);
                    String direccion = new String(arrayDireccion);
                    byte[] arrayEmail = new byte[100];
                    raf.read(arrayEmail);
                    String email = new String(arrayEmail);
                    int edad = raf.readInt();
                    long matricula = raf.readLong();
                    float media = raf.readFloat();
                    boolean eliminado = raf.readBoolean();

                    if (!eliminado) {
                        contador++;
                        suma += media;
                    }

                } catch (Exception ex) {
                    System.out.println("Error al consultar todas las multas");
                    ex.printStackTrace();
                }
            }
            mediaGeneral = suma / contador;
            return mediaGeneral;
        } catch (Exception ex) {
            System.out.println("Error al consultar todas las multas");
            ex.printStackTrace();
        }
        return 0;
    }
    public void consultarTodos() {
        try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {
            double total;
            total = raf.length() / Alumno.getSize();//para saber cuantos objetos hay
            for (int j = 0; j < total; j++) {
                try {
                    byte[] arrayNombre = new byte[60];
                    raf.read(arrayNombre);
                    String nombre = new String(arrayNombre);
                    byte[] arrayApellido = new byte[60];
                    raf.read(arrayApellido);
                    String apellido = new String(arrayApellido);
                    byte[] arrayDireccion = new byte[60];
                    raf.read(arrayDireccion);
                    String direccion = new String(arrayDireccion);
                    byte[] arrayEmail = new byte[100];
                    raf.read(arrayEmail);
                    String email = new String(arrayEmail);
                    int edad = raf.readInt();
                    long matricula = raf.readLong();
                    float media = raf.readFloat();
                    boolean eliminado = raf.readBoolean();

                    if (!eliminado) {
                        System.out.println(nombre + " " + apellido + " " + direccion + " " + email + " " + edad + " " + matricula + " " + media);
                    }

                } catch (Exception ex) {
                    System.out.println("Error al consultar todas las multas");
                    ex.printStackTrace();
                }
            }
        } catch (Exception ex) {
            System.out.println("Error al consultar todas las multas");
            ex.printStackTrace();
        }
    }

    private void escribirAlumno(RandomAccessFile raf, Alumno a) {
        try {
            raf.writeChars(a.getNombre().toString());
            raf.writeChars(a.getApellido().toString());
            raf.writeChars(a.getDireccion().toString());
            raf.writeChars(a.getEmail().toString());
            raf.writeInt(a.getEdad());
            raf.writeLong(a.getId_matricula());
            raf.writeFloat(a.getNota_media());
            raf.writeBoolean(a.isEliminado());
        } catch (Exception ex) {
            System.out.println("Error al escribir multas");
        }
    }

    private Alumno auxiliar(int i) {
        try (RandomAccessFile raf = new RandomAccessFile(fichero, "rw")) {
            raf.seek(i * Alumno.getSize());
            byte[] arrayNombre = new byte[60];
            raf.read(arrayNombre);
            String nombre = new String(arrayNombre);
            byte[] arrayApellido = new byte[60];
            raf.read(arrayApellido);
            String apellido = new String(arrayApellido);
            byte[] arrayDireccion = new byte[60];
            raf.read(arrayDireccion);
            String direccion = new String(arrayDireccion);
            byte[] arrayEmail = new byte[100];
            raf.read(arrayEmail);
            String email = new String(arrayEmail);
            int edad = raf.readInt();
            long matricula = raf.readLong();
            float media = raf.readFloat();
            boolean eliminado = raf.readBoolean();
            Alumno a = new Alumno(nombre, apellido, direccion, email, edad, matricula, media);
            return a;
        } catch (Exception ex) {
            System.out.println("Error al recuperar multas");
        }
        return null;
    }
}
