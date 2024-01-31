# Flutter Widgets

Esta es una aplicación desarrollada en Flutter que proporciona información sobre las provincias y comarcas de la Comunidad Valenciana.

## Características

- La aplicación muestra una lista de provincias de la Comunidad Valenciana.
- Al seleccionar una provincia, se muestra una lista de comarcas pertenecientes a esa provincia.
- Al seleccionar una comarca, se muestra información detallada sobre esa comarca, incluyendo su capital, población, descripción y una imagen.
- La aplicación también proporciona información sobre el clima en cada comarca.

## Tecnologías Utilizadas

- Flutter: Un framework de UI de código abierto de Google para crear aplicaciones móviles de alta calidad para iOS y Android a partir de una única base de código.
- Dart: El lenguaje de programación utilizado para desarrollar aplicaciones Flutter.
- HTTP: Una biblioteca para realizar solicitudes HTTP en Dart.
- Material Design: Un sistema de diseño que combina teoría del diseño, recursos y herramientas para ayudar a los desarrolladores a crear experiencias digitales.

## Cómo Ejecutar la Aplicación

1. Asegúrate de tener instalado Flutter y Dart en tu sistema.
2. Clona este repositorio en tu máquina local.
3. Navega hasta el directorio del proyecto en tu terminal.
4. Ejecuta `flutter pub get` para instalar las dependencias necesarias.
5. Ejecuta `flutter run` para iniciar la aplicación en un emulador o dispositivo físico.

## Estructura del Proyecto

El proyecto sigue una estructura de directorios estándar de Flutter:

- `lib/`: Este directorio contiene el código fuente de la aplicación. Se divide en varios subdirectorios:
    - `main.dart`: El punto de entrada de la aplicación.
    - `pantallas/`: Contiene los archivos de las diferentes pantallas de la aplicación.
    - `utils/`: Contiene archivos de utilidades, como datos de provincias y comarcas.
- `pubspec.yaml`: Este archivo define el nombre de la aplicación, la versión, la descripción y las dependencias.

