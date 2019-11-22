//
//  ViajeViewModel.swift
//  UPCRideiOS
//
//  Created by Sebastian on 11/6/19.
//  Copyright © 2019 upcride. All rights reserved.
//

import Foundation

class ViajeViewModel: Identifiable{
    
  
    
    var viaje: Viaje
    
    
    init(viaje: Viaje){
        self.viaje = viaje
        
    }
    
    
    var id: Int{
        return self.viaje.id
    }
    
    var nombres: String{
        return self.viaje.conductor.nombres + self.viaje.conductor.apellidos
    }
    var fecha: String{
        return self.viaje.fecha
    }

    var descripcion: String{
        return self.viaje.descripcion
    }
    
    var puntoPartida: String{
        return self.viaje.puntoPartida
    }
    
  
    var puntoDestino: String{
        return self.viaje.puntoDestino
    }
   
    
}


