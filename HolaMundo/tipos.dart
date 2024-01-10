var dia='dijous'; // Infereix el tipus a String
String dia2='dimarts'; // Definim un String
int numero=42; // Definim un enter
bool laborable=true; // Definim un valor lògic
// També podem realitza conversions de tipus
String cadena_numero="1"; // Definim un String que conté un número
int numero2=int.parse(cadena_numero); // Converteix la cadena "1" a un tipus numèric


const curs='Flutter';

int? variable1; // variable1 podrà contenir el valor null

/*Operador d’asserció nul·la (null assertion operator) (!): S’utilitza quan volem assignar una
variable que pot contenir nuls a variables que no en poden contenir.*/
int variable2=variable1!;


enum DiesSetmana { dilluns, dimarts, dimecres, dijous, divendres, dissabte, diumenge }
List<DiesSetmana> Dies = DiesSetmana.values;

void main(List<String> args){
  int? variable1;
  print('• Operador d’asserció nul·la (null assertion operator) (!):');
  try{
    int variable2=variable1!;
    print(variable2);
  } catch (e){
    print(e.runtimeType); // -> NullError
    print(e); // -> NoSuchMethodError: t1 is null
  }

  /*Operador nul (??): Aquest operador retorna el valor resultant de l’expressió de la part esque-
ra de l’operador, sempre que no siga nul. En cas contrari ens retornarà l’expressió de la dreta.
Podem veure-ho com una mena d’operador condicional als valors nuls:*/
  print('\n->Operador null ??');
  var nom;
  // Escriu el nom si no és nul, o escriu "Anònim"
  print(nom ?? "Anònim");

  /*Assignació conscient de nuls (null aware assignment) (??=): Assigna un valor a una varia-
ble si aquesta té valor nul. En cas que la variable tinga un valor prèviament diferent a null, no
s’assignarà.*/
  print('\n->Assignació concient dels nulls:');
  int? variable11; // Si no indiquem nullable donaría error (coincideix amb l'anterior)
  print(variable11); // Mostra null
  variable11 ??= 10;
  print(variable11); // Mostra "10"
  variable11 ??= 15;
  print(variable11); // Mostra "10", ja que variable1 tenia ja valor.


/*Els tipus enumerats en Dart (enum), com en altres llenguatges, ens serveixen per a representar un
nombre fix de valors constants.*/
  DiesSetmana dia=DiesSetmana.dilluns;
  print('\n->Enumerats');
  print(Dies);
  print(dia);

}