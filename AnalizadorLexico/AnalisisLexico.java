package AnalizadorLexico;
import static AnalizadorLexico.Token.Tipos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 09/10/2018
	Mario: segun lo que dijo alvaro, he considerado que el array de paso no es necesario. Mi solucion es 
	ir acumulando los caracteres que va leyendo en un String al que se va concatenando cada char hasta que se
	encuentre un blanco. Cuando se encuentre el blanco se genera el token ya que ha terminado de leer una entrada
	del fichero. 
		No se que os parece, dejo comentado lo que ya estaba y añado mis lineas */

public class AnalisisLexico {


/*Método de ejecución> java AnalisisLexico FicheroEntrada FicheroSalida*/
	public static void main(String[] args) {
		
		File ficheroEntrada = null, ficheroSalida = null;
		
		if (args.length == 0 || args.length > 2) {
            System.out.println("no arguments valid.");
        }
        else {
            for (int i = 0; i< args.length; i++) {
                ficheroEntrada = new File (args[0]);
                ficheroSalida = new File (args[1]);
                
            }
        }
		try {
			FileReader fr = new FileReader(fichero);
		    BufferedReader br = new BufferedReader(fr);
		    /*esto va linea a linea, no estoy seguro que funcione para los tokens, la cosa es hacerlo letra a letra (char)
		     *mi idea seria pasar linea a linea a un array e ir letra a letra
		     *entonces en el bucle while leeria el fichero, meteria una linea entera en un array
		     *recorreriamos ese array caracter a caracter metiendolo en un array de paso
		     *en el caso de ser un blanco se llamaria a la funcion de generar token (hay que hacerla aunque se pareceria a lexema(String input))
		     *y así deberia recorrer todo el fichero mhhhhh creo que puede funcionar me pongo a ello no se lo que dejare hecho, hablamos por telegram
		     *PD: mirad StringTokenizer
		     */
		    while((input = br.readLine()) != null) {
		    	ArrayList<Token> tokens = lexema(input);
			String palabra=new String();
		    	for(int i = 0; i < input.length(); i++) {
		    		//int j= 0;
		    		if(input.charAt(i) !=  ' ') {//no es un espacio en blanco, se añade
		    			//temp[j] = input.charAt(i);
					palabra+=input.charAt(i);//vamos formando el token hasta encontrar blanco
		    		}
		    		else {//es un espacio en blanco, se analiza y se hace el token
		    			//tokenizador(temp);
					GenToken(palara);//Falta por implementar aun
		    			
		    		}
		    		
		    		
		    	}
				for (Token token : tokens) {
					System.out.println("(" + token.getTipo() + ": " + token.getValor() + ")");
				}
		    }
		    
		    fr.close();
		}catch(Exception e){
			System.out.println("Excepcion leyendo fichero "+ fichero + ": " + e);
		}
		
		
	}
	
	private static String GenToken(String in) {
		String token  = in;
		
		
		return token;/*La salida es algo del estilo "<tipoToken, valor>"*/
	}

	private static ArrayList<Token> lexema(String input) {
		final ArrayList<Token> tokens = new ArrayList<Token>();
		final StringTokenizer st = new StringTokenizer(input);

		while(st.hasMoreTokens()) {
			String palabra = st.nextToken();
			boolean matched = false;

			for (Tipos tokenTipo : Tipos.values()) {
				Pattern patron = Pattern.compile(tokenTipo.patron);
				Matcher matcher = patron.matcher(palabra);
				if(matcher.find()) {
					Token tk = new Token();
					tk.setTipo(tokenTipo);
					tk.setValor(palabra);
					tokens.add(tk);
					matched = true;
				}
			}

			if (!matched) {
				throw new RuntimeException("Se encontró un token invalido.");
			}
		}

		return tokens;
	}
}
