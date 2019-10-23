package com.example.upcridekotlin.model

class SolicitudModelo {
    var nombre: String? = null
    var fecha: String? = null
    var descripcion: String? = null
    var foto_perfil: Int = 0

    constructor(nombre: String, fecha: String, descripcion: String, foto_perfil: Int) {
        this.nombre = nombre
        this.fecha = fecha
        this.descripcion = descripcion
        this.foto_perfil = foto_perfil
    }

    constructor() {}
}
