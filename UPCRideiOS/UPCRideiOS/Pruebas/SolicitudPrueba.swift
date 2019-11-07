//
//  SolicitudPrueba.swift
//  UPCRideiOS
//
//  Created by Sebastian on 11/7/19.
//  Copyright © 2019 upcride. All rights reserved.
//

import Foundation

struct SolicitudPrueba : Identifiable {
    
    var id = UUID()
    
    var nombre = "Sebastian Pinillos"
    var fecha = "2019-07-11"
    var mensaje = "Necesito llegar fast al toilet"
}

let solicitudesPrueba: [SolicitudPrueba] = [
    .init(),
    .init(),
    .init()
]
