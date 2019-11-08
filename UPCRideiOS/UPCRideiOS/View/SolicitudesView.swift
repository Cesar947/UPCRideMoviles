//
//  SolicitudesView.swift
//  UPCRideiOS
//
//  Created by Sebastian on 11/7/19.
//  Copyright © 2019 upcride. All rights reserved.
//

import SwiftUI

struct SolicitudesView: View {
      let solicitudes = solicitudesPrueba
      
      var body: some View {
          NavigationView{
              ScrollView() {
                  VStack(spacing: 5){
                      ForEach(self.solicitudes) {soli in
                        SolicitudCardView( nombre: soli.nombre , fecha: soli.fecha, mensaje: soli.mensaje)
                      }
                  }
              }
              .background(Image("bg").resizable()
              .frame(width: 320, height: 350)
              .padding(.leading, 100)
              .padding(.bottom, 320))
              .navigationBarTitle(Text("Solicitudes"))
          }
      }
}

struct SolicitudesView_Previews: PreviewProvider {
    static var previews: some View {
        SolicitudesView()
    }
}
