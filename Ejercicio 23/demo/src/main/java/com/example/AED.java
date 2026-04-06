package com.example;

public class AED extends ListaEnlazada<Sucursal>{
    
    public void listarSucursales(){
        if(this.primero != null){
            TDANodo<Sucursal> actual = this.primero;
            System.out.println("Nuestras sucursales son:");

            while(actual != null){
                System.out.println(actual.getDato().getLugar());
                actual = actual.siguiente;
            }
        }
    }

    public boolean nuevaSucursal (String nueva){
        Sucursal sucursal = new Sucursal(nueva);
        TDANodo<Sucursal> unaSucursal = new TDANodo<Sucursal>(sucursal);
        if (this.esVacio()){
            this.primero = unaSucursal;
            return true;
        }
        
        TDANodo<Sucursal> actual = this.primero;

        while (actual.getSiguiente()!=null){
            actual = actual.getSiguiente();
        }
        actual.setSiguiente(unaSucursal);
        return true;
    }

        public boolean eliminar(String lugar) {
            if (esVacio()) {
                return false;
            }

            if (primero.getDato().getLugar().equals(lugar)) {
                primero = primero.getSiguiente();
                return true;
            }

            TDANodo<Sucursal> actual = primero;

            while (actual.getSiguiente() != null) {
                if (actual.getSiguiente().getDato().getLugar().equals(lugar)) {
                    actual.setSiguiente(actual.getSiguiente().getSiguiente());
                    return true;
                }
                actual = actual.getSiguiente();
            }

            return false;
        }

    public void imprimir(String separador){
        if(this.primero == null){
        return;
        }
        
        String texto = this.primero.getDato().getLugar();
        TDANodo<Sucursal> actual = this.primero.siguiente;
        
        while(actual != null){
            texto = texto + separador + (actual.getDato().getLugar());
            actual = actual.siguiente;
        }

        System.out.println(texto);
}

    public AED(){

    }
}
