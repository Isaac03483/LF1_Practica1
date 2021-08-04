package com.mycompany.proyecto1_lf.logica;

public enum Tipo {
    
    IDENTIFICADOR("Identificador"),
    NUMERO("Numero"),
    DECIMAL("Decimal"),
    SIMBOLO("Simbolo"),
    ERROR("Error");

    private String nombreTipo;

    private Tipo(String nombreTipo){
        this.nombreTipo = nombreTipo;
    }

    public String getNombre(){return this.nombreTipo;}
}
