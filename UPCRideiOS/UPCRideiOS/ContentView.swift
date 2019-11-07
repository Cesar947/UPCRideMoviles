//
//  ContentView.swift
//  UPCRideiOS
//
//  Created by Sebastian on 11/6/19.
//  Copyright © 2019 upcride. All rights reserved.
//

import SwiftUI

struct ContentView: View {
    
      var body: some View {
        TabView{
            HomeView().tabItem{
            Image("ic_action_home")
                Text("Inicio")
            }
                
                ViajesView().tabItem{
                    Image("ic_action_logo")
                    Text("Viajes")
                }
                Text("Solicitudes").tabItem{
                    Image("ic_action_solis")
                    Text("Solicitudes")
                }
                Text("Perfil").tabItem{
                    Image("ic_action_perfil")
                    Text("Perfil")
                }
            }
        }
    }

      

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
