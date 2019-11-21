//
//  ViajeListViewModel.swift
//  UPCRideiOS
//
//  Created by Cesar Pizarro Llanos on 11/20/19.
//  Copyright © 2019 upcride. All rights reserved.
//

import Foundation


class ViajeHomeViewModel : ObservableObject {

  @Published var viajes = [ViajeViewModel]()

  init(){
    
    ViajeService().listarViajes{ viajes in
        if let viajes = viajes {
            self.viajes = viajes.map(ViajeViewModel.init)
        }
        
    }
    
      
        
    }
}
