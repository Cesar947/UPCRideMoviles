//
//  ViajeCardView.swift
//  UPCRideiOS
//
//  Created by Sebastian on 11/6/19.
//  Copyright © 2019 upcride. All rights reserved.
//

import SwiftUI

struct ViajeCardView: View {
    var body: some View {
      VStack(alignment: .center) {
        HStack(alignment: .center) {
            Image("loli")
                  .resizable()
                   .aspectRatio(contentMode: .fill)
                  .frame(width: 30, height: 30)
                  .clipped()
                .cornerRadius(50)
            VStack {
                Text("Brian Miramira")
                    .font(.caption)
                    .fontWeight(.semibold)
                    .multilineTextAlignment(.center)
                    .padding(.trailing, 30)
                .padding(.bottom, 5)
                
                
                Text("09/11/2019 08:00 pm")
                    .font(.caption)
                    .fontWeight(.thin)
                    .lineLimit(2)
                    .multilineTextAlignment(.center)
                    .padding(.leading, 3.0)
                
            }.padding(.trailing, 160)
            
        }.padding(.top, 20)
          
        Text("Viaje de San Martin de Miradflores a San Juan de Burga")
            .font(.callout)
            .padding(.top, 10)
            .padding([.trailing, .leading], 24.5)
        
        HStack {
            Image("left")
                .padding(.trailing, 5)

            VStack {
                Text("Casita")
                    .padding(.top, 10)
                    .padding(.trailing, 155)
                Image("divider")
                Text("UPCex")
                    .padding(.top, 5)
                    .padding(.trailing, 155)
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
                      .background(Image("icons_comment"))
            }.padding(5)
            
            Button(action: {
                  print("Viaje Solicitado")
              }) {
                  Text(" ")
                      .foregroundColor(Color.black)
                    .padding(.bottom, 2)
                      .background(Image("icons_rideshare"))
            }.padding(5)
        }.padding(.leading, 220)
      }
      .padding()
      .background(Color.white)
      .cornerRadius(28)
      .frame(width: 390, height: 100)
      .shadow(radius: 8, y: 14)
    }
}

struct ViajeCardView_Previews: PreviewProvider {
    static var previews: some View {
        ViajeCardView()
    }
}
