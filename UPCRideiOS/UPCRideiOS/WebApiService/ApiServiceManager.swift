import Foundation
import Combine



class WebService{
    
func registrarPasajero(usuario: Usuario){

guard let url = URL(string:"http://ec2-52-15-215-247.us-east-2.compute.amazonaws.com:8080/usuarios/pasajero")
else { fatalError("URL inválido")}


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

 URLSession.shared.uploadTask(with: request, from: finalBody) { (data, _, _) in
   
   if let data = data, let dataString = String(data: data, encoding: .utf8) {
        print(dataString)
    }
    
 }.resume()

}
    

}
