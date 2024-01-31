// Importando los paquetes necesarios
import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutterwidgets/pantallas/views/Informacion_view.dart';
import 'package:flutterwidgets/pantallas/views/Tiempo_view.dart';

// Clase comarcasInfo_pantalla que es un widget con estado
class comarcasInfo_pantalla extends StatefulWidget {
  // Constructor de la clase que recibe la comarca como parámetro
  comarcasInfo_pantalla({super.key, required this.comarca});
  dynamic comarca;

  // Creando el estado del widget
  @override
  State<comarcasInfo_pantalla> createState() => _provincia_pantallaState();
}

// Clase _provincia_pantallaState que es el estado de comarcasInfo_pantalla
class _provincia_pantallaState extends State<comarcasInfo_pantalla>{

  // Variable para almacenar el índice de la vista seleccionada
  int indexSeleccionado = 0;

  // Método para construir el widget
  @override
  Widget build(BuildContext context) {
    // Creando las vistas de la información de la comarca y del tiempo
    final views = [comarcasInformacion_view(comarca: widget.comarca,), comarcasTiempo_pantalla(comarca: widget.comarca)];

    // Retornando el widget Scaffold
    return Scaffold(
      // Creando la barra de la aplicación
      appBar: AppBar(
        title: Text(widget.comarca["comarca"]),
        centerTitle: true,
        backgroundColor: Colors.white,
      ),
      // Creando el cuerpo de la aplicación
      body: IndexedStack(
        index: indexSeleccionado,
        children: views,
      ),
      // Creando la barra de navegación inferior
      bottomNavigationBar: BottomNavigationBar(
        type: BottomNavigationBarType.shifting,
        currentIndex: indexSeleccionado,
        // Función para cambiar la vista seleccionada
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