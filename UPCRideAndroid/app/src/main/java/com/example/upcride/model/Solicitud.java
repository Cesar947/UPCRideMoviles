package com.example.upcride.model;

import java.sql.Date;

public class Solicitud {


    private Integer id;
    private Usuario pasajero;
    private Viaje viaje;
    private String mensaje;
    private String confirmacionConductor;
    private String puntoEncuentro;
    private double encuentroLatitud;
    private double encuentroLongitud;
    private Date fecha;

    public Solicitud(Integer id,
                     Usuario pasajero,
                     Viaje viaje,
                     String mensaje,
                     String confirmacionConductor,
                     String puntoEncuentro,
                     double encuentroLatitud,
                     double encuentroLongitud,
                     Date fecha) {
        this.id = id;
        this.pasajero = pasajero;
        this.viaje = viaje;
        this.mensaje = mensaje;
        this.confirmacionConductor = confirmacionConductor;
        this.puntoEncuentro = puntoEncuentro;
        this.encuentroLatitud = encuentroLatitud;
        this.encuentroLongitud = encuentroLongitud;
        this.fecha = fecha;
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

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getConfirmacionConductor() {
        return confirmacionConductor;
    }

    public void setConfirmacionConductor(String confirmacionConductor) {
        this.confirmacionConductor = confirmacionConductor;
    }

    public String getPuntoEncuentro() {
        return puntoEncuentro;
    }

    public void setPuntoEncuentro(String puntoEncuentro) {
        this.puntoEncuentro = puntoEncuentro;
    }

    public double getEncuentroLatitud() {
        return encuentroLatitud;
    }

    public void setEncuentroLatitud(double encuentroLatitud) {
        this.encuentroLatitud = encuentroLatitud;
    }

    public double getEncuentroLongitud() {
        return encuentroLongitud;
    }

    public void setEncuentroLongitud(double encuentroLongitud) {
        this.encuentroLongitud = encuentroLongitud;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
