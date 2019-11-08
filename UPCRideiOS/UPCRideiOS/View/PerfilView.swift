//
//  PerfilView.swift
//  UPCRideiOS
//
//  Created by Sebastian on 11/7/19.
//  Copyright © 2019 upcride. All rights reserved.
//

import SwiftUI

struct PerfilView: View {
      let nombre = "Brian Miramira"
       let distrito = "San Miguel"
      let sede = "UPC San Miguel"
       
       var body: some View {
        NavigationView {
            VStack(alignment: .center) {
               HStack(alignment: .center) {
                   VStack {
                    Text(self.nombre)
                        .font(.headline)
                        .fontWeight(.semibold)
                        .multilineTextAlignment(.leading)
                        .padding(.bottom, 5)
                        .frame(width: 150)
                                  
                                  
                                  Text(self.distrito)
                                      .font(.caption)
                                      .fontWeight(.thin)
                                      .lineLimit(2)
                                      .multilineTextAlignment(.center)
                                      .padding(.trailing, 20)
                    
                    Text(self.sede)
                    .font(.caption)
                    .fontWeight(.thin)
                    .lineLimit(2)
                    .multilineTextAlignment(.center)
                    .padding(.leading, 2)
                        .padding(.top, 2)
                                  
                   }.padding(.trailing, 20)
                  
                   
               }.padding(.top, 20)
                .padding(.trailing, 160)
               
                 
                VStack {
                    HStack {
                       Button(action: {
                             print("Viaje Iniciado")
                         }) {
                            VStack {
                                Image(systemName: "person.circle.fill").resizable()
                                .frame(width: 30, height: 30)
                                Text("Informacion")
                                    .font(.caption)
                                     .foregroundColor(Color.blue)
                                    .padding(.bottom, 2)
                            }
                       }.padding(15)
                    
                    Button(action: {
                          print("Viaje Iniciado")
                      }) {
                        VStack {
                            Image(systemName: "map.fill").resizable()
                            .frame(width: 30, height: 30)
                            Text("Viajes")
                                .font(.caption)
                                  .foregroundColor(Color.blue)
                                .padding(.bottom, 2)
                        }
                    }.padding(15)
                    
                    Button(action: {
                          print("Resenas")
                      }) {
                        Image(systemName: "")
                        VStack {
                            Image(systemName: "text.bubble.fill").resizable()
                            .frame(width: 30, height: 30)
                            Text("Resenas")
                                .font(.caption)
                                  .foregroundColor(Color.blue)
                                .padding(.bottom, 2)
                        }
                    }.padding(15)
                    }.padding(.top, 2)
                    
                    HStack {
                                          Button(action: {
                                                print("Viaje Iniciado")
                                            }) {
                                                
                                                VStack {
                                                    Image(systemName: "car.fill").resizable()
                                                    .frame(width: 30, height: 30)
                                                    Text("Auto")
                                                        .font(.caption)
                                                        .foregroundColor(Color.blue)
                                                        .padding(.bottom, 2)
                                                }
                                          }.padding(10)
                                       
                                       Button(action: {
                                             print("Viaje Iniciado")
                                         }) {
                                            VStack {
                                                Image(systemName: "shield.lefthalf.fill").resizable()
                                                .frame(width: 28, height: 30)
                                                Text("Configuracion")
                                                    .font(.caption)
                                                  .foregroundColor(Color.blue)
                                                .padding(.bottom, 2)
                                            }
                                             
                                       }.padding(10)
                                       
                                       Button(action: {
                                             print("Viaje Iniciado")
                                         }) {
                                            VStack {
                                                Image(systemName: "arrow.uturn.up.circle.fill").resizable()
                                                .frame(width: 30, height: 30)
                                                Text("Cerrar Sesion")
                                                    .font(.caption)
                                                     .foregroundColor(Color.blue)
                                                    .padding(.bottom, 2)
                                            }
                                       }.padding(5)
                    }.padding(.top, 2)
                        .padding(.leading, 25)
                }
             }
            .padding([.leading, .trailing, .bottom], 40)
             .background(Color.white)
             .cornerRadius(28)
             .frame(width: 390, height: 245)
            .shadow(radius: 3, y: 5)
            .padding(.top, 150)
            
        .navigationBarTitle(Text("Perfil"))
            .background(Image("loli").resizable()
            .frame(width: 380, height: 280)
            .padding(.bottom, 350))
        }
    }
}

struct PerfilView_Previews: PreviewProvider {
    static var previews: some View {
        PerfilView()
    }
}
