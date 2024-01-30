
import 'package:flutter/material.dart';

class comarcasInformacion_view extends StatefulWidget {
  comarcasInformacion_view({super.key, required this.comarca});
  dynamic comarca;

  @override
  State<comarcasInformacion_view> createState() => _comarcasInfo_pantallaState();
}

class _comarcasInfo_pantallaState extends State<comarcasInformacion_view>{

  @override
  Widget build(BuildContext context) {
    return Column(
       children: [
         AspectRatio(
           aspectRatio: MediaQuery.of(context).size.width / 250,
           child: Image.network(
             widget.comarca["img"],
             fit: BoxFit.fill,
           ),
         ),
         Padding(padding: EdgeInsets.only(top: 30),
           child: Text('${widget.comarca["comarca"]}',
           textAlign: TextAlign.left,
           style: const TextStyle(
             fontSize: 35,
             color: Colors.blueGrey,

             ),
           )
         )

       ],
     );
  }
}