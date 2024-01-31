
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutterwidgets/pantallas/views/Informacion_view.dart';
import 'package:flutterwidgets/pantallas/views/Tiempo_view.dart';

class comarcasInfo_pantalla extends StatefulWidget {
  comarcasInfo_pantalla({super.key, required this.comarca});
  dynamic comarca;

  @override
  State<comarcasInfo_pantalla> createState() => _provincia_pantallaState();
}

class _provincia_pantallaState extends State<comarcasInfo_pantalla>{

  int indexSeleccionado = 0;

  @override
  Widget build(BuildContext context) {
    final views = [comarcasInformacion_view(comarca: widget.comarca,), comarcasTiempo_pantalla(comarca: widget.comarca)];

    return Scaffold(
      appBar: AppBar(
        title: Text(widget.comarca["comarca"]),
        centerTitle: true,
        backgroundColor: Colors.white,
      ),
      body: IndexedStack(
        index: indexSeleccionado,
        children: views,
      ),
      bottomNavigationBar: BottomNavigationBar(
        type: BottomNavigationBarType.shifting,
        currentIndex: indexSeleccionado,
        onTap: (index){
          setState(() {
            indexSeleccionado = index;
          });
        },
        elevation: 0,
        items:const [
          BottomNavigationBarItem(
            icon: Icon(Icons.info_outline),
            activeIcon: Icon(Icons.info),
            label: 'Info',
            backgroundColor: Colors.lightBlue,
          ),
          BottomNavigationBarItem(
            icon: Icon(Icons.wb_sunny_outlined),
            activeIcon: Icon(Icons.wb_sunny),
            label: 'Tiempo',
            backgroundColor: Colors.blueAccent,
          )
        ],
      ),
    );
  }

}