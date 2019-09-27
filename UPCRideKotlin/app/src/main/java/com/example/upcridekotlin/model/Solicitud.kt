package com.example.upcridekotlin.model

import java.sql.Date

class Solicitud{

    var id: Int?=0
    var pasajero: Usuario? = null
    var viaje: Viaje?= null
    var mensaje: String? = ""
    var confirmacionConductor: String?= ""
    var puntoEncuentro: String?= null
    var encuentroLatitud: Double= 0.0
    var encuentroLongitud: Double= 0.0
    var fecha: Date?=null

    constructor(
        pasajero: Usuario?,
        viaje: Viaje?,
        mensaje: String?,
        confirmacionConductor: String?,
        puntoEncuentro: String?,
        encuentroLatitud: Double,
        encuentroLongitud: Double,
        fecha: Date?
    ) {
        this.pasajero = pasajero
        this.viaje = viaje
        this.mensaje = mensaje
        this.confirmacionConductor = confirmacionConductor
        this.puntoEncuentro = puntoEncuentro
        this.encuentroLatitud = encuentroLatitud
        this.encuentroLongitud = encuentroLongitud
        this.fecha = fecha
    }
}