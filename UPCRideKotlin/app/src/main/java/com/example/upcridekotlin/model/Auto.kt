package com.example.upcridekotlin.model

class Auto{
    var id: Int? =0
    var placa: String?= null
    var polizaSoat: String?= null
    var marca: String?= null
    var modelo: String?= null
    var limitePersonas: Int?= null
    var conductor: Usuario?= null


    constructor(placa: String?, polizaSoat: String?, marca: String?, modelo: String?, limitePersonas: Int?, conductor: Usuario?) {
        this.placa = placa
        this.polizaSoat = polizaSoat
        this.marca = marca
        this.modelo = modelo
        this.limitePersonas = limitePersonas
        this.conductor = conductor
    }
}



