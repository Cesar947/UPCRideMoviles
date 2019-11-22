//
//  SolicitarViajeView.swift
//  UPCRideiOS
//
//  Created by Cesar Pizarro Llanos on 11/21/19.
//  Copyright © 2019 upcride. All rights reserved.
//

import SwiftUI

struct SolicitarViajeView: View {
    @ObservedObject var solicitud = SolicitudViewModel()
    var viaje = Viaje()
    var pasajero = Usuario()
    var body: some View {
        NavigationView{
            Form{
                Section{
                TextField("Mensaje", text: self.$solicitud.mensaje)
                }.navigationBarTitle(Text("Solicitar viaje"))
           }
        }
       
    }
}

struct SolicitarViajeView_Previews: PreviewProvider {
    static var previews: some View {
        SolicitarViajeView(viaje: Viaje(), pasajero: Usuario())
    }
}
