//
//  Usuario.swift
//  UPCRideiOS
//
//  Created by Cesar Pizarro Llanos on 11/6/19.
//  Copyright © 2019 upcride. All rights reserved.
//

import Foundation
import Combine

class Usuario:  Identifiable, Decodable{
    

    var id: Int
    var codigo: String
    var correoUPC: String
    var contraseña: String
    var dni: String
    var nombres: String
    var apellidos: String
    var ubicacionLatitud: Double
    var ubicacionLongitud: Double
    var facebook_id: String
    var telefono: String
    var distrito: String
    var rol: String
    var licenciaConducir: String
    var sede : String
 
    
    enum CodingKeys: String, CodingKey {
        case id
        case codigo = "codigo"
        case correoUPC = "correo"
        case contraseña = "contrasena"
        case dni = "dni"
        case nombres = "nombres"
        case apellidos = "apellidos"
        case ubicacionLatitud
        case ubicacionLongitud
        case facebook_id = "fb"
        case telefono = "telefono"
        case distrito = "distrito"
        case rol = "P"
        case licenciaConducir = "licencia"
        case sede
    }
    
  required init(from decoder: Decoder) throws {
          let values = try decoder.container(keyedBy: CodingKeys.self)
          id = try values.decode(Int.self, forKey: .id)
          codigo = try values.decode(String.self, forKey: .codigo)
          correoUPC = try values.decode(String.self, forKey: .correoUPC)
          contraseña = try values.decode(String.self, forKey: .contraseña)
          dni = try values.decode(String.self, forKey: .dni)
          nombres = try values.decode(String.self, forKey: .nombres)
          apellidos = try values.decode(String.self, forKey: .apellidos)
          ubicacionLatitud = try values.decode(Double.self, forKey: .ubicacionLongitud)
          ubicacionLongitud = try values.decode(Double.self, forKey: .ubicacionLongitud)
          facebook_id = try values.decode(String.self, forKey: .facebook_id)
          telefono = try values.decode(String.self, forKey: .telefono )
          distrito = try values.decode(String.self, forKey: .distrito)
          rol = try values.decode(String.self, forKey: .rol)
          licenciaConducir = try values.decode(String.self, forKey: .licenciaConducir )
          sede = try values.decode(String.self, forKey: .sede)
         
       }
    
    
    
    
    

}
