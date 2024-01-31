// Importando el paquete necesario
import 'package:flutter/material.dart';

// Clase comarcasTiempo_pantalla que es un widget con estado
class comarcasTiempo_pantalla extends StatefulWidget {
  // Constructor de la clase que recibe la comarca como parámetro
  comarcasTiempo_pantalla({super.key, required this.comarca});
  dynamic comarca;

  // Creando el estado del widget
  @override
  State<comarcasTiempo_pantalla> createState() => _comarcasTiempo_pantallaState();
}

// Clase _comarcasTiempo_pantallaState que es el estado de comarcasTiempo_pantalla
class _comarcasTiempo_pantallaState extends State<comarcasTiempo_pantalla>{

  // Método para construir el widget
  @override
  Widget build(BuildContext context) {
    // Retornando un widget Center que contiene la información del tiempo en la comarca
    return Center(
        child: Column(
          children: [
            // Mostrando una imagen de un sol detrás de una nube
            Image.network(
              "https://creazilla-store.fra1.digitaloceanspaces.com/emojis/49852/sun-behind-cloud-emoji-clipart-md.png",
              height: 350,
            ),
            // Mostrando la temperatura actual
            const Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children:  [
                Icon(Icons.thermostat_outlined,
                size: 50,),
                Text("  5.4º",
                  style: TextStyle(
                    fontSize: 50,
                    fontWeight: FontWeight.bold,
                  ),
                ),
              ],
            ),
            // Mostrando la velocidad y dirección del viento
            const SizedBox(height: 20),
            const Row(
              mainAxisAlignment: MainAxisAlignment.center,
              children:  [
                Icon(Icons.wind_power,
                  size: 25,),
                Text("   9.4km/h",
                  style: TextStyle(
                    fontSize: 25
                  ),
                ),
                Text("   Ponent",
                  style: TextStyle(
                      fontSize: 25
                  ),
                ),
                Icon(Icons.arrow_back),
              ],
            ),
            // Mostrando la población, latitud y longitud de la comarca
            const SizedBox(height: 20),
            Text("Població:        ${widget.comarca["poblacio"]}",
              style: const TextStyle(
                  fontSize: 25
              ),
            ),
            Text("Latitud:        ${widget.comarca["coordenades"][0]}",
              style: const TextStyle(
                  fontSize: 25
              ),
            ),
            Text("Longitud:        ${widget.comarca["coordenades"][1]}",
              style: const TextStyle(
                  fontSize: 25
              ),
            ),
              ],
    ));
  }
}