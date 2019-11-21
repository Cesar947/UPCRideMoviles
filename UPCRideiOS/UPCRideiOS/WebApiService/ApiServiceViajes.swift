//
//  ApiServiceViajes.swift
//  UPCRideiOS
//
//  Created by Cesar Pizarro Llanos on 11/7/19.
//  Copyright © 2019 upcride. All rights reserved.
//

import Foundation
import Combine


class ViajeService{
 
    
    let generalURL: String = "http://ec2-52-15-215-247.us-east-2.compute.amazonaws.com:8080/"
    
    func listarViajes(completion: @escaping ([Viaje]?) -> ()){
        
        guard let url = URL(string: generalURL + "viajes") else {fatalError("Invalid URL")}
              
              URLSession.shared.dataTask(with: url) { (data, response, error) in
                  guard let data = data, error == nil else {
                    completion(nil)
                    if let error = error {
                        print(error.localizedDescription)
                    }
                    return
                        
                    
                }
                  
                  let viajesData = try! JSONDecoder().decode([Viaje].self, from: data)
                  DispatchQueue.main.async{
                    completion(viajesData)
                   
                  }
                if let error = error {
                    print(error.localizedDescription)
                }
                  
                
              }.resume()
        
        
    }
    
    func registrarViaje(viaje: Viaje, conductorId: Int){

    guard let url = URL(string: generalURL + "viajes/publicar/" + String(conductorId))
    else { fatalError("URL inválido")}
        let viajeEncode = try? JSONEncoder().encode(viaje)
        
        var request = URLRequest(url: url)
        request.httpMethod = "POST"
        request.httpBody = viajeEncode

        request.setValue("application/json", forHTTPHeaderField: "Content-Type")

        URLSession.shared.dataTask(with: request){ (data, response, error) in
            guard let data = data else {
                print("No data in response: \(error?.localizedDescription ?? "unknown error")")
             return
            }
            
            if (try? JSONDecoder().decode(Viaje.self, from: data)) != nil{
                print("Confirmacion exitosa")
            } else {
                let dataString = String(decoding: data, as: UTF8.self)
                print("Invalid response \(dataString)")
            }
        }.resume()
         
          
          
 

    }

}
