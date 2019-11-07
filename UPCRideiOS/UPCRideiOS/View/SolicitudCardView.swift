//
//  SolicitudCardView.swift
//  UPCRideiOS
//
//  Created by Sebastian on 11/7/19.
//  Copyright © 2019 upcride. All rights reserved.
//

import SwiftUI

struct SolicitudCardView: View {
    var nombre: String
    var fecha: String
    var mensaje: String

    
    var body: some View {
      VStack(alignment: .center) {
        HStack(alignment: .center) {
            Image("loli")
                  .resizable()
                   .aspectRatio(contentMode: .fill)
                  .frame(width: 30, height: 30)
                  .clipped()
                .cornerRadius(50)
                .padding(.leading, 10)
            VStack {
                Text(self.nombre)
                    .font(.caption)
                    .fontWeight(.semibold)
                    .multilineTextAlignment(.center)
                    .padding(.leading, 5)
                .padding(.bottom, 5)
            }
            
            Spacer(minLength: 10)
            
            VStack {
                Text(self.fecha)
                .font(.caption)
                .fontWeight(.thin)
                .lineLimit(2)
                    .multilineTextAlignment(.center)
            }
            
        }.padding(.top, 20)
          
        Text(self.mensaje)
            .font(.callout)
            .multilineTextAlignment(.leading)
            .padding(.top, 10)
         .padding([.trailing, .leading], 24.5)
          
        HStack {
            Button(action: {
                  print("Solicitud Aceptada")
              }) {
                  Text(" ")
                      .foregroundColor(Color.black)
                    .padding(.bottom, 2)
                    .padding(.trailing, 50)
                    .background(Image(systemName: "checkmark.circle"))
            }
            
            Button(action: {
                  print("Solicitud Rechazada")
              }) {
                  Text(" ")
                      .foregroundColor(Color.black)
                    .padding(.bottom, 2)
                    .background(Image(systemName: "multiply.circle"))
            }.padding(5)
        }.padding(.leading, 250)
            .padding(.top, 5)
      }
      .padding()
      .background(Color.white)
      .cornerRadius(28)
      .frame(width: 390, height: 170)
      .shadow(radius: 3, y: 5)
    }
}

struct SolicitudCardView_Previews: PreviewProvider {
    static var previews: some View {
        SolicitudCardView(nombre: "Sebastian Pinillos", fecha: "2019-07-19", mensaje: "Hola quiero viaje")
    }
}
