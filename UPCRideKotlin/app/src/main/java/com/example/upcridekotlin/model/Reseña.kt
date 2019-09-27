package com.example.upcridekotlin.model

class Reseña{
    var id: Int = 0
    var contenido: String? =""
    var valoracion: Double? = 0.0
    var cliente: Usuario? = null
    var viaje: Viaje? = null
}