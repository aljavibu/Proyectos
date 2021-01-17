/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import proyectosorteo.vista.AñadirParticipanteController;

/**
 *
 * @author aljavibu
 */
public class TestValidaciones {
    
    public TestValidaciones() {
    }

 @Test
    public void testDni() {
        
        String dni = "20090390j";
        boolean resultado;
        AñadirParticipanteController instance =new AñadirParticipanteController();
       
        resultado=instance.validarDNI(dni);
      
        assertTrue("Correcto",resultado);
       
    }
    
     @Test
    public void testNombre() {
        
        String nombre = "Javi";
        boolean resultado;
        AñadirParticipanteController instance =new AñadirParticipanteController();
       
        resultado=instance.ValidarNombre(nombre);
      
        assertTrue("Correcto",resultado);
       
    }
    
    
         @Test
    public void testEmail() {
        
        String email = "javi@gmail.com";
        boolean resultado;
        AñadirParticipanteController instance =new AñadirParticipanteController();
       
        resultado=instance.ValidarMail(email);
      
        assertTrue("Correcto",resultado);
       
    }
    
         @Test
    public void testNumeroTelefono() {
        
        String telefono = "655000555";
        boolean resultado;
        AñadirParticipanteController instance =new AñadirParticipanteController();
       
        resultado=instance.ValidarTelefono(telefono);
      
        assertTrue("Correcto",resultado);
       
    }
    
    
}
