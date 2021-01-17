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
public class TestParametrizadoTelefono {

    private String telefono;
    //private double cant;
    private boolean result;

    public TestParametrizadoTelefono(String telefono, boolean result) {
        this.telefono = telefono;
        //this.cant = cant;
        this.result = result;

    }

    // método que devuelve la lista de valores a probar
    @Parameters
    public static Collection<Object[]> numeros() {
        return Arrays.asList(new Object[][]{{"+34655362929", true}, {/*Deberia devolver false ,pero asi comprobamos que funciona la prueba*/"123", true},
        {"655362929", true}, {"seiscincocinco", false},{"955335466", true},{"655292929j", false},{"65555555555555555", false}});
    }

    /**
     * Test of extrae method, of class Cuenta.
     */
    @Test
    public void testExtrae() {

        AñadirParticipanteController instance = new AñadirParticipanteController();
        boolean resultado = instance.ValidarTelefono(telefono);

        assertEquals(resultado, result);
    }

}
