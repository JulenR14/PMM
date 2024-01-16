import 'dart:convert'; // Para  realizar conversiones entre tipos
import 'package:http/http.dart' as http; // Para reañozar ètocopmes HTTP

void main() {
// Definim l'endpoint o adreça del recurs:
  String url =
      'https://node-comarques-rest-server-production.up.railway.app/api/comarques/València';
//  petición GET mediante  el mètodo http.get:
  var response = http.get(Uri.parse(url));
// Esto nos devolverá un Future, que necesitaremos procesar
// y  el mètodo then:
  response.then((data) {
// El Future se resueñve a una instància del objecto Response
// que contiene una propiedat statusCode amb el codigo deestado
// i una propiedad body y  el cuerpo de la respuesta.
    if (data.statusCode == 200) {
      String body = utf8.decode(data.bodyBytes);
      final bodyJSON = jsonDecode(body) as List;
// _Mostramos
      print(bodyJSON.toString());
    } // if
  });
}