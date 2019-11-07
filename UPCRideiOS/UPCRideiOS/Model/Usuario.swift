//
//  Usuario.swift
//  UPCRideiOS
//
//  Created by Cesar Pizarro Llanos on 11/6/19.
//  Copyright © 2019 upcride. All rights reserved.
//

import Foundation
import Combine

class Usuario: ObservableObject, Identifiable{
    

    
    var didChange = PassthroughSubject<Void, Never>()
    
    var id: Int = 0
    var codigo: String = "" {didSet {update()}}
    var correoUPC: String = "" {didSet {update()}}
    var contraseña: String = "" {didSet {update()}}
    var dni: String = "" {didSet {update()}}
    var nombres: String = "" {didSet {update()}}
    var apellidos: String = "" {didSet {update()}}
    var ubicacionLatitud: Double = 0.0
    var ubicacionLongitud: Double = 0.0
    var facebook_id: String = ""
    var telefono: String = "" {didSet {update()}}
    var distrito: String = "" {didSet {update()}}
    var rol: Character = "P"
    var licenciaConducir: String = ""
    var sedes: [String] = ["-", "San Miguel", "San Isidro", "Monterrico", "Villa"]
    var sede = 0 {didSet {update()}}
    
    var isValid: Bool{
        
        
        if codigo.isEmpty || correoUPC.isEmpty || contraseña.isEmpty || dni.isEmpty || nombres.isEmpty || apellidos.isEmpty || telefono.isEmpty || sede < 1 {
            
            return false
        }
        return true
    }
    
    func update(){
        didChange.send(())
    }
    

}
