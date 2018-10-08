package AnalizadorLexico;
import static AnalizadorLexico.Token.Tipos;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class AnalisisLexico {



	public static void main(String[] args) {
		File fichero = new File("RUTA");
		String input;
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
				for (Token token : tokens) {
					System.out.println("(" + token.getTipo() + ": " + token.getValor() + ")");
				}
		    }
		    
		    fr.close();
		}catch(Exception e){
			System.out.println("Excepcion leyendo fichero "+ fichero + ": " + e);
		}
		
		
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
