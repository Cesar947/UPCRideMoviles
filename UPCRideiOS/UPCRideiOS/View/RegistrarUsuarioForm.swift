//
//  RegistrarUsuarioForm.swift
//  UPCRideiOS
//
//  Created by Cesar Pizarro Llanos on 11/6/19.
//  Copyright © 2019 upcride. All rights reserved.
//

import SwiftUI

struct RegistrarUsuarioForm: View {

 
    var body: some View {
        
        NavigationView{
            
       
        VStack{
            NavigationLink(destination: RegistrarPasajeroForm()){
                               Text("Conviertete en pasajero")
                                   .foregroundColor(Color.blue)
                           }
                           
           NavigationLink(destination: RegistrarConductorForm()){
                           Text("Conviertete en conductor")
                            .foregroundColor(Color.blue)
           }.padding()
        }.navigationBarTitle(Text("Escoge un rol"))
        
        }
    }
}

struct RegistrarPasajeroForm: View {
    
    let manager = WebService()
    @ObservedObject var usuario = UsuarioPasajeroViewModel()
    @State var sede: Int = 0
    @State var sedes: [String] = ["-", "San Miguel", "San Isidro", "Monterrico", "Villa"]
    
    var body: some View{
         NavigationView{
               Form{
                   Section(header: Text("Datos Alumno")){
                       TextField("Codigo", text: self.$usuario.codigo)
                       TextField("Correo UPC", text: self.$usuario.correoUPC)
                       SecureField("Contraseña", text: self.$usuario.contraseña)
                       
                   }
                   
                   Section(header: Text("Datos Personales")){
                       TextField("Nombres", text: self.$usuario.nombres)
                       TextField("Apellidos", text: self.$usuario.apellidos)
                       TextField("DNI", text: self.$usuario.dni)
                       TextField("Telefono", text: self.$usuario.telefono)
                   }
               
                   
                   Section (header: Text("Datos Ubicacion")){
                      
                       TextField("Distrito donde vive", text: self.$usuario.distrito)
                       
                   }
                   Section (header: Text("Sede")){
                           Picker(selection: self.$sede, label: Text("Sede UPC")) {

                               ForEach(0 ..< sedes.count){
                                   Text(self.sedes[$0]).tag($0)
                               }
                           }
                   }
                       
                   Button(action: {
                       self.usuario.sede = self.sedes[self.sede]
                       self.usuario.ubicacionLongitud = -12.0234352
                       self.usuario.ubicacionLatitud = -77.0321232
                       let usuarioPasajero = Usuario.init(usuario: self.usuario)
                       self.manager.registrarPasajero(usuario: usuarioPasajero)
                       
                   }){
                      
                       Text("Registrar")
                           
                   }.padding(.leading, 300)
                   
               }
               .navigationBarTitle(Text("Registro de pasajero"))
               }


    }
}


struct RegistrarConductorForm: View{
   let manager = WebService()
   @State var sede: Int = 0
   @State var sedes: [String] = ["-", "San Miguel", "San Isidro", "Monterrico", "Villa"]
   @ObservedObject var usuario = UsuarioConductorViewModel()
    var body: some View{
       NavigationView{
        Form{
            Section(header: Text("Datos Alumno")){
                TextField("Codigo", text: self.$usuario.codigo)
                TextField("Correo UPC", text: self.$usuario.correoUPC)
                SecureField("Contraseña", text: self.$usuario.contraseña)
                
            }
            
            Section(header: Text("Datos Personales")){
                TextField("Nombres", text: self.$usuario.nombres)
                TextField("Apellidos", text: self.$usuario.apellidos)
                TextField("DNI", text: self.$usuario.dni)
                TextField("Telefono", text: self.$usuario.telefono)
            }
        
            
            Section(header: Text("Datos Ubicacion")){
               
                TextField("Distrito donde vive", text: self.$usuario.distrito)
                
            }
            Section(header: Text("Sede")){
                    Picker(selection: self.$sede, label: Text("Sede UPC")) {

                        ForEach(0 ..< sedes.count){
                            Text(self.sedes[$0]).tag($0)
                        }
                    }
            }
            
            Section(header: Text("Conductor")){
                TextField("Código de licencia de conducir", text: self.$usuario.licenciaConducir)
                TextField("Cómo te llamas en facebook?", text: self.$usuario.facebookId)
            }
            
                
            Button(action: {
                self.usuario.sede = self.sedes[self.sede]
                self.usuario.ubicacionLongitud = -12.0234352
                self.usuario.ubicacionLatitud = -77.0321232
                let usuarioPasajero = Usuario.init(usuario: self.usuario)
                self.manager.registrarPasajero(usuario: usuarioPasajero)
                
            }){
               
                Text("Registrar")
                    
            }.padding(.leading, 300)
            
        }
        .navigationBarTitle(Text("Registro de pasajero"))
        }
    }
}

struct RegistrarUsuarioForm_Previews: PreviewProvider {
    static var previews: some View {
        RegistrarUsuarioForm()
    }
}

