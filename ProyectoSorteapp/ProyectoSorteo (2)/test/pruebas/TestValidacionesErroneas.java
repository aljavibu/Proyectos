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
public class TestValidacionesErroneas {
    
    public TestValidacionesErroneas() {
    }

 @Test
    public void testDni() {
        
        String dni = "0";
        boolean resultado;
        AñadirParticipanteController instance =new AñadirParticipanteController();
       
        resultado=instance.validarDNI(dni);
      
        assertFalse("La salida ha resultado false",resultado);
       
    }
    
     @Test
    public void testNombre() {
        
        String nombre = "";
        boolean resultado;
        AñadirParticipanteController instance =new AñadirParticipanteController();
       
        resultado=instance.ValidarNombre(nombre);
      
        assertFalse("La salida ha resultado false",resultado);
       
    }
    
    
         @Test
    public void testEmail() {
        
        String email = "javigmailcom";
        boolean resultado;
        AñadirParticipanteController instance =new AñadirParticipanteController();
       
        resultado=instance.ValidarMail(email);
      
        assertFalse("La salida ha resultado false",resultado);
       
    }
    
         @Test
    public void testNumeroTelefono() {
        
        String telefono = "1234";
        boolean resultado;
        AñadirParticipanteController instance =new AñadirParticipanteController();
       
        resultado=instance.ValidarTelefono(telefono);
      
        assertFalse("La salida ha resultado false",resultado);
       
    }
    
    
}
