//
//  ViajePrueba.swift
//  UPCRideiOS
//
//  Created by Sebastian on 11/6/19.
//  Copyright © 2019 upcride. All rights reserved.
//

import Foundation

struct ViajePrueba : Identifiable {
    
    var id = UUID()
    
    var nombre = "Brian Miramira"
    var fecha = "2019-06-11"
    var descripcion = "Viaje de San Martin de Miradflores a San Juan de Burga"
    var puntoPartida = "Casita"
    var puntoDestino = "UPC San Miguel"
}

let viajesPrueba: [ViajePrueba] = [
    .init(),
    .init(),
    .init()
]
