package com.example.upcride.model;

public class Reseña {

    private int id;
    private String contenido;
    private double valoracion;
    private Usuario cliente;
    private Viaje viaje;


    public Reseña(int id, String contenido, double valoracion, Usuario cliente, Viaje viaje) {
        this.id = id;
        this.contenido = contenido;
        this.valoracion = valoracion;
        this.cliente = cliente;
        this.viaje = viaje;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public double getValoracion() {
        return valoracion;
    }

    public void setValoracion(double valoracion) {
        this.valoracion = valoracion;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Viaje getViaje() {
        return viaje;
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }
}
