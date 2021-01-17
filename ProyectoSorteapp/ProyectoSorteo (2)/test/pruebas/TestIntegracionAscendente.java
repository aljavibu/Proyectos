/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.io.IOException;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import proyectosorteo.ProyectoSorteo;
import proyectosorteo.modelo.Participante;
import proyectosorteo.vista.VentanaPrincipalController;


/**
 *
 * @author saorin
 */
public class TestIntegracionAscendente {
    private ProyectoSorteo Principal;
    private VentanaPrincipalController VentanaSortear;
    public TestIntegracionAscendente() {
    }
    //Solo puede haber un método con esta etiqueta. Se invoca una vez, al principio 
    //del lanzamiento de todas las pruebas.Se suele utilizar para inicializar atributos comunes a todas las pruebas
    // o para realizar acciones que tardan un tiempo considerable en ejecutarse
    @BeforeClass
    public static void setUpClass() {
    }
    //Solo puede haber un método con eta anotación. Este método será invocado una sola vez, cuando finalicen todas las
    //pruebas
    @AfterClass
    public static void tearDownClass() {
    }
    //Este método se ejecuta antes de cualquier método de prueba. Se utiliza, por ejemplo, para preparar la base de datos
    //inicilizar array...Puede haber varios métodos en la clase con la etiqueta @Before
    @Before
    public void setUp() {
        Principal=new ProyectoSorteo();
        VentanaSortear = new VentanaPrincipalController();
        
    }
    //Este método se ejecuta después de la ejecución de todos los métodos de prueba.Se puede utilizar para limpiar datos.
    //Puede haber varios métodos en la clase con la etiqueta @After
    @After
    public void tearDown() {
        Principal=null;
        VentanaSortear=null;
    }

    /**
     * Test of ingresa method, of class Cuenta.
     * @throws java.io.IOException
     */
    @Test
    public void testParticipante() throws IOException {
        ArrayList<Participante> lista; 
        
        //Primero creamos con la Clase participante uno nuevo
        Participante participanteNuevo=new Participante("juan", 600121212, "juan@gmail.com","27628918j");
        
        //Despues se lo aandimos a la clase principal
        Principal.addParticipantes(participanteNuevo);
        //Obtenemos esa lista 
        lista=Principal.listaParticipantes;
        //y se la pasamos a la clase VentanaPrincipalController que sera la encargada de sortear
        VentanaSortear.setListaParticipantes(lista);
        //Por ultimo obtenemos el valor del metodo sortear para ver si ha sido correcto
       boolean resultado=VentanaSortear.Sortear();
        
       
        assertTrue(resultado);

        
    
      
       
    }

}
