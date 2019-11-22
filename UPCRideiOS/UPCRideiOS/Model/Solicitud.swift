//
//  Solicitud.swift
//  UPCRideiOS
//
//  Created by Cesar Pizarro Llanos on 11/6/19.
//  Copyright © 2019 upcride. All rights reserved.
//

import Foundation

struct Solicitud: Codable{
    let id: Int = 0
    var pasajero: Usuario = Usuario()
    var viaje: Viaje = Viaje()
    var mensaje: String = ""
    var confirmacionConductor: String = ""
    var puntoEncuentro: String = ""
    var encuentroLatitud: Double = 0.00
    var encuentroLongitud: Double = 0.00
    var fecha: String = ""

    
    init(solicitud: SolicitudViewModel){
        
        self.pasajero = solicitud.pasajero
        self.viaje =  solicitud.viaje
        self.mensaje = solicitud.mensaje
        self.confirmacionConductor = solicitud.confirmacionConductor
        self.puntoEncuentro = solicitud.puntoEncuentro
        self.encuentroLatitud = solicitud.encuentroLatitud
        self.encuentroLongitud = solicitud.encuentroLongitud
        self.fecha = solicitud.fecha
        
    }
}
