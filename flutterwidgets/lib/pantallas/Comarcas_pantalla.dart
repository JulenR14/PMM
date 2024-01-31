// Importando los paquetes necesarios
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutterwidgets/pantallas/ComarcaInfo_pantalla.dart';
import '/utils/Comarques.dart';

// Clase comarcas_pantalla que es un widget con estado
class comarcas_pantalla extends StatefulWidget {
  // Constructor de la clase que recibe el índice de la provincia como parámetro
  comarcas_pantalla({super.key, required this.indiceProvincia});
  int indiceProvincia ;

  // Creando el estado del widget
  @override
  State<comarcas_pantalla> createState() => _provincia_pantallaState();
}

// Clase _provincia_pantallaState que es el estado de comarcas_pantalla
class _provincia_pantallaState extends State<comarcas_pantalla>{
  _provincia_pantallaState();

  // Método para construir el widget
  @override
  Widget build(BuildContext context) {
    // Retornando el widget Scaffold
    return Scaffold(
        // Creando la barra de la aplicación
        appBar: AppBar(
          title: Text('Comarcas de ${provincies["provincies"][widget.indiceProvincia]["provincia"]}',
            style: const TextStyle(
                fontSize: 30,
                fontWeight: FontWeight.bold,
                color: Colors.black,
                fontFamily: 'MyFuente'
            ),
          ),
          centerTitle: true,
          backgroundColor: Colors.transparent,
          ),
      // Creando el cuerpo de la aplicación
      body: Container(
        decoration: const BoxDecoration(
          image: DecorationImage(
              opacity: 0.2,
              image: AssetImage("assets/images/background.png"), // Imagen de fondo
              repeat: ImageRepeat.repeat
          ),
        ),
        child: ListView.builder(
            itemCount: crearListaCards()!.length,
            itemBuilder: (BuildContext context, int index){
              return crearListaCards()![index];
            }
          ),

      )
    );
  }

  // Método para crear una lista de tarjetas
  List<Widget>? crearListaCards(){
    List<Widget> listaCards = [];

    // Iterando sobre las comarcas de la provincia seleccionada
    provincies["provincies"][widget.indiceProvincia]["comarques"].forEach((comarca) {
      // Añadiendo una tarjeta para cada comarca
      listaCards.add(
        Padding(padding: const EdgeInsets.only(bottom: 10),
            child: GestureDetector(
              // Al hacer tap en la tarjeta, se navega a la pantalla de información de la comarca
              onTap: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => comarcasInfo_pantalla(comarca: comarca)));
              },
              child: Stack(
                children: <Widget>[
                  // Mostrando la imagen de la comarca
                  Image.network(comarca["img"],
                    width: MediaQuery.of(context).size.width,
                    height: 200,
                    fit: BoxFit.cover,),
                  // Mostrando el nombre de la comarca
                  Positioned(
                    bottom: 0,
                      left: 20,
                      child: Text(comarca["comarca"],
                        style: const TextStyle(
                            fontSize: 50,
                            fontWeight: FontWeight.bold,
                            color: Colors.white,
                            fontFamily: 'MyFuente',
                            shadows: [
                              Shadow(
                                blurRadius: 10.0,
                                color: Colors.black,
                                offset: Offset(5.0, 5.0),
                              ),
                            ]
                        ),
                      ),
                  )
                ],
              )
            ),
      ));
    });
    return listaCards;
  }
}