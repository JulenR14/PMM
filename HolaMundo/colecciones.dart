void main() {
  /// Llista nul·la
  List llista_nula;
  // Llista Buida
  List llistaBuida=[];
  // Llista buida especificant el tipus
  List<String> llistaBuida2=[]; // Forma 1
  List<String> _llista=<String>[]; // Forma 2
  // Llista amb valors
  List laborals=['dilluns' , 'dimarts', 'dimecres', 'dijous', 'divendres'];
  // Llista amb valors especificant el tipus
  List<String> festius=['dissbte', 'diumenge'];

  //Mnnipulación
  print('Manipulació');
  // Accés a una posició
  print(laborals[3]);
  // Afegint elements a la llista
  llistaBuida.add("Element");
  // Modificant un element existent a la llista
  // Compte! Aquest element ha d'existir! No afig elements!
  llistaBuida[0]="Element 2";
  // Eliminant l'últim element de la llista
  laborals.removeLast();
  // Eliminant un element en una posició de la llista
  laborals.removeAt(3);
  // Ampliant una llista completa al final d'altra
  List diesSetmana=[];
  diesSetmana.addAll(laborals);
  diesSetmana.addAll(festius);
  print (diesSetmana);

  //Sets
  print('\nSets');
  // Declarem un conjunt a partir d'una llista
  var moduls = Set.from(["PMDM", "AD", "PSP", "DI", "SGI"]);
  // Per afegir elements, fem ús d'add:
  moduls.add("EIE");
  print(moduls);
  // I els eliminem amb remove:
  moduls.remove("EIE");
  print(moduls);

  // Per saber si existeix un element al conjunt fem ús de contains
  print (moduls.contains("EIE"));

  //Diccionaris
  // Definició d'un mapa i assignació de valors
  print('\nDiccionarios - Maps');
  Map notes;
  notes={ "PMDM": 8, "AD": 9, "PSP":9, "DI":7};
  // Accés
  print(notes["PMDM"]);
  notes["DI"]=9;
  // Definició del mapa especificant els tipus:
  Map<String, int> mapa2;
  // Definició del mapa especificant un tipus dinàmic per al valor
  Map<String, dynamic> mapa3;
  // Afegint nous elements al mapa
  // Si ja existeix la clau, es modifica el valor
  notes["EIE"]=10;
  // Eliminant elements
  notes.remove("PMDM");
  // Per saber si un element existeix
  print (notes.containsKey("PMDM"));

  //Recorregut de llistes
  print('\nRecorrido listas');
  List laborals3 = ['dilluns', 'dimarts', 'dimecres', 'dijous', 'divendres'];

  for (String dia in laborals3) {
    print(dia);
  }

  print('\nBucle forEach');
  laborals3.forEach((dia) {
    print(dia);
  });

  print('\nforEach fletxa');
  laborals3.forEach((dia) => print(dia));

  print('\nRecorrido de Maps');
  Map<String, int> notes2 = {"PMDM": 8, "AD": 9, "PSP": 9, "DI": 7};
  for (String modul in notes2.keys) {
    print("Mòdul: $modul, nota: ${notes[modul]}");
  }
  print('\nrecorrido Maps forEach');
  notes2.forEach((key, value) => print("Mòdul: $key, nota: $value"));

  //Mapeado de estructuras
  print('\nMapeado de estructuras');
  print(moduls);
  // I are utilitzem el mètode map per processar
  // cadascun dels elements del conjunt
  // (En aquest cas, els convertim a minúscula)
  var moduls2=moduls.map((item) {
    return item.toString().toLowerCase();
  });
  print (moduls2);
}