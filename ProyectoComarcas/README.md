# Proyecto Dart Comarca

Este proyecto es una aplicación Dart que obtiene y muestra información sobre regiones geográficas, denominadas "Comarcas".

## Descripción de la Clase

La clase principal en este proyecto es `Comarca`. Esta clase representa una región geográfica con varios atributos:

- `comarca`: El nombre de la región.
- `capital`: La capital de la región.
- `poblacio`: La población de la región.
- `img`: Una imagen que representa la región.
- `desc`: Una descripción de la región.
- `latitud`: La latitud de la región.
- `longitud`: La longitud de la región.

La clase `Comarca` tiene un método `imprimirInfo` que imprime toda la información del objeto `Comarca`.

## Ejecución de la Aplicación

Para ejecutar la aplicación, necesitas pasar argumentos de línea de comandos. El primer argumento es el tipo de información que quieres obtener (`comarcas` o `infocomarca`), y el segundo argumento es el nombre de la región que te interesa.

Por ejemplo, para obtener información sobre una región específica, ejecutarías:

```bash
dart bin/main.dart infocomarca [nombre_de_la_region]