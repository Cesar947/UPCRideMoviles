//
//  ViajeListView.swift
//  UPCRideiOS
//
//  Created by Sebastian on 11/6/19.
//  Copyright © 2019 upcride. All rights reserved.
//

import SwiftUI

struct ViajeListView: View {
    
    let viajes = viajesPrueba
    
    var body: some View {
        ScrollView() {
            VStack(spacing: 20){
                ForEach(self.viajes) {viajen in
                    ViajeCardView( nombre: viajen.nombre , fecha: viajen.fecha, descripcion: viajen.descripcion, puntoPartida: viajen.puntoPartida, puntoDestino: viajen.puntoDestino)
                }
            }
        }
    }
}

struct ViajeListView_Previews: PreviewProvider {
    static var previews: some View {
        ViajeListView()
    }
}
