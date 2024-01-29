
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutterwidgets/pantallas/ComarcaInfo_pantalla.dart';
import '/utils/Comarques.dart';

class comarcas_pantalla extends StatefulWidget {
  comarcas_pantalla({super.key, required this.indiceProvincia});
  int indiceProvincia ;

  @override
  State<comarcas_pantalla> createState() => _provincia_pantallaState();
}

class _provincia_pantallaState extends State<comarcas_pantalla>{
  _provincia_pantallaState();

  @override
  Widget build(BuildContext context) {
    return Scaffold(
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

  List<Widget>? crearListaCards(){
    List<Widget> listaCards = [];

    provincies["provincies"][widget.indiceProvincia]["comarques"].forEach((comarca) {
      listaCards.add(
        Padding(padding: const EdgeInsets.only(bottom: 10),
            child: GestureDetector(
              onTap: () {
                Navigator.push(
                  context,
                  MaterialPageRoute(builder: (context) => comarcasInfo_pantalla(comarca: comarca)));
              },
              child: Stack(
                children: <Widget>[
                  Image.network(comarca["img"],
                    width: MediaQuery.of(context).size.width,
                    height: 200,
                    fit: BoxFit.cover,),
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