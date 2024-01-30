import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutterwidgets/main.dart';
import 'package:flutterwidgets/pantallas/Comarcas_pantalla.dart';
import '/utils/Comarques.dart';
import 'dart:convert'; // Para  realizar conversiones entre tipos
import 'package:http/http.dart' as http; // Para reañozar ètocopmes HTTP

class provincia_pantalla extends StatefulWidget {
  const provincia_pantalla({super.key});

  @override
  State<provincia_pantalla> createState() => _provincia_pantallaState();
}

class _provincia_pantallaState extends State<provincia_pantalla> {

  @override
  Widget build(BuildContext context) {
    return SafeArea(
        child: Scaffold(
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