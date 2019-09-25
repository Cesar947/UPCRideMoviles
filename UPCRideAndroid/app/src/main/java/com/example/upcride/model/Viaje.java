package com.example.upcride.model;

import java.sql.Date;
import java.sql.Time;

public class Viaje {

    private int id;
    private Usuario conductor;
    private String descripcion;
    private String puntoPartida;
    private String puntoDestino;
    private double destinoLatitud;
    private double destinoLongitud;
    private double partidaLatitud;
    private double partidaLongitud;
    private Time horaPartida;
    private Time horaLlegada;
    private int entradaSalida;
    private Date fecha;
    private String dia;
    private String estado;
    private int visualizacionHabilitada;
    private int numeroPasajeros;
    private int limitePasajeros;
    private double precioBase;

    public Viaje(int id, Usuario conductor, String descripcion, String puntoPartida, String puntoDestino, double destinoLatitud, double destinoLongitud, double partidaLatitud, double partidaLongitud, Time horaPartida, Time horaLlegada, int entradaSalida, Date fecha, String dia, String estado, int visualizacionHabilitada, int numeroPasajeros, int limitePasajeros, double precioBase) {
        this.id = id;
        this.conductor = conductor;
        this.descripcion = descripcion;
        this.puntoPartida = puntoPartida;
        this.puntoDestino = puntoDestino;
        this.destinoLatitud = destinoLatitud;
        this.destinoLongitud = destinoLongitud;
        this.partidaLatitud = partidaLatitud;
        this.partidaLongitud = partidaLongitud;
        this.horaPartida = horaPartida;
        this.horaLlegada = horaLlegada;
        this.entradaSalida = entradaSalida;
        this.fecha = fecha;
        this.dia = dia;
        this.estado = estado;
        this.visualizacionHabilitada = visualizacionHabilitada;
        this.numeroPasajeros = numeroPasajeros;
        this.limitePasajeros = limitePasajeros;
        this.precioBase = precioBase;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getConductor() {
        return conductor;
    }

    public void setConductor(Usuario conductor) {
        this.conductor = conductor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPuntoPartida() {
        return puntoPartida;
    }

    public void setPuntoPartida(String puntoPartida) {
        this.puntoPartida = puntoPartida;
    }

    public String getPuntoDestino() {
        return puntoDestino;
    }

    public void setPuntoDestino(String puntoDestino) {
        this.puntoDestino = puntoDestino;
    }

    public double getDestinoLatitud() {
        return destinoLatitud;
    }

    public void setDestinoLatitud(double destinoLatitud) {
        this.destinoLatitud = destinoLatitud;
    }

    public double getDestinoLongitud() {
        return destinoLongitud;
    }

    public void setDestinoLongitud(double destinoLongitud) {
        this.destinoLongitud = destinoLongitud;
    }

    public double getPartidaLatitud() {
        return partidaLatitud;
    }

    public void setPartidaLatitud(double partidaLatitud) {
        this.partidaLatitud = partidaLatitud;
    }

    public double getPartidaLongitud() {
        return partidaLongitud;
    }

    public void setPartidaLongitud(double partidaLongitud) {
        this.partidaLongitud = partidaLongitud;
    }

    public Time getHoraPartida() {
        return horaPartida;
    }

    public void setHoraPartida(Time horaPartida) {
        this.horaPartida = horaPartida;
    }

    public Time getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(Time horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public int getEntradaSalida() {
        return entradaSalida;
    }

    public void setEntradaSalida(int entradaSalida) {
        this.entradaSalida = entradaSalida;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public int getVisualizacionHabilitada() {
        return visualizacionHabilitada;
    }

    public void setVisualizacionHabilitada(int visualizacionHabilitada) {
        this.visualizacionHabilitada = visualizacionHabilitada;
    }

    public int getNumeroPasajeros() {
        return numeroPasajeros;
    }

    public void setNumeroPasajeros(int numeroPasajeros) {
        this.numeroPasajeros = numeroPasajeros;
    }

    public int getLimitePasajeros() {
        return limitePasajeros;
    }

    public void setLimitePasajeros(int limitePasajeros) {
        this.limitePasajeros = limitePasajeros;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }
}
