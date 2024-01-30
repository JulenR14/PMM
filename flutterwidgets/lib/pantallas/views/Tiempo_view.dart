
import 'package:flutter/material.dart';

class comarcasTiempo_pantalla extends StatefulWidget {
  comarcasTiempo_pantalla({super.key, required this.comarca});
  dynamic comarca;

  @override
  State<comarcasTiempo_pantalla> createState() => _comarcasTiempo_pantallaState();
}

class _comarcasTiempo_pantallaState extends State<comarcasTiempo_pantalla>{

  @override
  Widget build(BuildContext context) {
    return Container(
      child: const Center(
        child: Text("Aqui va el tiempo"),
      ),
    );
  }
}