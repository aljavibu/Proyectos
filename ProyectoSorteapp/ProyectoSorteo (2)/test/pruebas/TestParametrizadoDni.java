/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import static org.junit.Assert.*;
import proyectosorteo.vista.AñadirParticipanteController;

/**
 *
 * @author saorin
 */
// Etiqueta para indicar que la clae va a ser usada para realizar una batería de pruebas.
@RunWith(Parameterized.class)
public class TestParametrizadoDni {

    private String dni;
    //private double cant;
    private boolean result;

    public TestParametrizadoDni(String dni, boolean result) {
        this.dni = dni;
        //this.cant = cant;
        this.result = result;

    }

    // método que devuelve la lista de valores a probar
    @Parameters
    public static Collection<Object[]> numeros() {
        return Arrays.asList(new Object[][]{{"20060911j", true}, {/*Deberia devolver false ,pero asi comprobamos que funciona la prueba*/"20060911", true},
        {"2006j", false},{"seiscincocinco", false},{"20060911", false},{"200609111213j", false}});
    }

    /**
     * Test of extrae method, of class Cuenta.
     */
    @Test
    public void testExtrae() {

        AñadirParticipanteController instance = new AñadirParticipanteController();
        boolean resultado = instance.validarDNI(dni);

        assertEquals(resultado, result);
    }

}
