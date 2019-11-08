//
//  ApiServiceViajes.swift
//  UPCRideiOS
//
//  Created by Cesar Pizarro Llanos on 11/7/19.
//  Copyright © 2019 upcride. All rights reserved.
//

import Foundation
import Combine

struct ViajeList: Codable{
    var results: [Viaje]
}

class ViajeService: ObservableObject{
   var didChange = PassthroughSubject<ViajeService, Never>()

   var viajes = [Viaje]() {
        didSet{
            didChange.send(self)
        }
    }
    
    init() {
        
        
        guard let url = URL(string: "http://ec2-52-15-215-247.us-east-2.compute.amazonaws.com:8080/viajes") else {return}
              
              URLSession.shared.dataTask(with: url) { (data, _, _) in
                  guard let data = data else {return}
                  
                  let viajesData = try! JSONDecoder().decode([Viaje].self, from:
                      data)
                  DispatchQueue.main.async{
                    self.viajes = viajesData
                  }
              }.resume()
        
        
    }

}
