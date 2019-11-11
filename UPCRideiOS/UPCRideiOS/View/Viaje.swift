//
//  Viaje.swift
//  UPCRideiOS
//
//  Created by Cesar Pizarro Llanos on 11/6/19.
//  Copyright © 2019 upcride. All rights reserved.
//

import Foundation



class Viaje: Codable, Identifiable, ObservableObject{

    
    
       let id: Int = 0
       var conductor: Usuario = Usuario()
       var descripcion: String = ""
       var puntoPartida: String = ""
       var puntoDestino: String = ""
       var destinoLatitud: Double = 0.0
       var destinoLongitud: Double = 0.0
       var partidaLatitud: Double = 0.0
       var partidaLongitud: Double = 0.0
       var horaPartida: String = ""
       var horaLlegada: String = ""
       var entradaSalida: Int = 0
       var fecha: String = ""
       var dia: String = ""
       var estado: String = ""
       var visualizacionHabilitada: Int = 0
       var numeroPasajeros: Int = 0
       var limitePasajeros: Int = 0
       var precioBase: Double = 0.0

    init(){
        
    }
}

