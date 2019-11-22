//
//  SolicitudViewMOdel.swift
//  UPCRideiOS
//
//  Created by Cesar Pizarro Llanos on 11/21/19.
//  Copyright © 2019 upcride. All rights reserved.
//

import Foundation

class SolicitudViewModel: ObservableObject{
    
    var id: Int = 0
    @Published var pasajero: Usuario = Usuario()
    @Published var viaje: Viaje = Viaje()
    @Published var mensaje: String = ""
    @Published var confirmacionConductor: String = ""
    @Published var puntoEncuentro: String = ""
    @Published var encuentroLatitud: Double = 0.00
    @Published var encuentroLongitud: Double = 0.00
    @Published var fecha: String = ""

    init(){
        
    }
    
}
