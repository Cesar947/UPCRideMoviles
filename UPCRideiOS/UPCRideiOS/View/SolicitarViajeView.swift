//
//  SolicitarViajeView.swift
//  UPCRideiOS
//
//  Created by Cesar Pizarro Llanos on 11/21/19.
//  Copyright © 2019 upcride. All rights reserved.
//

import SwiftUI
import MapKit

struct SolicitarViajeView: View {
    @State var manager = CLLocationManager()
    @State var alert = false
    @ObservedObject var solicitud = SolicitudViewModel()
    var viaje: Viaje
    var pasajero: Usuario
    
    var solicitudService = SolicitudService()
 
    var body: some View {
        NavigationView{
            VStack(alignment: .leading){
            Form{
                VStack{
                    VStack{
                        Text("Se solicitará el viaje de: \(viaje.conductor.nombres + viaje.conductor.apellidos)")
                        Text("Desde: \(viaje.puntoPartida)")
                        Text("Hasta: \(viaje.puntoDestino)")
                    }
                    Section(header: Text("Escribe un breve mensaje para tu conductor").multilineTextAlignment(.leading)){
                    TextField("Mensaje", text: self.$solicitud.mensaje)
                        
                    }
                    
                    Section(header: Text("Escribe un punto de encuentro").multilineTextAlignment(.leading)){
                        TextField("Punto de encuentro", text:
                            self.$solicitud.puntoEncuentro)
                    }
                }
              
                
               MapView(coordinate: CLLocationCoordinate2D(
                                  latitude: self.viaje.partidaLatitud, longitude: self.viaje.partidaLongitud)).frame(height: 300)
                              
                              Section{
                                  Button(action: {
                                    self.solicitud.pasajero = self.pasajero
                                    self.solicitud.viaje = self.viaje
                                    self.solicitud.encuentroLatitud = -12.0000
                                    self.solicitud.encuentroLongitud = -77.0000
                                    self.solicitud.fecha = "2019-11-22"
                                    self.solicitudService.solicitarViaje(solicitud: Solicitud(solicitud: self.solicitud))
                                  }){
                                    Text("Solicitar")
                                  }
                              }
                
            }
            
               
                
        }.navigationBarTitle(Text("Solicitar viaje"))
       
    }
}
}

struct SolicitarViajeView_Previews: PreviewProvider {
    static var previews: some View {
        SolicitarViajeView(viaje: Viaje(), pasajero: Usuario())
    }
}


struct MapView: UIViewRepresentable {
 
    var coordinate: CLLocationCoordinate2D
    
    func makeUIView(context: Context) -> MKMapView {
        MKMapView(frame: .zero)
    }

    func updateUIView(_ view: MKMapView, context: Context) {

        let span = MKCoordinateSpan(latitudeDelta: 0.02, longitudeDelta: 0.02)
        let region = MKCoordinateRegion(center: coordinate, span: span)
        view.setRegion(region, animated: true)
    }
}

/*
struct MapView: UIViewRepresentable{

    @Binding var manager: CLLocationManager
    @Binding var alert : Bool
     let map = MKMapView()
    
    func makeCoordinator() -> MapView.Coordinator {
        return Coordinator(parent: self)
    }
    
    
    func makeUIView(context: UIViewRepresentableContext<MapView>) -> MKMapView {
       
        let center = CLLocationCoordinate2D(latitude: -12.7000, longitude: -77.2707)
        let region = MKCoordinateRegion(center: center, latitudinalMeters: 1000, longitudinalMeters: 1000)
        map.region = region
        manager.requestWhenInUseAuthorization()
        manager.delegate = context.coordinator
        manager.startUpdatingLocation()
        return map
    }
    
   func updateUIView(_ uiView: MKMapView, context: UIViewRepresentableContext<MapView>) {
    }
    
    class Coordinator: NSObject, CLLocationManagerDelegate{
       
        var parent: MapView
        init(parent: MapView){
            self.parent = parent
        }
        
        func locationManager(_ manager: CLLocationManager, didChangeAuthorization status: CLAuthorizationStatus) {
            if status == .denied{
                parent.alert.toggle()
            }
        }
        
        func locationManager(_ manager: CLLocationManager, didUpdateLocations locations: [CLLocation]) {
                   
            let location = locations.last
            let point = MKPointAnnotation()
            
            let geoReader = CLGeocoder()
            geoReader.reverseGeocodeLocation(location!) { (places, err) in
                
                if err != nil {
                    print((err?.localizedDescription)!)
                    return
                }
                
                let place = places?.first?.locality
                point.title = place
                point.subtitle = "Current"
                point.coordinate = location!.coordinate
                self.parent.map.removeAnnotations(self.parent.map.annotations)
                self.parent.map.addAnnotation(point)
                
                let region = MKCoordinateRegion(center: location!.coordinate,
                                                latitudinalMeters: 1000, longitudinalMeters: 1000)
                self.parent.map.region = region
                
            }
        }
    }
    
}
*/
