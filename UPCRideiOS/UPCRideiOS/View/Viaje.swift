//
//  Viaje.swift
//  UPCRideiOS
//
//  Created by Cesar Pizarro Llanos on 11/6/19.
//  Copyright © 2019 upcride. All rights reserved.
//

import Foundation


/*struct Viaje: Encodable, Decodable{
    
    
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

  enum CodingKeys: String, CodingKey {
          case id
          case conductor
          case descripcion = "descripcion"
          case puntoPartida = "punto1"
          case puntoDestino = "punto2"
          case destinoLatitud
          case destinoLongitud
          case partidaLatitud
          case partidaLongitud
          case horaPartida = "horaP"
          case horaLlegada = "horaL"
          case entradaSalida
          case fecha = "fecha"
          case dia = "dia"
          case estado = "estado"
          case visualizacionHabilitada
          case numeroPasajeros
          case limitePasajeros
          case precioBase
         
      }
    
   init(from decoder: Decoder) throws {
       let values = try decoder.container(keyedBy: CodingKeys.self)
       id = try values.decode(Int.self, forKey: .id)
       conductor = try values.decode(Usuario.self, forKey: .conductor)
       descripcion = try values.decode(String.self, forKey: .descripcion)
       puntoPartida = try values.decode(String.self, forKey: .puntoPartida)
       puntoDestino = try values.decode(String.self, forKey: .puntoDestino)
       destinoLatitud = try values.decode(Double.self, forKey: .destinoLatitud)
       destinoLongitud = try values.decode(Double.self, forKey: .destinoLongitud)
       partidaLatitud = try values.decode(Double.self, forKey: .partidaLatitud)
       partidaLongitud = try values.decode(Double.self, forKey: .partidaLongitud)
       horaPartida = try values.decode(String.self, forKey: .horaPartida)
       horaLlegada = try values.decode(String.self, forKey: .horaLlegada)
       entradaSalida = try values.decode(Int.self, forKey: .entradaSalida)
       fecha = try values.decode(String.self, forKey: .fecha)
       dia = try values.decode(String.self, forKey: .dia)
       estado = try values.decode(String.self, forKey: .estado)
       visualizacionHabilitada = try values.decode(Int.self, forKey: .visualizacionHabilitada)
       numeroPasajeros = try values.decode(Int.self, forKey: .numeroPasajeros)
       limitePasajeros = try values.decode(Int.self, forKey: .limitePasajeros)
       precioBase = try values.decode(Double.self, forKey: .precioBase)
    }
    
}
*/
