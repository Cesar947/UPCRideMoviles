//
//  ViajesView.swift
//  UPCRideiOS
//
//  Created by Sebastian on 11/7/19.
//  Copyright © 2019 upcride. All rights reserved.
//

import SwiftUI

struct ViajesView: View {
    
    let viajes = viajesPrueba
    
    var body: some View {
        NavigationView{
            ScrollView() {
                VStack(spacing: 20){
                    ForEach(self.viajes) {viajen in
                        ViajeCardView( nombre: viajen.nombre , fecha: viajen.fecha, descripcion: viajen.descripcion, puntoPartida: viajen.puntoPartida, puntoDestino: viajen.puntoDestino)
                    }
                }
            }
            .navigationBarTitle(Text("Viajes"))
        }
    }
}

struct ViajesView_Previews: PreviewProvider {
    static var previews: some View {
        ViajesView()
    }
}
