package AnalizadorLexico;

import static AnalizadorLexico.Token.Tipos;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class Automata {
	String bufferIn= new String();
	String ruta;/*Hay que dar una ruta en el equipo rollo: /User/piqui...*/
	private static String GenToken(char c) {
		String token=new String();

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

	private void cogerLinea(){
		try {
			FileReader fr = new FileReader(ruta);
			BufferedReader br = new BufferedReader(fr);//La variable fr debe recorrer el fichero de entrada

			while((bufferIn=br.readLine())!=null){
				q0(bufferIn);
			}

		} catch (IOException e) {
			System.out.println("No se ha podido leer la linea +e");
		}
	}

	public void q0(String in){
		for(int i=0;i<in.length();i++){
			char c = in.charAt(i);
			if(esSeparador(c)){
				GenToken(c); //Generamos separador;
			}
			if(c=='/'){
				q6(c);//evaluamos los comentarios.
			}
			if(c=='*'){
				q1(c);
			}
			if(Character.isLetter(c)){
				q2(c);
			}
			if(Character.isDigit(c)){
				q3(c);
			}
			if(c=='"'){
				q5(c);
			}
			if(esOperador(c)){//Evaluar los operadores 
				GenToken(c);
			}
		}
	}
	
	public void q1(char in){
		if(){
			
		}
	}
	public void q2(char in){}
	public void q3(char in){}
	public void q4(char in){}
	public void q5(char in){}
	public void q6(char in){}
	public void q7(char in){}
	public void q8(char in){}//evaluar los comentarios.
	public void q9(char in){}
	public void q10(char in){}
	public void q11(char in){}
	public void q12(char in){}
	public void q13(char in){}
	public void q14(char in){}
	public void q15(char in){}
	
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
}
