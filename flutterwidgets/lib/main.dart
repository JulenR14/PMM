import 'package:flutter/material.dart';
import 'package:flutterwidgets/pantallas/Provincia_pantalla.dart';

void main() {
  runApp(const MyApp());
}

class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Comarcas de la Comunitat',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
        useMaterial3: true,
      ),
      home: const MyHomePage(title: 'Comarcas de la Comunitat'),
      //home: const provincia_pantalla(),
    );
  }
}

class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});
  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

class _MyHomePageState extends State<MyHomePage> {

  @override
  Widget build(BuildContext context) {
    //para que la app no este por debajo de la barra de estado
    return SafeArea(
            child: Scaffold(
              body: SingleChildScrollView(
                  child: Container(
                    height: MediaQuery.of(context).size.height - MediaQuery.of(context).padding.top,
                    decoration: const BoxDecoration(
                      image: DecorationImage(
                          opacity: 0.2,
                          image: AssetImage("assets/images/background.png"), // Imagen de fondo
                          repeat: ImageRepeat.repeat
                      ),
                    ),
                    child: Center(
                        child: Column(
                          //alineamos el contenido en el centro
                          mainAxisAlignment: MainAxisAlignment.center,
                          children: [
                            Image.asset("assets/images/LogoInstituto.png",
                                scale: 2),
                            const Padding(padding: EdgeInsets.only(top: 20),
                                child: Text("Les Comarques de la Comunitat Valenciana",
                                  style: TextStyle(
                                      fontSize: 40,
                                      fontWeight: FontWeight.bold,
                                      color: Colors.black,
                                      fontFamily: 'MyFuente'
                                  ),
                                  textAlign: TextAlign.center,
                                )
                            ),

                            const Padding(padding: EdgeInsets.symmetric(horizontal: 30, vertical: 20),
                              child: TextField(
                                decoration: InputDecoration(
                                  border: OutlineInputBorder(),
                                  hintText: 'Usuario',
                                  fillColor: Colors.white,
                                  filled: true,
                                ),
                              ),
                            ),
                            const SizedBox(width: 30),
                            const Padding(padding: EdgeInsets.symmetric(horizontal: 30, vertical: 20),
                                child: TextField(
                                  obscureText: true,
                                  decoration: InputDecoration(
                                    border: OutlineInputBorder(),
                                    hintText: 'Contraseña',
                                    fillColor: Colors.white,
                                    filled: true,
                                  ),
                                )
                            ),
                            Padding(padding:const EdgeInsets.symmetric(horizontal: 30, vertical: 20),
                                child: Center(
                                  child: Row(
                                    mainAxisAlignment: MainAxisAlignment.center,
                                    children: [
                                      Padding(padding: const EdgeInsets.symmetric(horizontal: 10),
                                          child: FilledButton.tonal(
                                              style: ButtonStyle(
                                                backgroundColor: MaterialStateProperty.all(Colors.blueGrey),
                                              ),
                                              onPressed: () {
                                                Navigator.push(
                                                  context,
                                                  MaterialPageRoute(builder: (context) => const provincia_pantalla()),
                                                );
                                              },
                                              child: const Text("Log in",
                                                  style: TextStyle(
                                                      color: Colors.white
                                                  )
                                              )
                                          )),
                                      Padding(padding: const EdgeInsets.symmetric(horizontal: 10),
                                          child: FilledButton.tonal(
                                              style: ButtonStyle(
                                                backgroundColor: MaterialStateProperty.all(Colors.blueGrey),
                                              ),
                                              onPressed: null,
                                              child: const Text("Sign up",
                                                style: TextStyle(
                                                    color: Colors.white
                                                ),
                                              )
                                          )
                                      ),
                                    ],
                                  ),
                                )
                            )
                          ],
                          //añadimos los widgets hijos con el texto y el contador
                        )
                    )
                    ,
                  )
              )
              )
            );
  }
}
