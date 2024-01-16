import 'package:http/http.dart' as http;
import 'dart:convert';

void main(List<String> arguments) {
  var urlInfoComarca = 'https://node-comarques-rest-server-production.up.railway.app/api/comarques/infocomarca/';
  var urlComarcas = 'https://node-comarques-rest-server-production.up.railway.app/api/comarques/';

  
}

class Comarca{
  //atributos del objeto
  String comarca;
  String? capital;
  String? poblacio;
  String? img;
  String? desc;
  double? latitud;
  double? longitud;

  //constructor
  Comarca(this.comarca, [this.capital, this.poblacio, this.img, this.desc, this.latitud, this.longitud]);

  //metodo para imprimir la informacion
  void imprimirInfo(){
    print('Comarca: $comarca');
    print('Capital: $capital');
    print('Poblacio: $poblacio');
    print('Img: $img');
    print('Desc: $desc');
    print('Latitud: $latitud');
    print('Longitud: $longitud');
  }
}