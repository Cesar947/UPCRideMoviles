package com.example.upcridekotlin.model

import java.sql.Date

class Solicitud(var id: Int?,
                var pasajero: Usuario?,
                var viaje: Viaje?,
                var mensaje: String?,
                var confirmacionConductor: String?,
                var puntoEncuentro: String?,
                var encuentroLatitud: Double,
                var encuentroLongitud: Double,
                var fecha: Date?)