//
//  HomeView.swift
//  UPCRideiOS
//
//  Created by Sebastian on 11/7/19.
//  Copyright © 2019 upcride. All rights reserved.
//

import SwiftUI

struct HomeView: View {
   @ObservedObject var networkManager = ViajeService()

    init(){
        networkManager.listarViajes()
        
    }
    
    var body: some View {
        NavigationView{
        ScrollView() {
            VStack(spacing: 20){
                List(networkManager.viajes, id: \.id){ viaje in
                    ViajeCardView(nombre: viaje.conductor.nombres, fecha: viaje.fecha, descripcion: viaje.descripcion, puntoPartida: viaje.puntoPartida, puntoDestino: viaje.puntoDestino)
                    
                }
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
        HomeView()
    }
}

