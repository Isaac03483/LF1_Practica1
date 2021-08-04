package com.mycompany.proyecto1_lf.swing;

public class Manejador {
    
    private Ventana ventana;

    public Manejador(Ventana ventana){
        this.ventana = ventana;
    }

    public java.util.ArrayList<String> convertirArray(){

        char[] cadena = this.ventana.getTextArea().getText().toCharArray();

        java.util.ArrayList<String> arreglo = new java.util.ArrayList<>();
        String palabra ="";
        for(int i = 0; i < cadena.length; i++){

            if(cadena[i] == ' '){
                arreglo.add(palabra.trim());
                palabra = "";
            } else {
                palabra +=cadena[i];
            }
        }

        return arreglo;
    }

    public void verificar(){

        this.ventana.getModelo().clear();
        java.util.ArrayList<String> arreglo = convertirArray();

        for(String palabra: arreglo){

            com.mycompany.proyecto1_lf.logica.Token token = identificar(palabra);
            this.ventana.getModelo().addElement(token.getInformacion());
        }
        this.ventana.getJList().setModel(this.ventana.getModelo());
    }

    public com.mycompany.proyecto1_lf.logica.Token identificar(String palabra){

        com.mycompany.proyecto1_lf.logica.Token token=null;

        if(primeraLetra(palabra.charAt(0))){
            if(esIdentificador(palabra)){
                token = new com.mycompany.proyecto1_lf.logica.Token(palabra, com.mycompany.proyecto1_lf.logica.Tipo.IDENTIFICADOR);

            } else if(esSimbolo(palabra)){
                token = new com.mycompany.proyecto1_lf.logica.Token(palabra, com.mycompany.proyecto1_lf.logica.Tipo.SIMBOLO);

            } else {
                token = new com.mycompany.proyecto1_lf.logica.Token(palabra, com.mycompany.proyecto1_lf.logica.Tipo.ERROR);
    
            }
        } else if (esEntero(palabra)){

            token = new com.mycompany.proyecto1_lf.logica.Token(palabra, com.mycompany.proyecto1_lf.logica.Tipo.NUMERO);

        } else if(esDecimal(palabra)){

            token = new com.mycompany.proyecto1_lf.logica.Token(palabra, com.mycompany.proyecto1_lf.logica.Tipo.DECIMAL);
        

        } else if (esSimbolo(palabra)){
            token = new com.mycompany.proyecto1_lf.logica.Token(palabra, com.mycompany.proyecto1_lf.logica.Tipo.SIMBOLO);

        } else {
            token = new com.mycompany.proyecto1_lf.logica.Token(palabra, com.mycompany.proyecto1_lf.logica.Tipo.ERROR);

        }
        return token;
    }

    public boolean primeraLetra(char letra){
        
        switch(Character.toUpperCase(letra)){
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
            case 'G':
            case 'H':
            case 'I':
            case 'J':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'Ñ':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
            return true;
        }
        return false;
    }

    public boolean esIdentificador(String palabra){

        for(int i = 0; i < palabra.length(); i++){
            switch(palabra.toUpperCase().charAt(i)){
                case 'A':
                case 'B':
                case 'C':
                case 'D':
                case 'E':
                case 'F':
                case 'G':
                case 'H':
                case 'I':
                case 'J':
                case 'K':
                case 'L':
                case 'M':
                case 'N':
                case 'Ñ':
                case 'O':
                case 'P':
                case 'Q':
                case 'R':
                case 'S':
                case 'T':
                case 'U':
                case 'V':
                case 'W':
                case 'X':
                case 'Y':
                case 'Z':
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                if(i == palabra.length()-1){
                    return true;
                } else {
                    continue;
                }
            }
            
        }
        return false;
    }

    public boolean esEntero(String palabra){

        for(int i = 0; i < palabra.length(); i++){
            switch(palabra.charAt(i)){
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                if(i == palabra.length()-1){
                    return true;
                } else {
                    continue;
                }
                default:
                return false;
            }
        }
        return false;
    }

    public boolean esDecimal(String palabra){

        for(int i = 0; i < palabra.length(); i++){
            switch(palabra.charAt(i)){
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case '.':
                if(i == palabra.length()-1){
                    return true;
                } else {
                    continue;
                }
                default:
                return false;
            }
        }
        return false;
    }

    public boolean esSimbolo(String palabra){
        for(int i = 0; i < palabra.length(); i++){
            switch(palabra.charAt(i)){
                case '[':
                case ']':
                case '{':
                case '}':
                case ',':
                case ';':   
                if(i == palabra.length()-1){
                    return true;
                } else {
                    continue;
                }
                default:
                return false;
            }
        }
        return false;
    }
}
