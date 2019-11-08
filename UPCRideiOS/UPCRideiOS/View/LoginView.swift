//
//  LoginView.swift
//  UPCRideiOS
//
//  Created by Sebastian on 11/7/19.
//  Copyright © 2019 upcride. All rights reserved.
//

import SwiftUI

struct LoginView: View {
    
   @State var estado: Bool = true
     
       var body: some View {
         NavigationView{
         VStack {
             VStack{
                 Text("Bienvenido a UPC Ride")
                     .font(.largeTitle)
                     .fontWeight(.heavy)
                     .lineLimit(2)
                     .padding(.trailing, 100)
                     .padding(.leading, 25)
                     .padding(.bottom, 30)
                 
                 Text("La mejor forma de viajar y conocer companeros en la UPC")
                     .lineLimit(2)
                     .padding([.leading, .trailing], 50)
                 
                 
             }.padding(.bottom, 240)
             
             VStack{
                 NavigationLink(destination: TransView()){
                     Text("Iniciar Sesion")
                         .foregroundColor(Color.blue)
                 }
                 
                 Button(action: {print("Registrando")}) {
                 Text("Registrarme")
             }.padding()
             }.padding(.top, 100)
         }.padding(.top, 80)
             .navigationBarTitle(Text(" "))
            .navigationBarHidden(self.estado)
            .onAppear{
                self.estado = true
            }
         }
     }
}

struct LogView: View {
    
    @State private var username: String = ""
    @State private var password: String = ""
    @Binding var signedIn: Bool
    @Binding var estado: Bool
    
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
                    Button(action: { if self.username == "Ola" && self.password == "123"{
                        self.signedIn = true
                    } else{ self.signedIn = false} }) {
                        Text("Iniciar Sesion")
                    }
                    
                }.padding([.leading, .trailing], 30)
            }.padding(.bottom, 300)
            .navigationBarTitle(Text(" "))
            .onAppear{
                self.estado = false
            }
        }
    }
}


struct TransView: View{
    
    @State var signedIn = false
    @State var estado = false
    
    var body: some View {
        VStack{
            if signedIn {
                MainView()
            }
            else {
                LogView(signedIn: $signedIn, estado: $estado)
            }
        }
    }
    
}




struct LoginView_Previews: PreviewProvider {
    static var previews: some View {
        LoginView()
    }
}
