// Importando los paquetes necesarios
import 'package:http/http.dart' as http;
import 'dart:convert';

// La función principal de la aplicación
void main(List<String> arguments) {
  // URLs para los endpoints de la API
  var urlInfoComarca = 'https://node-comarques-rest-server-production.up.railway.app/api/comarques/infocomarca/';
  var urlComarcas = 'https://node-comarques-rest-server-production.up.railway.app/api/comarques/';

  // Variable para almacenar el nombre de la región a buscar
  String buscar = '';

  // Verificar si se proporcionaron argumentos al iniciar la aplicación
  if(arguments.length > 0){
    // Si se proporcionaron más de dos argumentos, concatenarlos para formar el nombre de la región
    if(arguments.length > 2){
      for(int i = 1; i < arguments.length; i++){
        i == arguments.length - 1 ? buscar += arguments[i] : buscar += arguments[i] + ' ';
      }
    }else{
      // Si solo se proporcionó un argumento, usarlo como el nombre de la región
      buscar = arguments[1];
    }
    // Dependiendo del primer argumento proporcionado, hacer una solicitud HTTP a la URL correspondiente y procesar la respuesta
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
          // Crear un objeto Comarca a partir de la respuesta e imprimir su información
          Comarca comarcaInfo = Comarca.fromJson(comarca);
          comarcaInfo.imprimirInfo();
        });
        break;
    }
  }else{
    // Si no se proporcionaron argumentos, imprimir un mensaje indicando que no se ingresó ninguna región
    print('No has introducido ninguna comarca');
  }

}

// Clase que representa una región
class Comarca{
  // Atributos del objeto
  String comarca;
  String? capital;
  String? poblacio;
  String? img;
  String? desc;
  double? latitud;
  double? longitud;

  // Constructor
  Comarca(this.comarca, [this.capital, this.poblacio, this.img, this.desc, this.latitud, this.longitud]);
  // Constructor para crear un objeto Comarca a partir de un objeto JSON
  Comarca.fromJson(Map<String, dynamic> json)
    : comarca = json['comarca'],
      capital = json['capital'],
      poblacio = json['poblacio'],
      img = json['img'],
      desc = json['desc'],
      latitud = json['latitud'],
      longitud = json['longitud'];

  // Método para imprimir la información del objeto
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