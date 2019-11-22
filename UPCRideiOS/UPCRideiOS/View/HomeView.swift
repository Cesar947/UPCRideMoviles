//
//  HomeView.swift
//  UPCRideiOS
//
//  Created by Sebastian on 11/7/19.
//  Copyright © 2019 upcride. All rights reserved.
//

import SwiftUI

struct HomeView: View {

   @ObservedObject var viajesListViewModel = ViajeHomeViewModel()
    var pasajero = UsuarioPasajeroViewModel(codigo: "U201710947", correoUPC: "U201710947@upc.edu.pe", contraseña: "123", dni: "73462133", nombres: "César", apellidos: "Pizarro", telefono: "999888777", distrito: "Magdalena del Mar", sede: "San Miguel", ubicacionLatitud: -12.635251, ubicacionLongitud: -77.28362)
    var body: some View {
        NavigationView{
            VStack{
                List(self.viajesListViewModel.viajes){ viaje in
                    ViajeCardView(viaje: viaje.viaje, pasajero: Usuario(usuario: self.pasajero), nombre: viaje.nombres, fecha: viaje.fecha, descripcion: viaje.descripcion, puntoPartida: viaje.puntoPartida, puntoDestino: viaje.puntoDestino)

                }
            }
                
        .navigationBarTitle(Text("Inicio"))
            .navigationBarItems(trailing: Button(action: {print("Buscando")}) {
            Text("")
            Image(systemName: "magnifyingglass").font(Font.system(size: 25, weight: .semibold))
            })
            }
         
            
     
        
    }
    }


struct HomeView_Previews: PreviewProvider {
    static var previews: some View {
        HomeView(pasajero: UsuarioPasajeroViewModel())
    }
}

