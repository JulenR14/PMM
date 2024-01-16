/*Funció sense arguments i sense valor de retorn
void funcio(){
  // Cos de la funció
}

• Funció amb arguments i sense valor de retorn
void funcio(tipus1 argument1, ..., tipusN argumentN){
  // Cos de la funció
}
• Funció amb arguments i amb valor de retorn
tipusRetorn funcio(tipus1 argument1, ..., tipusN argumentN){
  // Cos de la funció
  return ValorDeTipusRetorn;
}
*/

int funcio(arg1, arg2, callback) => callback(arg1, arg2);

void f1(int obligatori, [int opcional = 0]) {
  print("${obligatori}, ${opcional}");
}
void f2(int obligatori, {int opcionalAmbNom = 0}) {
  print("${obligatori}, ${opcionalAmbNom}");
}

 void main() {
  /*Dart admet funcions sense nom o funcions anònimes, que no poden ser invocades directament, però
  que es poden utilitzar com a callbacks, és a dir, com a arguments per a altres funcions.*/
  print('Funció anònima:');
  int valor=funcio(3, 4, (arg1, arg2){
    // Estem dins de la funció anònima
    return (arg1+arg2);
  });
  print(valor);

  //Funció fletxa
  print('\nFunció fletxa');
  print (funcio(3, 4, (arg1, arg2) => arg1+arg2));

  //Arguments posicionals obligatoris, opcionals i amb nom
  print('\nArgumentos posiciones f1');
  f1(1); // Mostra: 1, 0
  //f1(); // Si llancem f1() sense arguments, obtindrem
  // l'error: Context: Found this candidate,
  // but the arguments don't match.

  f1(1, 2); // Mostra: 1, 2
  print('\nf2');
  f2(1); // Mostra: 1, 0
// f2(1, 2); // Si proporcionem dos arguments a f2, però
// sense indicar el nom, rebrem de nou un error.

  f2(1, opcionalAmbNom: 3); // Mostra 1, 3

}