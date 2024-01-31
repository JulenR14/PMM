// Importando los paquetes necesarios
import 'package:flutter/material.dart';
import 'package:flutterwidgets/pantallas/Provincia_pantalla.dart';

// Función principal de la aplicación
void main() {
  runApp(const MyApp());
}

// Clase MyApp que es un widget sin estado
class MyApp extends StatelessWidget {
  const MyApp({super.key});

  // Este widget es la raíz de tu aplicación.
  @override
  Widget build(BuildContext context) {
    // MaterialApp es el widget de nivel superior que proporciona el tema a la aplicación
    return MaterialApp(
      title: 'Comarcas de la Comunitat',
      debugShowCheckedModeBanner: false,
      theme: ThemeData(
        colorScheme: ColorScheme.fromSeed(seedColor: Colors.deepPurple),
        useMaterial3: true,
      ),
      home: const MyHomePage(title: 'Comarcas de la Comunitat'),
    );
  }
}

// Clase MyHomePage que es un widget con estado
class MyHomePage extends StatefulWidget {
  const MyHomePage({super.key, required this.title});
  final String title;

  @override
  State<MyHomePage> createState() => _MyHomePageState();
}

// Clase _MyHomePageState que es el estado de MyHomePage
class _MyHomePageState extends State<MyHomePage> {

  @override
  Widget build(BuildContext context) {
    // El widget SafeArea se utiliza para asegurarse de que la aplicación no esté debajo de la barra de estado
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
                            // Campo de entrada del usuario
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
                            // Campo de entrada de la contraseña
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
                                      // Botón de inicio de sesión
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
                                      // Botón de registro
                                      Padding(padding: const EdgeInsets.symmetric(horizontal: 10),
                                          child: FilledButton.tonal(
                                              style: ButtonStyle(
                                                backgroundColor: MaterialStateProperty.all(Colors.blueGrey),
                                              ),
                                              onPressed: (){
                                                showDialog(
                                                  context: context,
                                                  builder: (BuildContext context) {
                                                    return Dialog(
                                                      child: Container(
                                                        height: 375,
                                                        child: AlertDialog(
                                                          title:const  Text('Registro'),
                                                          content: const Column(
                                                            children: <Widget>[
                                                              TextField(
                                                                decoration: InputDecoration(
                                                                  hintText: 'Usuario',
                                                                ),
                                                              ),
                                                              TextField(
                                                                decoration: InputDecoration(
                                                                  hintText: 'Contraseña',
                                                                ),
                                                                obscureText: true,
                                                              ),
                                                              TextField(
                                                                decoration: InputDecoration(
                                                                  hintText: 'Confirmar Contraseña',
                                                                ),
                                                                obscureText: true,
                                                              ),
                                                            ],
                                                          ),
                                                          actions: <Widget>[
                                                            TextButton(
                                                              child: Text('Cancelar'),
                                                              onPressed: () {
                                                                Navigator.of(context).pop();
                                                              },
                                                            ),
                                                            TextButton(
                                                              child: Text('Registrar'),
                                                              onPressed: () {
                                                                // Aquí puedes poner la lógica para registrar al usuario
                                                                Navigator.of(context).pop();
                                                              },
                                                            ),
                                                          ],
                                                        )
                                                    )
                                                    );
                                                  },
                                                );
                                              },
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
                        )
                    )
                    ,
                  )
              )
              )
            );
  }
}