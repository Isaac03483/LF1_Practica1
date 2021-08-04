package com.mycompany.proyecto1_lf.logica;

public class Token {
    
    private String dato;
    private Tipo tipoDato;

    public Token(String dato, Tipo tipoDato){
        this.dato = dato;
        this.tipoDato = tipoDato;

    }

    public String getInformacion(){return this.tipoDato+": "+this.dato;}
}
