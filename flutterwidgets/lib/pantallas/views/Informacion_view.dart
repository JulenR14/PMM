// Importando el paquete necesario
import 'package:flutter/material.dart';

// Clase comarcasInformacion_view que es un widget con estado
class comarcasInformacion_view extends StatefulWidget {
  // Constructor de la clase que recibe la comarca como parámetro
  comarcasInformacion_view({super.key, required this.comarca});
  dynamic comarca;

  // Creando el estado del widget
  @override
  State<comarcasInformacion_view> createState() => _comarcasInfo_pantallaState();
}

// Clase _comarcasInfo_pantallaState que es el estado de comarcasInformacion_view
class _comarcasInfo_pantallaState extends State<comarcasInformacion_view>{

  // Método para construir el widget
  @override
  Widget build(BuildContext context) {
    // Retornando un widget Column que contiene la información de la comarca
    return Column(
       children: [
         // Mostrando la imagen de la comarca con un aspect ratio adecuado
         AspectRatio(
           aspectRatio: MediaQuery.of(context).size.width / 250,
           child: Image.network(
             widget.comarca["img"],
             fit: BoxFit.fill,
           ),
         ),
         // Mostrando el nombre de la comarca
         Padding(padding: const EdgeInsets.only(top: 30),
           child: Text('${widget.comarca["comarca"]}',
           textAlign: TextAlign.left,
           style: const TextStyle(
             fontSize: 35,
             color: Colors.blueGrey,
             ),
           )
         ),
         // Mostrando la capital de la comarca
         Padding(padding: const EdgeInsets.only(top: 10),
             child: Text('Capital: ${widget.comarca["capital"]}',
               textAlign: TextAlign.left,
               style: const TextStyle(
                 fontSize: 20,
                 color: Colors.black,
               ),
             )
         ),
         // Mostrando la descripción de la comarca
         Padding(padding: const EdgeInsets.only(top: 15, left: 20, right: 20),
         child: Text('${widget.comarca["desc"]}',
           textAlign: TextAlign.justify,
           )
         )
       ],
     );
  }
}