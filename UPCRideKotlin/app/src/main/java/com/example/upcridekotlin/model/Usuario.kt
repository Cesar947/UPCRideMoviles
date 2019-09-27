package com.example.upcridekotlin.model

class Usuario {

    var id: Int =0
    var codigo: String? = null
    var correoUPC: String? = null
    var contraseña: String? = null
    var dni: String? = null
    var nombres: String? = null
    var apellidos: String? = null
    var ubicacionLatitud: Double = 0.toDouble()
    var ubicacionLongitud: Double = 0.toDouble()
    var facebook_id: String? = null
    var telefono: String? = null
    var distrito: String? = null
    var rol: Char = ' '
    var licenciaConducir: String? = null
    var sede: String? = null



    constructor(id:Int, codigo: String, correoUPC: String, contraseña: String, dni:String, nombres: String, apellidos: String, ubicacionLatitud: Double,
                ubicacionLongitud: Double, facebook_id: String, telefono: String, distrito: String, rol: Char, licenciaConducir: String, sede: String) {

        this.id = id;
        this.codigo = codigo
        this.correoUPC = correoUPC
        this.contraseña = contraseña
        this.dni = dni
        this.nombres = nombres
        this.apellidos = apellidos
        this.ubicacionLatitud = ubicacionLatitud
        this.ubicacionLongitud = ubicacionLongitud
        this.facebook_id = facebook_id
        this.telefono = telefono
        this.distrito = distrito
        this.rol = rol
        this.licenciaConducir = licenciaConducir
        this.sede = sede
    }

    constructor(codigo: String, correoUPC: String, contraseña: String,dni:String,  nombres: String, apellidos: String, ubicacionLatitud: Double,
                ubicacionLongitud: Double, facebook_id: String, telefono: String, distrito: String, rol: Char, licenciaConducir: String, sede: String) {

        this.codigo = codigo
        this.correoUPC = correoUPC
        this.contraseña = contraseña
        this.dni = dni
        this.nombres = nombres
        this.apellidos = apellidos
        this.ubicacionLatitud = ubicacionLatitud
        this.ubicacionLongitud = ubicacionLongitud
        this.facebook_id = facebook_id
        this.telefono = telefono
        this.distrito = distrito
        this.rol = rol
        this.licenciaConducir = licenciaConducir
        this.sede = sede
    }

    //Pasajero
    constructor(codigo: String, correoUPC: String, contraseña: String,dni:String,  nombres: String, apellidos: String, ubicacionLatitud: Double,
                ubicacionLongitud: Double, telefono: String, distrito: String, rol: Char, sede: String) {

        this.codigo = codigo
        this.correoUPC = correoUPC
        this.contraseña = contraseña
        this.dni = dni
        this.nombres = nombres
        this.apellidos = apellidos
        this.ubicacionLatitud = ubicacionLatitud
        this.ubicacionLongitud = ubicacionLongitud
        this.telefono = telefono
        this.distrito = distrito
        this.rol = rol
        this.sede = sede
    }



}