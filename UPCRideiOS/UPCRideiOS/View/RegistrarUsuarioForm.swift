//
//  RegistrarUsuarioForm.swift
//  UPCRideiOS
//
//  Created by Cesar Pizarro Llanos on 11/6/19.
//  Copyright © 2019 upcride. All rights reserved.
//

import SwiftUI

struct RegistrarUsuarioForm: View {

 @State var codigo: String = ""
 @State var correoUPC: String = ""
 @State var contrasena: String = ""
 @State var dni: String = ""
 @State var nombres: String = ""
 @State var apellidos: String = ""
 @State var telefono: String = ""
 @State var distrito: String = ""
 @State var sede: Int = 0
 var manager = WebService()
    
 var sedes: [String] = ["-", "San Miguel", "San Isidro", "Monterrico", "Villa"]
 
    var body: some View {
        

        NavigationView{
        Form{
            Section(header: Text("Datos Alumno")){
                TextField("Codigo", text: self.$codigo)
                TextField("Correo UPC", text: self.$correoUPC)
                SecureField("Contraseña", text: self.$contrasena)
                
            }
            
            Section(header: Text("Datos Personales")){
                TextField("Nombres", text: self.$nombres)
                TextField("Apellidos", text: self.$apellidos)
                TextField("DNI", text: self.$dni)
                TextField("Telefono", text: self.$telefono)
            }
        
            
            Section (header: Text("Datos Ubicacion")){
               
                TextField("Distrito donde vive", text: self.$distrito)
                
            }
            Section (header: Text("Sede")){
                    Picker(selection: self.$sede, label: Text("Sede UPC")) {

                        ForEach(0 ..< sedes.count){
                            Text(self.usuario.sedes[$0]).tag($0)
                        }
                    }
            }
                    
                
            
            

            Button(action: {
                manager.registrarPasajero(nuevoPasajero())
            } ) {
                Text("Registrar")
                    
            }.padding(.leading, 300)
            
        }.padding(.top, 20)
        .navigationBarTitle(Text("Registro"))
        }


    }
 
    func nuevoPasajero() -> Usuario{
        if self.codigo = "" ||
           self.correoUPC = "" ||
           self.contrasena = "" ||
           self.dni = "" ||
           self.nombres = "" ||
           self.apellidos = "" ||
           self.telefono = "" ||
           self.distrito = ""
           {
            
            
            var usuario: Usuario = Usuario()
            
         
            usuario.codigo = self.codigo
            usuario.correoUPC = self.correoUPC
            usuario.contraseña = self.contrasena
            usuario.dni = self.dni
            usuario.nombres = self.nombres
            usuario.apellidos = self.apellidos
            usuario.telefono = self.telefono
            usuario.distrito = self.distrito
            usuario.sede = self.sede
            
        }
    }
}







struct RegistrarUsuarioForm_Previews: PreviewProvider {
    static var previews: some View {
        RegistrarUsuarioForm()
    }
}

