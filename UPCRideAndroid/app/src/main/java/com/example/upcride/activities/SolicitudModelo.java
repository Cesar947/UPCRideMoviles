package com.example.upcride.activities;

public class SolicitudModelo {
    private String nombre, fecha, descripcion;
    private int foto_perfil;

    public SolicitudModelo(String nombre, String fecha, String descripcion, int foto_perfil) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.foto_perfil = foto_perfil;
    }

    public SolicitudModelo(){}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getFoto_perfil() {
        return foto_perfil;
    }

    public void setFoto_perfil(int foto_perfil) {
        this.foto_perfil = foto_perfil;
    }
}
