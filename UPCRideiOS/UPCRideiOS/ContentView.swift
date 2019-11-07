//
//  ContentView.swift
//  UPCRideiOS
//
//  Created by Sebastian on 11/6/19.
//  Copyright © 2019 upcride. All rights reserved.
//

import SwiftUI

struct ContentView: View {
      let viajes = viajesPrueba
      
      /*var body: some View {
          ScrollView() {
            VStack(alignment: .center, spacing: 15){
                  ForEach(self.viajes) {viajen in
                      ViajeCardView( nombre: viajen.nombre , fecha: viajen.fecha, descripcion: viajen.descripcion, puntoPartida: viajen.puntoPartida, puntoDestino: viajen.puntoDestino)
                  }
            }.padding(.top, 10)
          }.padding(.top, 10)
      }*/
    
    @ObservedObject var usuario = Usuario()

       
       var body: some View {
           NavigationView{
           Form{
               Section{
                   TextField("Codigo", text: $usuario.codigo)
                   TextField("Correo UPC", text: $usuario.correoUPC)
                   SecureField("Contraseña", text: $usuario.codigo)
                   TextField("DNI", text: $usuario.codigo)
                   TextField("Codigo", text: $usuario.codigo)
                   TextField("Nombres", text: $usuario.codigo)
                   TextField("Telefono", text: $usuario.codigo)
                  
               }
           
               
               Section{
                   VStack{
                       
                       Picker(selection: $usuario.sedeIdentificador, label: Text("Sede")) {
                           ForEach(0 ..< usuario.sedes.count){
                               Text(self.usuario.sedes[$0]).tag($0)
                           }
                       }

                       
                       TextField("Distrito", text: $usuario.codigo)
                       
                   }
               }
               
               Button(action: {print("Usuario Registrado")} ) {
                   Text("Registrar")
               }
               
               }
           }.navigationBarTitle(Text("Registro"))
       }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
