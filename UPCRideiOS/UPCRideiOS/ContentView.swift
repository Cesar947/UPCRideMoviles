//
//  ContentView.swift
//  UPCRideiOS
//
//  Created by Sebastian on 11/6/19.
//  Copyright © 2019 upcride. All rights reserved.
//

import SwiftUI


//let viajes = viajesPrueba
     
     /*var body: some View {
         ScrollView() {
           VStack(alignment: .center, spacing: 15){
                 ForEach(self.viajes) {viajen in
                     ViajeCardView( nombre: viajen.nombre , fecha: viajen.fecha, descripcion: viajen.descripcion, puntoPartida: viajen.puntoPartida, puntoDestino: viajen.puntoDestino)
                 }
           }.padding(.top, 10)
         }.padding(.top, 10)
     }*/

struct ContentView: View {

 /*
    @ObservedObject var usuario = Usuario()

       var body: some View {
           NavigationView{
           Form{
               Section{
                   TextField("Codigo", text: $usuario.codigo)
                   TextField("Correo UPC", text: $usuario.correoUPC)
                   SecureField("Contraseña", text: $usuario.contraseña)
                   TextField("DNI", text: $usuario.dni)
                   TextField("Nombres", text: $usuario.nombres)
                   TextField("Apellidos", text: $usuario.apellidos)
                   TextField("Telefono", text: $usuario.telefono)
                  
               }
               Section{
                   VStack{
                       
                       Picker(selection: $usuario.sede, label: Text("Sede")) {
                           ForEach(0 ..< usuario.sedes.count){
                               Text(self.usuario.sedes[$0]).tag($0)
                           }
                       }

                       
                       TextField("Distrito", text: $usuario.distrito)
                       
                   }
               }
            
            Section{
                Button(action: {print("Registrar")}) {
                   Text("Registrar")
                    
                }
            }.disabled(!usuario.isValid)
           }
           .navigationBarTitle("Registro")
          
    }
        
}
    
}
*/

      
      var body: some View {
        TabView{
            NavigationView{
                HomeView()
                .navigationBarTitle(Text("Inicio"))
            }.tabItem{
            Image("ic_action_home")
                Text("Inicio")
            }
                
                Text("Viajes").tabItem{
                    Image("ic_action_logo")
                    Text("Viajes")
                }
                Text("Solicitudes").tabItem{
                    Image("ic_action_solis")
                    Text("Solicitudes")
                }
                Text("Perfil").tabItem{
                    Image("ic_action_perfil")
                    Text("Perfil")
                }
            }
        }
    }

      


struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}

