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
    
    init(usuario: UsuarioPasajeroViewModel){
            
        self.codigo = usuario.codigo
            self.correoUPC = usuario.correoUPC
            self.contraseña = usuario.contraseña
            self.dni = usuario.dni
            self.nombres = usuario.nombres
            self.apellidos = usuario.apellidos
            self.telefono = usuario.telefono
            self.distrito = usuario.distrito
            self.sede = usuario.sede
            self.ubicacionLatitud = usuario.ubicacionLatitud
            self.ubicacionLongitud = usuario.ubicacionLongitud
            
    }
    
    init(usuario: UsuarioConductorViewModel){
        self.codigo = usuario.codigo
        self.correoUPC = usuario.correoUPC
        self.contraseña = usuario.contraseña
        self.dni = usuario.dni
        self.nombres = usuario.nombres
        self.apellidos = usuario.apellidos
        self.telefono = usuario.telefono
        self.distrito = usuario.distrito
        self.sede = usuario.sede
        
        
        self.ubicacionLatitud = usuario.ubicacionLatitud
        self.ubicacionLongitud = usuario.ubicacionLongitud
        self.facebook_id = usuario.facebook_id
        self.licenciaConducir = usuario.licenciaConducir
    }
    
    


}
