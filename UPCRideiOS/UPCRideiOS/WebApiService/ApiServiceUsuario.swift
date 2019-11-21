//
//  ApiServiceUsuario.swift
//  UPCRideiOS
//
//  Created by Cesar Pizarro Llanos on 11/20/19.
//  Copyright © 2019 upcride. All rights reserved.
//

import Foundation


class UsuarioService{
    
    let generalURL: String = "http://ec2-52-15-215-247.us-east-2.compute.amazonaws.com:8080/"
    
    func listarUsuarios(completion: @escaping ([Usuario]?) -> ()){
           
           guard let url = URL(string: generalURL + "usuarios") else {fatalError("Invalid URL")}
                 
                 URLSession.shared.dataTask(with: url) { (data, response, error) in
                     guard let data = data, error == nil else {
                       completion(nil)
                       if let error = error {
                           print(error.localizedDescription)
                       }
                       return
                           
                       
                   }
                     
                     let usuariosData = try! JSONDecoder().decode([Usuario].self, from: data)
                     DispatchQueue.main.async{
                       completion(usuariosData)
                      
                     }
                   if let error = error {
                       print(error.localizedDescription)
                   }
                     
                   
                 }.resume()
           
           
       }
}
