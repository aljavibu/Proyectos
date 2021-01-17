/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectosorteo.vista;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import proyectosorteo.ProyectoSorteo;

/**
 * FXML Controller class
 *
 * @author DAM-2
 */
public class AyudaController implements Initializable {
    ProyectoSorteo main;
    @FXML
    private TextArea textarea;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    //Metodo que actualiza el texto del textArea
  public void setText(String textoRecibido) {
       textarea.setText(textoRecibido);
       
    }

    public void setMain(ProyectoSorteo main) {
        this.main=main;
    }
}
