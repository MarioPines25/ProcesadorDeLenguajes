import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class AutomataFinitoDeterminista {
	/* Esta clase representa el AFD correspondiente al lenguaje javaScriptPL
	 * --- Consta de 3 listas para errores, lexemas y tokens asi como 3 variables,
	 * dos de tipo entero para representar el indice y el estado y otra de tipo 
	 * cadena para ir acumulando el lexema generador del token. */
	ArrayList<String>arrErrores;
	ArrayList<String>arrLexemas;
	ArrayList<String>arrToken;

	int indice;
	int estado;
	String lexema;

	String ruta; //Ruta del fichero de entrada == fichero de entrada

	/* metodo que inicializa las variables del automata */
	private void inicializar(){
		indice=0;
		estado=0;
		lexema="";
		arrErrores= new ArrayList();
		arrLexemas= new ArrayList();
		arrToken= new ArrayList();
	}
	/* metodo que va recorriendo el texto de entrada */
	private void analizar() throws IOException{
		String limpio;//Variable que va almacenando las lineas de texto
		FileReader fr = new FileReader(ruta);
		BufferedReader br = new BufferedReader(fr);
		while((limpio=br.readLine())!=null){
			for(int i=0;i<limpio.length();i++){//Recorremos la linea de texto leida
				char letra = limpio.charAt(i);//Analizamos el caracter uno por uno
				switch(letra){
				/* Si el caracter es un delimitador dejamos de analizar,
				 * si no guardamos en el texto en claro dicho caracter */
				case '\r':
				case '\t':
				case '\n':
				case '\b':
				case '\f':
					break;
				default:
					limpio+=letra;

				}//Fin switch
			}//Fin for
			/* En este punto analizamos lo que va teniendo el texto limpio */
			for(indice=0;indice<limpio.length();indice++){
				//Volvemos a tomar la letra
				char letra=limpio.charAt(indice);
				int valor = letra; //Tomamos el valor de la letra para poder evaluarla
				switch(estado){
				case 0:
					
					if(letra=='*'){
						estado = 1;
						lexema = ""+letra;
					}//Fin if 
					
					/* Comprobamos si es un digito */
					else if(esNumeroAscii(letra)){
						estado=2;
						lexema=""+letra;
					}//Fin elseif
					
					/*Si tenemos letra mayuscula o minuscula:
					 * 	comprobamos si esta dentro del rango ASCII*/
					else if(esLetraAscii(letra)){
						estado = 3;
						lexema = ""+letra;
					}//Fin elseif
					
					/*Comprobamos si es separador */
					else if(esSeparador(letra)){
						lexema =""+letra;
						genToken(lexema);//Generamos el token
					}// Fin elseif
					
					/*Comprobamos si es operador */
					else if(esOperador(letra)){
						lexema=""+letra;
						genToken(lexema);//Generamos el token 
					}// Fin elseif
				}//Fin swtich
			}//Fin for
		}//Fin while
	}//Fin analizar()
	
	/* Metodo que genera el token segun el lexema(in) de entrada */
	private String genToken(String in) {
		return in; // Salida <TipoToken, valor>
	}
	
	/***************************
	 * Metodos auxiliares ******
	 * *************************/
	
	/* Metodo que comprueba si el char de entrada es un separador */
	private boolean esSeparador(char sep) {
		switch (sep){
		case '(':return true;
		case ')':return true;
		case '[':return true;
		case ']':return true;
		case '{':return true;
		case '}':return true;
		case ';':return true;
		default: return false;
		}
	}

	/* Metodo que comprueba si el char de entrada es un operador */
	private boolean esOperador(char sep) {
		switch (sep){
		case '+':return true;
		case '-':return true;
		case '<':return true;
		case '>':return true;
		case '=':return true;
		case '!':return true;
		default: return false;
		}
	}
	
	/* OJO: (cond)?r1:r2 devuelve r1 si cond es cierto
	 * y r2 si es falso */
	
	/* Metodo que devuelve si es un numero ASCII */
	private boolean esNumeroAscii(char l){
		return (l>=48 && l<=57)?true:false;
	}
	
	/* Metodo que devuelve si es letra ASCII */
	private boolean esLetraAscii(char l){
		return ((l>=65&&l<=90)||
				(l>=97&&l<=122))?true:false;
	}
}
