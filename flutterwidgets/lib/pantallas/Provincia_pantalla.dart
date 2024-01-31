// Importando los paquetes necesarios
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutterwidgets/main.dart';
import 'package:flutterwidgets/pantallas/Comarcas_pantalla.dart';
import '/utils/Comarques.dart';
import 'dart:convert'; // Para realizar conversiones entre tipos
import 'package:http/http.dart' as http; // Para realizar peticiones HTTP

// Clase provincia_pantalla que es un widget con estado
class provincia_pantalla extends StatefulWidget {
  const provincia_pantalla({super.key});

  // Creando el estado del widget
  @override
  State<provincia_pantalla> createState() => _provincia_pantallaState();
}

// Clase _provincia_pantallaState que es el estado de provincia_pantalla
class _provincia_pantallaState extends State<provincia_pantalla> {

  // Método para construir el widget
  @override
  Widget build(BuildContext context) {
    // Retornando el widget Scaffold con SafeArea para evitar la superposición con la barra de estado
    return SafeArea(
        child: Scaffold(
          // Creando la barra de la aplicación con el título
          appBar: AppBar(
            title: const Text("Provincias de la Comunitat",
              style: TextStyle(
                  fontSize: 30,
                  fontWeight: FontWeight.bold,
                  color: Colors.black,
                  fontFamily: 'MyFuente'
              ),
            ),
            centerTitle: true,
            backgroundColor: Colors.white,
          ),
          // Creando el cuerpo de la aplicación con una lista de provincias
          body: Container(
              height: MediaQuery.of(context).size.height - MediaQuery.of(context).padding.top,
                decoration: const BoxDecoration(
                  image: DecorationImage(
                      opacity: 0.2,
                      image: AssetImage("assets/images/background.png"), // Imagen de fondo
                      repeat: ImageRepeat.repeat
                  ),
                ),
              child: Center(
                child: Column(
                  mainAxisAlignment: MainAxisAlignment.center,
                  children: [
                    // Creando un widget para cada provincia
                    // Al hacer tap en la provincia, se navega a la pantalla de comarcas de esa provincia
                    Padding(padding: const EdgeInsets.only(bottom: 30),
                        child: GestureDetector(
                          onTap: () {
                            Navigator.push(
                              context,
                              MaterialPageRoute(builder: (context) => comarcas_pantalla(indiceProvincia: 0)));
                          },
                          child: Stack(
                            alignment: Alignment.center,
                            children: <Widget>[
                              CircleAvatar(
                                radius: 100,
                                backgroundImage: Image.network("https://twomonkeystravelgroup.com/wp-content/uploads/2020/01/15-Best-Things-To-Do-in-Valencia-Spain1.jpg").image,
                                //backgroundImage: AssetImage(provincies["provincies"][0]["img"]),
                              ),
                              Text(
                                '${provincies["provincies"][0]["provincia"]}',
                                style: const TextStyle(
                                  fontSize: 50,
                                  fontWeight: FontWeight.bold,
                                  color: Colors.white,
                                  fontFamily: 'MyFuente'
                                ),
                              ),
                            ]
                          )
                        )
                    ),
                    // Repitiendo el proceso para las demás provincias
                    Padding(padding: const EdgeInsets.only(bottom: 30),
                        child: GestureDetector(
                            onTap: () {
                              Navigator.push(
                                context,
                                MaterialPageRoute(builder: (context) => comarcas_pantalla(indiceProvincia: 1)));
                            },
                            child: Stack(
                                alignment: Alignment.center,
                                children: <Widget>[
                                  CircleAvatar(
                                    radius: 100,
                                    backgroundImage: Image.network(provincies["provincies"][1]["img"]).image,
                                  ),
                                  Text(
                                    '${provincies["provincies"][1]["provincia"]}',
                                    style: const TextStyle(
                                        fontSize: 50,
                                        fontWeight: FontWeight.bold,
                                        color: Colors.white,
                                        fontFamily: 'MyFuente'
                                    ),
                                  ),
                                ]
                            )
                        )
                    ),
                    Padding(padding: const EdgeInsets.only(bottom: 30),
                        child: GestureDetector(
                            onTap: () {
                              Navigator.push(
                                context,
                                MaterialPageRoute(builder: (context) => comarcas_pantalla(indiceProvincia: 2)));
                            },
                            child: Stack(
                                alignment: Alignment.center,
                                children: <Widget>[
                                  CircleAvatar(
                                    radius: 100,
                                    backgroundImage: Image.network(provincies["provincies"][2]["img"]).image,
                                  ),
                                  Text(
                                    '${provincies["provincies"][2]["provincia"]}',
                                    style: const TextStyle(
                                        fontSize: 50,
                                        fontWeight: FontWeight.bold,
                                        color: Colors.white,
                                        fontFamily: 'MyFuente'
                                    ),
                                  ),
                                ]
                            )
                        )
                    ),
                  ],
                ),
              )
            )

        ),
    );
  }

  // Método para llamar a una imagen desde una URL
  dynamic llamarImagen (String urlImagen){
    var response = http.get(Uri.parse(urlImagen));
    response.then((value) {
      if(value.statusCode == 200){
        return Image.memory(base64Decode(value.body));
      } else{
        return Image.asset("");
      }
    });
  }

}