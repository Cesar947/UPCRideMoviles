//
//  RegistrarUsuarioForm.swift
//  UPCRideiOS
//
//  Created by Cesar Pizarro Llanos on 11/6/19.
//  Copyright © 2019 upcride. All rights reserved.
//
import Combine
import SwiftUI


/*var codigo: String
var correoUPC: String
var contraseña: String
var dni: String
var nombres: String
var apellidos: String
var ubicacionLatitud: Double
var ubicacionLongitud: Double
var facebook_id: String //Conductor
var telefono: String
var distrito: String
var rol: Character
var licenciaConducir: String //Conductor
var sede: String*/



struct RegistrarUsuarioForm: View {
    
    @ObservedObject var usuario = Usuario()
    
    /*func registrar(){
          
      }*/
    
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
                    
                /*Picker(selection: $usuario.sedeIdentificador, label: Text("Escoja su sede")) {
                      ForEach(0 ..< usuario.sedes.count) {
                      Text(self.usuario.sedes[$0]).tag($0)
                  }
                }*/
                   
                TextField("Distrito", text: $usuario.codigo)
                    
                }
            }
            
            Section{
                Button(action: {
                    print("Registrado")
                }){
                    Text("Registrar")
                }
            }
        }
        }.navigationBarTitle(Text("Registro"))
    }
  
}



struct RegistrarUsuarioForm_Previews: PreviewProvider {
    static var previews: some View {
        RegistrarUsuarioForm()
    }
}
