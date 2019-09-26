package com.example.upcride.activities;

public class ViajeModelo {
    private String nombre, fecha, descripcion, pnt_partida, pnt_destino, n_solis, n_resenias;
    private int foto_perfil;

    public ViajeModelo(){}

    public ViajeModelo(String nombre, String fecha, String descripcion, String pnt_partida, String pnt_destino, String n_solis, String n_resenias, int foto_perfil) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.pnt_partida = pnt_partida;
        this.pnt_destino = pnt_destino;
        this.n_solis = n_solis;
        this.n_resenias = n_resenias;
        this.foto_perfil = foto_perfil;
    }

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

    public String getPnt_partida() {
        return pnt_partida;
    }

    public void setPnt_partida(String pnt_partida) {
        this.pnt_partida = pnt_partida;
    }

    public String getPnt_destino() {
        return pnt_destino;
    }

    public void setPnt_destino(String pnt_destino) {
        this.pnt_destino = pnt_destino;
    }

    public String getN_solis() {
        return n_solis;
    }

    public void setN_solis(String n_solis) {
        this.n_solis = n_solis;
    }

    public String getN_resenias() {
        return n_resenias;
    }

    public void setN_resenias(String n_resenias) {
        this.n_resenias = n_resenias;
    }

    public int getFoto_perfil() {
        return foto_perfil;
    }

    public void setFoto_perfil(int foto_perfil) {
        this.foto_perfil = foto_perfil;
    }
}
