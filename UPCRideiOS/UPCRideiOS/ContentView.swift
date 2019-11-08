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
        NavigationView{
        VStack {
            VStack{
                Text("Bienvenido a UPC Ride")
                    .font(.largeTitle)
                    .fontWeight(.heavy)
                    .lineLimit(2)
                    .padding(.trailing, 100)
                    .padding(.leading, 25)
                    .padding(.bottom, 30)
                
                Text("La mejor forma de viajar y conocer companeros en la UPC")
                    .lineLimit(2)
                    .padding([.leading, .trailing], 50)
                
                
            }.padding(.bottom, 240)
            
            VStack{
                NavigationLink(destination: LoginView()){
                    Text("Iniciar Sesion")
                        .foregroundColor(Color.blue)
                }
                
                Button(action: {print("Registrando")}) {
                Text("Registrarme")
            }.padding()
            }.padding(.top, 100)
        }.padding(.top, 80)
        }
    }
}

      


struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}

