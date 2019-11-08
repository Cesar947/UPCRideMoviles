//
//  LoginView.swift
//  UPCRideiOS
//
//  Created by Sebastian on 11/7/19.
//  Copyright © 2019 upcride. All rights reserved.
//

import SwiftUI

struct LoginView: View {
    
    @State private var username: String = ""
    @State private var password: String = ""
    @State var estadito: Bool = false
    
    var body: some View {
        NavigationView{
            VStack{
                VStack{
                    Text("Bienvenido a UPC Ride de vuelta")
                        .font(.body)
                        .fontWeight(.bold)
                    
                    Text("Listo para llegar a la universidad mas rapido?")
                        .font(.caption)
                        .padding(.top, 10)
                }.padding(.bottom, 50)
                
                VStack{
                    TextField("Correo UPC", text: $username).padding()
                    SecureField("Contraseña", text: $password).padding()
                    NavigationLink(destination: LogView(username1: self.username, password1: self.password)){
                        Text("Iniciar Sesion")
                    }
                    
                }.padding([.leading, .trailing], 30)
            }.padding(.bottom, 300)
            .navigationBarTitle(Text(" "))
            .navigationBarHidden(true)
        }
    }
}

struct LogView: View {
    var username1: String
      var password1: String
      
      
      var body: some View {
          VStack{
              if self.username1 == "Ola" && self.password1 == "123" {
                  MainView()
              }
              else {
                  LoginView()
              }
          }
      }
}


struct LoginView_Previews: PreviewProvider {
    static var previews: some View {
        LoginView()
    }
}
