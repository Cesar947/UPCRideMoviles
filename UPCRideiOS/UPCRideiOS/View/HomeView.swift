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
    
    let generalURL = "http://ec2-52-15-215-247.us-east-2.compute.amazonaws.com:8080/"
    
    var viajes = [Viaje]()
    guard let url = URL(string: generalURL + "viajes") else {fatalError("Invalid URL")}
          
          URLSession.shared.dataTask(with: url) { (data, response, error) in
              guard let data = data, error == nil else {
                DispatchQueue.main.async{
                    viajes = []
                }
                return
                
            }
              
              let viajesData = try! JSONDecoder().decode([Viaje].self, from: data)
              DispatchQueue.main.async{
                
                viajes = viajesData
               
              }
          }.resume()
    
    init(){
        
        print(networkManager.listarViajes().count)
    }
    
    
    var body: some View {
        NavigationView{
        ScrollView() {
            VStack(spacing: 20){
                List(networkManager.listarViajes(), id: \.id){ viaje in
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

