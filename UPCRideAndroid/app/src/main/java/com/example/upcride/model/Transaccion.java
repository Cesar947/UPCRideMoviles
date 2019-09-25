package com.example.upcride.model;

public class Transaccion {

    private Integer id;
    private Usuario pasajero;
    private Viaje viaje;

    public Transaccion(Integer id, Usuario pasajero, Viaje viaje) {
        this.id = id;
        this.pasajero = pasajero;
        this.viaje = viaje;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getPasajero() {
        return pasajero;
    }

    public void setPasajero(Usuario pasajero) {
        this.pasajero = pasajero;
    }

    public Viaje getViaje() {
        return viaje;
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }
}
