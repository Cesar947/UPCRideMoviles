//
//  ApiServiceSolicitud.swift
//  UPCRideiOS
//
//  Created by Cesar Pizarro Llanos on 11/21/19.
//  Copyright © 2019 upcride. All rights reserved.
//

import Foundation

class SolicitudService{
 
    
    func solicitarViaje(solicitud: Solicitud){
        guard let url = URL(string:"http://ec2-52-15-215-247.us-east-2.compute.amazonaws.com:8080/viajes/solicitar/\(solicitud.viaje.id)")
        else { fatalError("URL inválido")}

        
         var jsonSolicitud = [String:Any]()
         jsonSolicitud = [
            "pasajero": solicitud.pasajero,
            "viaje": solicitud.viaje,
            "mensaje": solicitud.mensaje,
            "confirmacionConductor": "Pendiente",
            "puntoEncuentro": solicitud.puntoEncuentro,
            "encuentroLatitud": solicitud.encuentroLatitud,
            "encuentroLongitud": solicitud.encuentroLongitud,
            "fecha": solicitud.fecha
                      
          ]
              
              let finalBody = try! JSONSerialization.data(withJSONObject: jsonSolicitud)
              
              var request = URLRequest(url: url)
              request.httpMethod = "POST"
              request.httpBody = finalBody

              request.setValue("application/json", forHTTPHeaderField: "Content-Type")

         URLSession.shared.uploadTask(with: request, from: finalBody) { (data, _, _) in
           
           if let data = data, let dataString = String(data: data, encoding: .utf8) {
                print(dataString)
            }
            
         }.resume()
    }
    
}
