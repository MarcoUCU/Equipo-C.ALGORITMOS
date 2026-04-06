package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        AED aed = new AED();

        InputStream is = App.class.getResourceAsStream("/suc3.txt"); // Aca se cambias el nombre segun el archivo que deseemos leer
        BufferedReader br = new BufferedReader(new InputStreamReader(is));

        String linea;
            while ((linea = br.readLine()) != null){
                linea = linea.replace("\uFEFF", "").trim(); // El replace salio de chatgpt debido a un "BOM"
                aed.nuevaSucursal(linea);
            }

            br.close();

        // aed.eliminar("Chicago"); Utilizado para la parte 2
        
        // aed.eliminar("Shenzen"); Utilizado para la parte 3
        // aed.eliminar("Tokio"); 
        
        aed.imprimir(";");

        // aed.listarSucursales();
        // System.out.println(aed.tamano());
    }
}
