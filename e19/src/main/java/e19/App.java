package e19;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class App 
{
    public static void main( String[] args ) throws IOException
    {
        Sintaxis nuevaPila = new Sintaxis();
        System.out.println(nuevaPila.controlar("{}{}{}{}{}{}{}{}{{}}"));
        System.out.println(nuevaPila.controlar("{peñarol}}{peñarol}}aed{e}ef{{a}sfasf{}}"));
}
}
