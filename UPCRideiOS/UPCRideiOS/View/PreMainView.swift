//
//  PreMainView.swift
//  UPCRideiOS
//
//  Created by Sebastian on 11/7/19.
//  Copyright © 2019 upcride. All rights reserved.
//

import SwiftUI

struct PreMainView: View {
    
    var username: String
    var password: String
    
    
    var body: some View {
        NavigationView{
            if self.username == "ola" && self.password == "123" {
                MainView()
            }
            else {
                LoginView()
            }
        }
    }
}

struct PreMainView_Previews: PreviewProvider {
    static var previews: some View {
        PreMainView(username: " ", password: " ")
    }
}
