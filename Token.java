package AnalizadorLexico;

public class Token {
	public Tipos getTipo() {
        return tipo;
    }

    public void setTipo(Tipos tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    private Tipos tipo;
    private String valor;

    enum Tipos {
        CONSTANTE_ENTERA ("[0-9]+"),
        OPERADOR_ARITMETICO("+-*"),
        OPERADOR_RELACIONAL("<>"),
        OPERADOR_LOGICO("!"),
        PALABRA_RESERVADA("[A-Z, a-z"),
        PARENTESIS("()[]{}"),
        COMENTARIOS("/*")
        
        ;
        public final String patron;
        Tipos(String s) {
            this.patron = s;
        }
    }

}
