
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';

class comarcasInfo_pantalla extends StatefulWidget {
  comarcasInfo_pantalla({super.key, required this.comarca});
  dynamic comarca;

  @override
  State<comarcasInfo_pantalla> createState() => _provincia_pantallaState();
}

class _provincia_pantallaState extends State<comarcasInfo_pantalla>{
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      body: Center(
        child: Text("Pantalla de información de la comarca ${widget.comarca["comarca"]}"),
      ),
    );
  }

}