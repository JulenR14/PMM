
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class comarcasTiempo_pantalla extends StatefulWidget {
  comarcasTiempo_pantalla({super.key});

  @override
  State<comarcasTiempo_pantalla> createState() => _comarcasTiempo_pantalla();
}

class _comarcasTiempo_pantalla extends State<comarcasTiempo_pantalla>{
  @override
  Widget build(BuildContext context) {
    return const Scaffold(
      body: Center(
        child: Text("Pantalla del Tiempo de la comarca"),
      ),
    );
  }

}