package e19;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.Test;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AppTest {
    Sintaxis s;
    List<String> lineas;

    @Before
    public void setUp() throws IOException {
        s = new Sintaxis();
        lineas = new ArrayList<>();
        BufferedReader lector = new BufferedReader(
            new FileReader("C:\\Users\\joaac\\OneDrive\\Escritorio\\ucu\\algoritmos\\Equipo-C.ALGORITMOS\\e19\\corchetes.txt")
        );
        String linea;
        while ((linea = lector.readLine()) != null) {
            lineas.add(linea.trim());
        }
        lector.close();
    }

    @Test
    public void testBienFormada() {
        assertTrue(s.controlar(lineas.get(0)));
    }

    @Test
    public void testMalFormadaFaltaCierre() {
        assertFalse(s.controlar(lineas.get(1)));
    }

    @Test
    public void testBienFormadaAnidada() {
        assertTrue(s.controlar(lineas.get(2)));
    }

    @Test
    public void testMalFormadaCierreAntesDeApertura() {
        assertFalse(s.controlar(lineas.get(3)));
    }

    @Test
    public void testMalFormadaSoloAperturas() {
        assertFalse(s.controlar(lineas.get(4)));
    }
}