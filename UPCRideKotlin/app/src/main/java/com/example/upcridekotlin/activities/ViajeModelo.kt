package com.example.upcridekotlin.activities

class ViajeModelo {
    var nombre: String? = null
    var fecha: String? = null
    var descripcion: String? = null
    var pnt_partida: String? = null
    var pnt_destino: String? = null
    var n_solis: String? = null
    var n_resenias: String? = null
    var foto_perfil: Int = 0

    constructor() {}

    constructor(
        nombre: String,
        fecha: String,
        descripcion: String,
        pnt_partida: String,
        pnt_destino: String,
        n_solis: String,
        n_resenias: String,
        foto_perfil: Int
    ) {
        this.nombre = nombre
        this.fecha = fecha
        this.descripcion = descripcion
        this.pnt_partida = pnt_partida
        this.pnt_destino = pnt_destino
        this.n_solis = n_solis
        this.n_resenias = n_resenias
        this.foto_perfil = foto_perfil
    }
}
