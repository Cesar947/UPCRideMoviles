//
//  UsuarioPrueba.swift
//  UPCRideiOS
//
//  Created by Sebastian on 11/7/19.
//  Copyright © 2019 upcride. All rights reserved.
//

import Foundation

class UsuarioPasajeroViewModel: ObservableObject {
    
   
   @Published var codigo: String = ""
   @Published var correoUPC: String = ""
   @Published var contraseña: String = ""
   @Published var dni: String = ""
   @Published var nombres: String = ""
   @Published var apellidos: String = ""
   @Published var telefono: String = ""
   @Published var distrito: String = ""
   @Published var sede : String = ""
    
    
    init(){
        
    }
}

