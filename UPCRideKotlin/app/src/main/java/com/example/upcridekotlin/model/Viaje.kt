package com.example.upcridekotlin.model

import android.text.Editable
import java.sql.Date
import java.sql.Time

class Viaje{
    var id: Int = 0
    var conductor: Usuario? = Usuario()
    var descripcion: String? = ""
    var puntoPartida: String? = ""
    var puntoDestino: String? = ""
    var destinoLatitud: Double = 0.0
    var destinoLongitud: Double = 0.0
    var partidaLatitud: Double = 0.0
    var partidaLongitud: Double = 0.0
    var horaPartida: Date? = null
    var horaLlegada: Date? = null
    var entradaSalida: Int = 0
    var fecha: Date? = null
    var dia: String? = ""
    var estado: String? = ""
    var visualizacionHabilitada: Int = 0
    var numeroPasajeros: Int = 0
    var limitePasajeros: Int = 0
    var precioBase: Double = 0.0

    constructor(){
    }

    constructor(
        conductor: Usuario?,
        descripcion: String?,
        puntoPartida: String?,
        puntoDestino: String?,
        destinoLatitud: Double,
        destinoLongitud: Double,
        partidaLatitud: Double,
        partidaLongitud: Double,
        horaPartida: Date?,
        horaLlegada: Date?,
        entradaSalida: Int,
        fecha: Date?,
        dia: String?,
        estado: String?,
        visualizacionHabilitada: Int,
        numeroPasajeros: Int,
        limitePasajeros: Int,
        precioBase: Double){

        this.conductor = conductor
        this.descripcion = descripcion
        this.puntoPartida = puntoPartida
        this.puntoDestino = puntoDestino
        this.destinoLatitud= destinoLatitud
        this.destinoLongitud=destinoLongitud
        this.partidaLatitud=partidaLatitud
        this.partidaLongitud=partidaLongitud
        this.horaPartida=horaPartida
        this.horaLlegada=horaLlegada
        this.entradaSalida=entradaSalida
        this.fecha=fecha
        this.dia=dia
        this.estado=estado
        this.visualizacionHabilitada=visualizacionHabilitada
        this.numeroPasajeros=numeroPasajeros
        this.limitePasajeros=limitePasajeros
        this.precioBase=precioBase
    }

}

