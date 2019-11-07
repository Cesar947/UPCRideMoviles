//
//  RegistrarUsuarioForm.swift
//  UPCRideiOS
//
//  Created by Cesar Pizarro Llanos on 11/6/19.
//  Copyright © 2019 upcride. All rights reserved.
//

import SwiftUI

struct RegistrarUsuarioForm: View {
   
    @ObservedObject var usuario = Usuario()

    
    var body: some View {
        
        Text("Hello World")
 /*
        NavigationView{
        Form{
            Section(header: Text("Datos Alumno")){
                TextField("Codigo", text: $usuario.codigo)
                TextField("Correo UPC", text: $usuario.correoUPC)
                SecureField("Contraseña", text: $usuario.contraseña)
                
            }
            
            Section(header: Text("Datos Personales")){
                TextField("Nombres", text: $usuario.nombres)
                TextField("Apellidos", text: $usuario.apellidos)
                TextField("DNI", text: $usuario.dni)
                TextField("Telefono", text: $usuario.telefono)
            }
        
            
            Section (header: Text("Datos Ubicacion")){
                VStack{
                    

                     TextField("Distrito donde vive", text: $usuario.codigo)
                    
                    Picker(selection: $usuario.sedeIdentificador, label: Text("Sede UPC")) {

                        ForEach(0 ..< usuario.sedes.count){
                            Text(self.usuario.sedes[$0]).tag($0)
                        }
                    }
                    
                }
            }
            

            Button(action: {print("Usuario Registrado")} ) {
                Text("Registrar")
                    
            }.padding(.leading, 300)
            
        }.padding(.top, 20)
        .navigationBarTitle(Text("Registro"))
        }

*/
    }
 
}



struct RegistrarUsuarioForm_Previews: PreviewProvider {
    static var previews: some View {
        RegistrarUsuarioForm()
    }
}

