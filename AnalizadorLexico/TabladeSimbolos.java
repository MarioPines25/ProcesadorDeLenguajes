package AnalizadorLexico;

import javax.swing.table.DefaultTableModel;

public class TabladeSimbolos {
	
	DefaultTableModel ts = new DefaultTableModel();

	public void initTS() {
		
		Object [] ts1 = {"boolean","PALABRA_RESERVADA"};
		ts.addRow(ts1);
		Object [] ts2 = {"true","PALABRA_RESERVADA"};
		ts.addRow(ts2);
		Object [] ts3 = {"false","PALABRA_RESERVADA"};
		ts.addRow(ts3);
		Object [] ts4 = {"int","PALABRA_RESERVADA"};
		ts.addRow(ts4);
		Object [] ts5 = {"float", "PALABRA_RESERVADA"};
		ts.addRow(ts5);
		Object [] ts6 = {"double", "PALABRA_RESERVADA"};
		ts.addRow(ts6);
		Object [] ts7 = {"var", "PALABRA_RESERVADA"};
		ts.addRow(ts7);
		Object [] ts8 = {"else", "PALABRA_RESERVADA"};
		ts.addRow(ts8);
		Object [] ts9 = {"if","PALABRA_RESERVADA"};
		ts.addRow(ts9);
		Object [] ts10 = {"return","PALABRA_RESERVADA"};
		ts.addRow(ts10);
		Object [] ts11 = {"void","PALABRA_RESERVADA"};
		ts.addRow(ts11);
		Object [] ts12 = {"while","PALABRA_RESERVADA"};
		ts.addRow(ts12);
		Object [] ts13 = {"do", "PALABRA_RESERVADA"};
		ts.addRow(ts13);
		
		
		Object [] ts14 = {";","PUNTO_COMA"};
		ts.addRow(ts14);
		Object [] ts15 = {".","PUNTO"};
		ts.addRow(ts15);
		Object [] ts16 = {"=","ASIGNACION"};
		ts.addRow(ts16);
		Object [] ts17 = {"==", "IGUALDAD"};
		ts.addRow(ts17);
		Object [] ts18 = {"<","MENOR"};
		ts.addRow(ts18);
		Object [] ts19 = {"*=","MULTI_ASIGNACION"};
		ts.addRow(ts19);
		Object [] ts20 = {">","MAYOR"};
		ts.addRow(ts20);
		Object [] ts21 = {"!","NEGACION"};
		ts.addRow(ts21);


		Object [] ts22 = {"(","PARENT_ABIERTO"};
		ts.addRow(ts22);
		Object [] ts23 = {")","PARENT_CERRADO"};
		ts.addRow(ts23);
		Object [] ts24 = {"{","LLAVE_ABIERTO"};
		ts.addRow(ts24);
		Object [] ts25 = {"}","LLAVE_CERRADO"};
		ts.addRow(ts25);
		Object [] ts26 = {"[","CORCHETE_ABIERTO"};
		ts.addRow(ts26);
		Object [] ts27 = {"]","CORCHETE_CERRADO"};
		ts.addRow(ts27);
		
		Object [] ts28 = {"CADENA","PUNTERO_MEMORIA"};
		ts.addRow(ts28);
		Object [] ts29 = {"NUMERO","ENTERO"};
		ts.addRow(ts29);

	}
	
	
	
	
	public boolean buscarTS(String id) {
		
		return ts.findColumn(id) != -1;
	}

	public void insertTS(Object[] id) {
		ts.addRow(id);
	}

}
