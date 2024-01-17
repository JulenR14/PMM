import 'package:http/http.dart' as http;
import 'dart:convert';

void main(List<String> arguments) {
  var urlInfoComarca = 'https://node-comarques-rest-server-production.up.railway.app/api/comarques/infocomarca/';
  var urlComarcas = 'https://node-comarques-rest-server-production.up.railway.app/api/comarques/';

  String buscar = '';

  if(arguments.length > 0){
    if(arguments.length > 2){
      for(int i = 1; i < arguments.length; i++){
        i == arguments.length - 1 ? buscar += arguments[i] : buscar += arguments[i] + ' ';
      }
    }else{
      buscar = arguments[1];
    }
    switch(arguments[0]){
      case 'comarcas':
        print('Buscando comarcas...');
        var url = urlComarcas + buscar;
        http.get(Uri.parse(url)).then((res){
          var comarcas = jsonDecode(res.body);
          comarcas.forEach((comarca) {
            print('Comarca: $comarca');
          });
        });
        break;

      case 'infocomarca':
        print('Buscando informacion de la comarca...');
        var url = urlInfoComarca + buscar;
        http.get(Uri.parse(url)).then((res){
          var comarca = jsonDecode(res.body);
          Comarca comarcaInfo = Comarca.fromJson(comarca);
          comarcaInfo.imprimirInfo();
        });
        break;
    }
  }else{
    print('No has introducido ninguna comarca');
  }
  
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
  Comarca.fromJson(Map<String, dynamic> json)
    : comarca = json['comarca'],
      capital = json['capital'],
      poblacio = json['poblacio'],
      img = json['img'],
      desc = json['desc'],
      latitud = json['latitud'],
      longitud = json['longitud'];

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