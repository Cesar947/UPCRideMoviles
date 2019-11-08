//
//  MainView.swift
//  UPCRideiOS
//
//  Created by Sebastian on 11/7/19.
//  Copyright © 2019 upcride. All rights reserved.
//

import SwiftUI

struct MainView: View {
    
        var body: some View {
        TabView{
            HomeView().tabItem{
                Image(systemName: "house").font(Font.system(size: 30, weight: .semibold))
            }
                
                ViajesView().tabItem{
                    Image(systemName: "car").font(Font.system(size: 30, weight: .semibold))
                }
                SolicitudesView().tabItem{
                    Image(systemName: "bell").font(Font.system(size: 30, weight: .semibold))
                }
                PerfilView().tabItem{
                    Image(systemName: "person").font(Font.system(size: 30, weight: .semibold))
                }
            }
        }
}

struct MainView_Previews: PreviewProvider {
    static var previews: some View {
        MainView()
    }
}
