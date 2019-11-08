//
//  Solicitud.swift
//  UPCRideiOS
//
//  Created by Cesar Pizarro Llanos on 11/6/19.
//  Copyright © 2019 upcride. All rights reserved.
//

import Foundation

struct Solicitud{
    let id: Int
    var pasajero: Usuario
    //var viaje: Viaje
    var mensaje: String
    var confirmacionConductor: String
    var puntoEncuentro: String
    var encuentroLatitud: Double
    var encuentroLongitud: Double
    var fecha: String

}
