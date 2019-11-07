package com.example.upcridekotlin.model

class ViajeModelo {
    var id: Int? = null
    var nombre: String? = null
    var fecha: String? = null
    var descripcion: String? = null
    var pnt_partida: String? = null
    var pnt_destino: String? = null
    var n_solis: String? = null
    var n_resenias: Int? = null
    var foto_perfil: Int = 0

    constructor() {}

    constructor(
        id: Int,
        nombre: String,
        fecha: String,
        descripcion: String,
        pnt_partida: String,
        pnt_destino: String,
        n_solis: String,
        n_resenias: Int,
        foto_perfil: Int
    ) {
        this.id = id
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
