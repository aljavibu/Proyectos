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
public class TestParametrizadoEmail {

    private String mail;
    //private double cant;
    private boolean result;

    public TestParametrizadoEmail(String mail, boolean result) {
        this.mail = mail;
        //this.cant = cant;
        this.result = result;

    }

    // método que devuelve la lista de valores a probar
    @Parameters
    public static Collection<Object[]> numeros() {
        return Arrays.asList(new Object[][]{{"javi@gmail.com", true}, {/*Deberia devolver false ,pero asi comprobamos que funciona la prueba*/"jmail.com", true},
        {"javi@gmail", false}, {"javi123@gmail.com", true},{"javi123@gmail.es", true/*El .es no entra en el patron*/},
        {"ja_vi@gmail.com", false},{"javi@geps,com", false}});
    }

    /**
     * Test of extrae method, of class Cuenta.
     */
    @Test
    public void testExtrae() {

        AñadirParticipanteController instance = new AñadirParticipanteController();
        boolean resultado = instance.ValidarMail(mail);

        assertEquals(resultado, result);
    }

}
