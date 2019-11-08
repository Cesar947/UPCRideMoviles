import Foundation
import Combine


struct ServerMessage: Decodable{
    let status, message: String
}



class WebService: ObservableObject{

var didChange = PassthroughSubject<WebService, Never>()

    var loLogroSeñor = false {
        didSet{
            didChange.send(self)
        }
    }
    
func registrarPasajero(usuario: Usuario){

guard let url = URL(string:"http://ec2-52-15-215-247.us-east-2.compute.amazonaws.com:8080/usuarios/pasajero")
else {return}


 var jsonUsuario = [String:Any]()
 jsonUsuario = [
 "codigo": usuario.codigo,
 "correoUPC": usuario.correoUPC,
 "contraseña": usuario.contraseña,
 "nombres": usuario.nombres,
 "apellidos": usuario.apellidos,
 "telefono": usuario.telefono,
 "distrito": usuario.distrito,
 "sede": usuario.sede,
 "dni": usuario.dni
 ]
      
      let finalBody = try! JSONSerialization.data(withJSONObject: jsonUsuario)
      
      var request = URLRequest(url: url)
      request.httpMethod = "POST"
      request.httpBody = finalBody

      request.setValue("application/json", forHTTPHeaderField: "Content-Type")

 URLSession.shared.dataTask(with: request) { (data, response, error) in
    guard let data = data else {return}
    let finalData = try! JSONDecoder().decode(ServerMessage.self, from: data)
    if finalData.status == "ok"{
        DispatchQueue.main.async {
            self.loLogroSeñor = true
        }
    }
    
 }.resume()

}





}
