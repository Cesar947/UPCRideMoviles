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
                            Text(self.sedes[$0]).tag($0)
                        }
                    }
            }
                
            Button(action: {
               let pasajero = self.nuevoPasajero(codigo: self.codigo, correoUPC: self.correoUPC, contraseña: self.contrasena, dni: self.dni, nombres: self.nombres, apellidos: self.apellidos, telefono: self.telefono, distrito: self.distrito, sede: self.sedes[self.sede])
                self.manager.registrarPasajero(usuario: pasajero)
                print("Lo logro senior")
            } ) {
                Text("Registrar")
                    
            }.padding(.leading, 300)
            
        }.padding(.top, 0)
        .navigationBarTitle(Text("Registro"))
        }


    }
 
    func nuevoPasajero(
    codigo: String,
    correoUPC: String,
    contraseña: String,
    dni: String,
    nombres: String,
    apellidos: String,
    telefono: String,
    distrito: String,
    sede : String) -> Usuario{
        
       let usuario = Usuario(codigo: codigo, correoUPC: correoUPC,
                                       contraseña: contraseña, dni: dni, nombres: nombres,
                                       apellidos: apellidos, telefono: telefono, distrito: distrito,
                                       sede: sede)
            
         return usuario
            
        }
}


struct RegistrarUsuarioForm_Previews: PreviewProvider {
    static var previews: some View {
        RegistrarUsuarioForm()
    }
}

