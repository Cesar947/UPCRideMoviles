//
//  Usuario.swift
//  UPCRideiOS
//
//  Created by Cesar Pizarro Llanos on 11/6/19.
//  Copyright © 2019 upcride. All rights reserved.
//

import Foundation
import Combine

class Usuario:  Identifiable, Codable{
    

    let id: Int = 0
    var codigo: String = ""
    var correoUPC: String = ""
    var contraseña: String = ""
    var dni: String = ""
    var nombres: String = ""
    var apellidos: String = ""
    var ubicacionLatitud: Double = 0.0
    var ubicacionLongitud: Double = 0.0
    var facebook_id: String = ""
    var telefono: String = ""
    var distrito: String = ""
    var rol: String = ""
    var licenciaConducir: String = ""
    var sede : String = ""
    
    init(){
        
    }
    
    init(codigo: String,
            correoUPC: String,
            contraseña: String,
            dni: String,
            nombres: String,
            apellidos: String,
            telefono: String,
            distrito: String,
            sede : String){
            
            self.codigo = codigo
            self.correoUPC = correoUPC
            self.contraseña = contraseña
            self.dni = codigo
            self.nombres = codigo
            self.apellidos = codigo
            self.telefono = telefono
            self.distrito = distrito
            self.sede = sede
            
    }
    
    


}
