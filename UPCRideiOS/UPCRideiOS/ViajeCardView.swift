//
//  ViajeCardView.swift
//  UPCRideiOS
//
//  Created by Developer on 11/6/19.
//  Copyright © 2019 UPC Ride. All rights reserved.
//

import SwiftUI

struct ViajeCardView: View {
    var nombreConductor: String
    var puntoPartida: String
    var puntoDestino: String
    var horaPartida: String
    var horaLlegada: String
    var fecha: String
    var dia: String
    var descripcion: String
    var precioBase: Double
    
    @State var isShowDetail = false
    
    
    var body: some View {
        VStack(spacing: 0) {
            ContentOfView(nombreConductor: self.nombreConductor,
                puntoPartida: self.puntoPartida,
                          puntoDestino: self.puntoDestino,
                          horaPartida: self.horaPartida,
                          horaLlegada: self.horaLlegada,
                          fecha: self.fecha,
                          dia: self.dia,
                          descripcion: self.descripcion,
                          precioBase: self.precioBase,
                          isShowDetail: $isShowDetail)
                   
                 /*  ScrollView(.vertical, showsIndicators: true) {
                       
                   }
                   .frame(height: isShowDetail ? nil : 0)
                   .animation(.default)*/
               }.onTapGesture {
                   self.isShowDetail.toggle()
               }
               .padding(isShowDetail ? .zero : 10)
               .frame(width: isShowDetail ? UIScreen.main.bounds.width : nil)
               .animation(.default)
               .edgesIgnoringSafeArea(.top)
           }
    }


struct ViajeCardView_Previews: PreviewProvider {
    static var previews: some View {
        ViajeCardView(
        nombreConductor: "Bryan",
        puntoPartida: "Av. Izaguirre",
        puntoDestino: "UPC San Miguel",
        horaPartida: "10: 00",
        horaLlegada: "12:00",
        fecha: "11/11/2019",
        dia: "Lunes",
        descripcion: "Hare un viaje hasta la UPC San Mickey",
        precioBase: 20
        )
    }
}


struct ContentOfView: View {
    var nombreConductor: String
    var puntoPartida: String
    var puntoDestino: String
    var horaPartida: String
    var horaLlegada: String
    var fecha: String
    var dia: String
    var descripcion: String
    var precioBase: Double
    
    @Binding var isShowDetail: Bool
    
    var body: some View {
        
        
        VStack(alignment: .leading) {
            HStack{
                Text(nombreConductor)
                Spacer()
            }
        
            HStack{
                Text(descripcion)
            }
        
            HStack {
                VStack(alignment: .leading) {
                    Text(puntoPartida)
                    Text(puntoDestino)
        
                    Spacer()
                }
                .lineLimit(3)
                
                VStack{
                 Text(horaPartida)
                 Text(horaLlegada)
                
                }
                
                Spacer()
            }
            
            HStack(alignment: .center) {
                Text(fecha)
                Text(dia)
                Spacer()
            }
        }
        .padding()
        .frame(height: isShowDetail ? UIScreen.main.bounds.height * 0.25 : 420)
        
        .cornerRadius(isShowDetail ? 0 : 20)
        .animation(.default)
    }
}
