package com.example.upcridekotlin.model

import java.sql.Date
import java.sql.Time

class Viaje(var id: Int, var conductor: Usuario?, var descripcion: String?,
            var puntoPartida: String?, var puntoDestino: String?, var destinoLatitud: Double,
            var destinoLongitud: Double, var partidaLatitud: Double, var partidaLongitud: Double,
            var horaPartida: Time?, var horaLlegada: Time?, var entradaSalida: Int, var fecha: Date?,
            var dia: String?, var estado: String?, var visualizacionHabilitada: Int, var numeroPasajeros: Int,
            var limitePasajeros: Int, var precioBase: Double)
