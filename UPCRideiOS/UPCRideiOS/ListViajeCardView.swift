//
//  ListViajeCardView.swift
//  UPCRideiOS
//
//  Created by Developer on 11/6/19.
//  Copyright © 2019 UPC Ride. All rights reserved.
//





import SwiftUI

var cards: [ViajeModel] = [
 ViajeModel(nombreConductor: "Bryan",
 puntoPartida: "Av. Izaguirre",
 puntoDestino: "UPC San Miguel",
 horaPartida: "10: 00",
 horaLlegada: "12:00",
 fecha: "11/11/2019",
 dia: "Lunes",
 descripcion: "Hare un viaje hasta la UPC San Mickey",
 precioBase: 20),
    ViajeModel(nombreConductor: "Bryan",
    puntoPartida: "Av. Izaguirre",
    puntoDestino: "UPC San Miguel",
    horaPartida: "10: 00",
    horaLlegada: "12:00",
    fecha: "11/11/2019",
    dia: "Lunes",
    descripcion: "Hare un viaje hasta la UPC San Mickey",
    precioBase: 20)

]
struct ListViajeCardView: View {

    
    var body: some View {
        VStack
        List {
                       VStack(spacing: 20) {
                        ForEach<[ViajeModel], <#ID: Hashable#>, ViajeCardView>(cards) { card in
                               ViajeCardView(
                                nombreConductor: card.nombreConductor, puntoPartida: card.puntoPartida, puntoDestino: card.puntoDestino, horaPartida: card.horaPartida, horaLlegada: card.horaLlegada, fecha: card.fecha, dia: card.dia, descripcion: card.descripcion, precioBase: card.precioBase)
                            )                 }
                       }
                   }
                   .frame(minWidth: 0, maxWidth: .infinity)
        }
    }


struct ListViajeCardView_Previews: PreviewProvider {
    static var previews: some View {
        Group {
            ListViajeCardView().colorScheme(.light)
            
            ListViajeCardView().colorScheme(.dark)
        }
    }
}

