//
//  ApiServiceViajes.swift
//  UPCRideiOS
//
//  Created by Cesar Pizarro Llanos on 11/7/19.
//  Copyright © 2019 upcride. All rights reserved.
//

import Foundation
import Combine


class ViajeService: ObservableObject{
   
    @Published var viajes = [Viaje]()
    
    let generalURL: String = "http://ec2-52-15-215-247.us-east-2.compute.amazonaws.com:8080/"
    
    func listarViajes(/*completion: @escaping ([Viaje]?) -> ()*/){
        
        guard let url = URL(string: generalURL + "viajes") else {fatalError("Invalid URL")}
              
              URLSession.shared.dataTask(with: url) { (data, response, error) in
                  guard let data = data, error == nil else {
                    DispatchQueue.main.async{
                        self.viajes = []
                    }
                    return
                    
                }
                  
                  let viajesData = try! JSONDecoder().decode([Viaje].self, from: data)
                  DispatchQueue.main.async{
                    print(viajesData)
                    self.viajes = viajesData
                   
                  }
              }.resume()
        
        
    }

}
