package e19;

public class Sintaxis {
    private TDAPila<Character> pila = new TDAPila<>();

    public boolean controlar (String cadena){
        for(int i=0; i < cadena.length(); i++) {
            if (cadena.charAt(i) == '{'){
                pila.push('{');
            }
            else if(cadena.charAt(i) == '}'){
                if(pila.esVacia()){return false;}
                pila.pop();
            }
        }
        return pila.esVacia();
    }
}
