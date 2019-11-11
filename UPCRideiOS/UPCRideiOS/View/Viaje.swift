//
//  Viaje.swift
//  UPCRideiOS
//
//  Created by Cesar Pizarro Llanos on 11/6/19.
//  Copyright © 2019 upcride. All rights reserved.
//

import Foundation



class Viaje: Codable, Identifiable{
    
      let id: Int
      let conductor: Usuario
      let descripcion: String
      let puntoPartida: String
      let puntoDestino: String
      let destinoLatitud: Double
      let destintoLongitud: Double
      let partidaLatitud: Double
      let partidaLongitud: Double
      let horaPartida: String
      let horaLlegada: String
      let entradaSalida: Int
      let fecha: String
      let dia: String
      let estado: String
      let visualizacionHabilitada: Int
      let numeroPasajeros: Int
      let limitePasajeros: Int
      let precioBase: Double

   
  
    
    
}

