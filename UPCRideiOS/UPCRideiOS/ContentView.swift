//
//  ContentView.swift
//  UPCRideiOS
//
//  Created by Sebastian on 11/6/19.
//  Copyright © 2019 upcride. All rights reserved.
//

import SwiftUI


//let viajes = viajesPrueba
     
     /*var body: some View {
         ScrollView() {
           VStack(alignment: .center, spacing: 15){
                 ForEach(self.viajes) {viajen in
                     ViajeCardView( nombre: viajen.nombre , fecha: viajen.fecha, descripcion: viajen.descripcion, puntoPartida: viajen.puntoPartida, puntoDestino: viajen.puntoDestino)
                 }
           }.padding(.top, 10)
         }.padding(.top, 10)
     }*/

struct ContentView: View {
      var body: some View {
        VStack {
            LoginView().navigationBarTitle(Text(" "))
            .navigationBarHidden(true)
        }
    }
}

      


struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}

