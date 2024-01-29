
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class comarcas_pantalla extends StatefulWidget {
  const comarcas_pantalla({super.key});

  @override
  State<comarcas_pantalla> createState() => _provincia_pantallaState();
}

class _provincia_pantallaState extends State<comarcas_pantalla>{

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          title: const Text("Comarcas de la Provincia",
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
      body: const Text("Comarcas de la Comunitat Valenciana")
    );
  }
}