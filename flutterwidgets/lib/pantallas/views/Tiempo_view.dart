
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
    return Center(
        child: Column(
          children: [
            Image.network(
              "https://creazilla-store.fra1.digitaloceanspaces.com/emojis/49852/sun-behind-cloud-emoji-clipart-md.png",
              height: 350,
            ),
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