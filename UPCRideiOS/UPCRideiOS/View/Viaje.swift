//
//  Viaje.swift
//  UPCRideiOS
//
//  Created by Cesar Pizarro Llanos on 11/6/19.
//  Copyright © 2019 upcride. All rights reserved.
//

import Foundation


struct Viaje{
    
      var id: Int
       var conductor: Usuario
       var descripcion: String
       var puntoPartida: String
       var puntoDestino: String
       var destinoLatitud: Double
       var destinoLongitud: Double
       var partidaLatitud: Double
       var partidaLongitud: Double
       var horaPartida: String
       var horaLlegada: String
       var entradaSalida: Int
       var fecha: String
       var dia: String
       var estado: String
       var visualizacionHabilitada: Int
       var numeroPasajeros: Int
       var limitePasajeros: Int
       var precioBase: Double

    
}
