package com.example.upcridekotlin.model


import java.sql.Date
import java.sql.Time

class Viaje{
    var id: Int = 0
    var conductor: Usuario? = null
    var descripcion: String? = ""
    var puntoPartida: String? = ""
    var puntoDestino: String? = ""
    var destinoLatitud: Double = 0.0
    var destinoLongitud: Double = 0.0
    var partidaLatitud: Double = 0.0
    var partidaLongitud: Double = 0.0
    var horaPartida: String? = ""
    var horaLlegada: String? = ""
    var entradaSalida: Int = 0
    var fecha: String? = ""
    var dia: String? = ""
    var estado: String? = ""
    var visualizacionHabilitada: Int? = 0
    var numeroPasajeros: Int? = 0
    var limitePasajeros: Int = 0
    var precioBase: Double = 0.0


    constructor(
        conductor: Usuario?,
        descripcion: String?,
        puntoPartida: String?,
        puntoDestino: String?,
        destinoLatitud: Double,
        destinoLongitud: Double,
        partidaLatitud: Double,
        partidaLongitud: Double,
        horaPartida: String?,
        horaLlegada: String?,
        entradaSalida: Int,
        fecha: String?,
        dia: String?,
        estado: String?,
        visualizacionHabilitada: Int,
        numeroPasajeros: Int,
        limitePasajeros: Int,
        precioBase: Double
    ) {
        this.conductor = conductor
        this.descripcion = descripcion
        this.puntoPartida = puntoPartida
        this.puntoDestino = puntoDestino
        this.destinoLatitud = destinoLatitud
        this.destinoLongitud = destinoLongitud
        this.partidaLatitud = partidaLatitud
        this.partidaLongitud = partidaLongitud
        this.horaPartida = horaPartida
        this.horaLlegada = horaLlegada
        this.entradaSalida = entradaSalida
        this.fecha = fecha
        this.dia = dia
        this.estado = estado
        this.visualizacionHabilitada = visualizacionHabilitada
        this.numeroPasajeros = numeroPasajeros
        this.limitePasajeros = limitePasajeros
        this.precioBase = precioBase
    }

    constructor(
        id: Int,
        conductor: Usuario?,
        descripcion: String?,
        puntoPartida: String?,
        puntoDestino: String?,
        destinoLatitud: Double,
        destinoLongitud: Double,
        partidaLatitud: Double,
        partidaLongitud: Double,
        horaPartida: String,
        horaLlegada: String?,
        entradaSalida: Int,
        fecha: String?,
        dia: String?,
        estado: String?,
        visualizacionHabilitada: Int?,
        numeroPasajeros: Int?,
        limitePasajeros: Int,
        precioBase: Double
    ) {
        this.id = id
        this.conductor = conductor
        this.descripcion = descripcion
        this.puntoPartida = puntoPartida
        this.puntoDestino = puntoDestino
        this.destinoLatitud = destinoLatitud
        this.destinoLongitud = destinoLongitud
        this.partidaLatitud = partidaLatitud
        this.partidaLongitud = partidaLongitud
        this.horaPartida = horaPartida
        this.horaLlegada = horaLlegada
        this.entradaSalida = entradaSalida
        this.fecha = fecha
        this.dia = dia
        this.estado = estado
        this.visualizacionHabilitada = visualizacionHabilitada
        this.numeroPasajeros = numeroPasajeros
        this.limitePasajeros = limitePasajeros
        this.precioBase = precioBase
    }


}

