//
//  ViajeCardView.swift
//  UPCRideiOS
//
//  Created by Sebastian on 11/6/19.
//  Copyright © 2019 upcride. All rights reserved.
//

import SwiftUI

struct ViajeCardView: View {
    var viaje: Viaje
    var pasajero: Usuario
    var nombre: String
    var fecha: String
    var descripcion: String
    var puntoPartida: String
    var puntoDestino: String
    
    var body: some View {
        VStack(alignment: .center){
        HStack(alignment: .center) {
            Image("loli")
                  .resizable()
                   .aspectRatio(contentMode: .fill)
                  .frame(width: 30, height: 30)
                  .clipped()
                .cornerRadius(50)
            VStack {
                Text(self.nombre)
                    .font(.caption)
                    .fontWeight(.semibold)
                    .multilineTextAlignment(.center)
                    .padding(.trailing, 30)
                .padding(.bottom, 5)
                
                
                Text(self.fecha)
                    .font(.caption)
                    .fontWeight(.thin)
                    .lineLimit(2)
                    .multilineTextAlignment(.center)
                    .padding(.leading, 3.0)
                
            }.padding(.trailing, 160)
            
        }.padding(.top, 20)
        VStack{
            Text(self.descripcion)
                       .font(.callout)
                       .padding(.top, 10)
                       .padding([.trailing, .leading], 24.5)
                       .multilineTextAlignment(.center)
                   
                   HStack {
                       Image("left")
                           .padding(.trailing, 5)

                       VStack {
                           Text(self.puntoPartida)
                               .padding(.top, 10)
                               .padding(.leading, -100)
                           Image("divider")
                           Text(self.puntoDestino)
                               .multilineTextAlignment(.leading)
                               .padding(.top, 5)
                               .padding(.leading, -80)
                       }
                       .padding(.bottom)
                   }.padding(.trailing, 50)
        }
       
            
          
        HStack {
            /*Button(action: {
                  print("Viaje Comentado")
              }) {
              
                    Text("Resenar")
                
                    
                     // .background(Image("icons_comment"))
            }.padding(1)*/
            /* Button(action: {
                            print("Viaje Solicitado")
                        }) {
                            Text("Solicitar")
                                
                              
                               // .background(Image("icons_rideshare"))
                      }.padding(1)*/
            NavigationLink(destination: SolicitarViajeView(viaje: self.viaje, pasajero: self.pasajero)) {
                Text("Solicitar").foregroundColor(Color.blue)
                }
          
         
        }.padding(.leading, 220)
      }
      .padding()
      .background(Color.white)
      .cornerRadius(28)
      .frame(width: 390, height: 300)
      .shadow(radius: 3, y: 5)
    }
}



struct ViajeCardView_Previews: PreviewProvider {
    static var previews: some View {
        ViajeCardView(viaje: Viaje(), pasajero: Usuario(),nombre: "Brian Miramira", fecha: "2019-11-14" , descripcion: "Viaje de San Martin de Miradflores a San Juan de Burga", puntoPartida:  "Casita", puntoDestino:  "UPC San Miguel")
    }
}
