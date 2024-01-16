import 'dart:convert'; // Para  realizar conversiones entre tipos
import 'package:http/http.dart' as http; // Para reañozar ètocopmes HTTP

void main() async {
  String url =
      'https://node-comarques-rest-server-production.up.railway.app/api/comarques/València';
// Lanzamos la petición GET
// En este ejemplo response serà de tipo Response, y no un Future como antes
  var response = await http.get(Uri.parse(url));
  if (response.statusCode == 200) {
    String body = utf8.decode(response.bodyBytes);
    final bodyJSON = jsonDecode(body) as List;
    print(bodyJSON.toString());
  }
}