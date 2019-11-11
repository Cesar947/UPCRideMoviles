//
//  HomeView.swift
//  UPCRideiOS
//
//  Created by Sebastian on 11/7/19.
//  Copyright © 2019 upcride. All rights reserved.
//

import SwiftUI

struct HomeView: View {
    @ObservedObject var viajeServiceManager = ViajeService()
    //@State private var viajes = [ViajePrueba]()
    
    var body: some View {
        NavigationView{
        ScrollView() {
            VStack(spacing: 20){
                ForEach(self.viajeServiceManager.viajes) {viajen in
                    ViajeCardView( nombre: viajen.conductor.nombres , fecha: viajen.fecha, descripcion: viajen.descripcion, puntoPartida: viajen.puntoPartida, puntoDestino: viajen.puntoDestino)
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
