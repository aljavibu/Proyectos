/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 *
 * @author profesor
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({pruebas.TestParametrizadoDni.class,pruebas.TestParametrizadoEmail.class,pruebas.TestParametrizadoTelefono.class,pruebas.TestValidaciones.class,pruebas.TestValidacionesErroneas.class})
public class TestSuite {
    
}
