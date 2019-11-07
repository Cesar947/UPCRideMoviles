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
                  .frame(width: 50, height: 50)
                  .clipped()
                .cornerRadius(50)
            VStack {
                Text("Brian Miramira")
                    .font(.body)
                    .fontWeight(.semibold)
                    .multilineTextAlignment(.center)
                    .padding([.bottom, .trailing])
                
                
                Text("09/11/2019 08:00 pm")
                    .font(.body)
                    .fontWeight(.thin)
                    .lineLimit(2)
                    .multilineTextAlignment(.center)
                
            }.padding()
            
        }
          
        Text("Viaje de San Martin de Miradflores a San Juan de Burga")
            .padding(.all)
        
        HStack {
            Image("left")
                .padding(.trailing)
            VStack {
                Text("Casita")
                    .padding(.bottom)
                Text("UPCex")
            }
            .padding(.bottom)
        }
            
          
          Button(action: {
              print("Tap tap tap...")
          }) {
              Text("Solicitar")
                  .foregroundColor(Color.black)
                  .padding()
                  .background(Color(red: 1.0, green: 0.6, blue: 0, opacity: 0.6))
                  .cornerRadius(12)
          }.padding()
      }
      .padding()
      .background(Color.white)
      .cornerRadius(28)
    }
}

struct ViajeCardView_Previews: PreviewProvider {
    static var previews: some View {
        ViajeCardView()
    }
}
