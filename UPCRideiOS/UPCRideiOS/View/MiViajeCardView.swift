//
//  MiViajeCardView.swift
//  UPCRideiOS
//
//  Created by Sebastian on 11/7/19.
//  Copyright © 2019 upcride. All rights reserved.
//

import SwiftUI

struct MiViajeCardView: View {
    var nombre: String
    var fecha: String
    var puntoPartida: String
    var puntoDestino: String
    
    var body: some View {
      VStack(alignment: .center) {
        HStack(alignment: .center) {
            VStack {
                           Text(self.nombre)
                               .font(.caption)
                               .fontWeight(.semibold)
                               .multilineTextAlignment(.center)
                               .padding(.trailing, 10)
                           .padding(.bottom, 5)
                           
                           
                           Text(self.fecha)
                               .font(.caption)
                               .fontWeight(.thin)
                               .lineLimit(2)
                               .multilineTextAlignment(.center)
                               .padding(.leading, 3.0)
                           
                       }
            Image("loli")
                  .resizable()
                   .aspectRatio(contentMode: .fill)
                  .frame(width: 30, height: 30)
                  .clipped()
                .cornerRadius(50)
           
            
        }.padding(.top, 20)
            .padding(.leading, 180)
        
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
            
          
        HStack {
            Button(action: {
                  print("Viaje Comentado")
              }) {
                  Text(" ")
                      .foregroundColor(Color.black)
                    .padding(.bottom, 2)
                    .padding(.trailing, 50)
                    .background(Image(systemName: "chevron.right.circle.fill"))
            }.padding(5)
        }.padding(.leading, 280)
      }
      .padding()
      .background(Color.white)
      .cornerRadius(28)
      .frame(width: 390, height: 245)
      .shadow(radius: 3, y: 5)
    }
}

struct MiViajeCardView_Previews: PreviewProvider {
    static var previews: some View {
        MiViajeCardView(nombre: "Juanelv Salgado", fecha: "2019-07-11", puntoPartida: "Aqui", puntoDestino: "Alla")
    }
}
