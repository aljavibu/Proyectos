/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectosorteo.vista;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import proyectosorteo.ProyectoSorteo;
import proyectosorteo.modelo.Participante;

/**
 * FXML Controller class
 *
 * @author aljavibu
 */
public class AñadirParticipanteController implements Initializable {

    //Componentes
    @FXML
    public Button guardar;
    @FXML
    public TextField nombre;
    @FXML
    public TextField dni;
    @FXML
    public TextField numeroTel;
    @FXML
    public TextField email;
    @FXML 
    public MenuItem menuItemSalir;

    //clase 
    ProyectoSorteo main;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    //Metodo que controla los datos introducidos 
    public void handleGuardar(ActionEvent event) throws IOException {
        boolean datoCorrecto = true;
        boolean todoCorrecto = true;
        boolean participanteCreado = false;
        //Nombre

        String nombreIntroducido = nombre.getText();

        //Verificamos si el dato introducido es correcto
        datoCorrecto = ValidarNombre(nombre.getText());
        if (datoCorrecto == false) {
            //En caso contrario mostramos la alerta
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText("No has introducido el Nombre");
            alerta.setContentText(null);
            alerta.showAndWait();
            todoCorrecto = false;

        }
        //Dni
        String dniIntroducido = dni.getText();

        //Verificamos si el dato introducido es correcto
        datoCorrecto = validarDNI(dni.getText());
        if (datoCorrecto == false) {
            //En caso contrario mostramos la alerta
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText("No has introducido el DNI");
            alerta.setContentText(null);
            alerta.showAndWait();
            todoCorrecto = false;

        }

        // El email a validar
        String emailIntroducido = email.getText();
        //Verificamos si el dato introducido es correcto
        datoCorrecto = ValidarMail(email.getText());

        if (datoCorrecto == false) {
            //En caso contrario mostramos la alerta
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText("No es correcto el formato del email");
            alerta.setContentText(null);
            alerta.showAndWait();
            todoCorrecto = false;
        }

        //Numero telefono
        int telefonoIntroducido = 0;
        //Verificamos si el dato introducido es correcto
        datoCorrecto = ValidarTelefono(numeroTel.getText());

        if (datoCorrecto) {
            telefonoIntroducido = Integer.parseInt(numeroTel.getText());
        } else {
            //En caso contrario mostramos la alerta
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("Error");
            alerta.setHeaderText("No es correcto el formato del movil");
            alerta.setContentText(null);
            alerta.showAndWait();
            todoCorrecto = false;
        }

        //Si ningun dato ha resultado erroneo,procedemos a la creacion del participante
        if (todoCorrecto) {
            //Creamos particpante   
            Participante participanteNuevo = new Participante(nombreIntroducido, telefonoIntroducido, emailIntroducido, dniIntroducido);
            //Anadimos el participante al array
            main.addParticipantes(participanteNuevo);

            //Notificamos creacion exitosa
            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
            alerta.setTitle("Participante creado");
            alerta.setHeaderText("Participante creado exitosamente");
            alerta.setContentText(null);
            alerta.showAndWait();
            participanteCreado = true;

        }

        //Cierra la ventana solo si se ha creado
        if (participanteCreado) {
            Stage stage = (Stage) guardar.getScene().getWindow();
            stage.close();
        }

    }

    //Metodo que valida que no se ha introducido un nombre vacio
    public boolean ValidarNombre(String nombre) {
        if (nombre.length() <= 0) {
            return false;
        }
        return true;
    }

    //Metodo que valida mediante un patron a un dni
    public boolean validarDNI(String dni) {

        Pattern pattern = Pattern.compile("^\\d{8}[a-zA-Z]{1}$");

        Matcher mather = pattern.matcher(dni);
        if (mather.find() != true) {
            return false;
        }
        return true;
    }

    //Metodo que valida mediante un patron un telefono
    public boolean ValidarTelefono(String telefono) {

        Pattern pattern = Pattern.compile("^(0034|\\+34)?(\\d\\d\\d)-? ?(\\d\\d)-? ?(\\d)-? ?(\\d)-? ?(\\d\\d)$");

        Matcher mather = pattern.matcher(telefono);
        if (mather.find() != true) {
            return false;
        }
        return true;
    }

    //Metodo que valida mediante un patron a un correo Electronico
    public boolean ValidarMail(String mail) {
        // Patrón para validar el email
        Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        Matcher mather = pattern.matcher(mail);
        if (mather.find() != true) {
            return false;
        }
        return true;
    }

    public void setMainApp(ProyectoSorteo main) {
        this.main = main;
    }

    @FXML    //Metodo que abre un textArea explicando en que consiste la ventana
    private void handleayuda(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ProyectoSorteo.class.getResource("vista/Ayuda.fxml"));

        //Aqui ponemos el pane principal de la ventana
        BorderPane page = (BorderPane) loader.load();

        //Aquí utilizamos el controlador de la ventana principal       
        AyudaController controlador = loader.getController();
        //Explicamos en que consiste la ventana
        controlador.setText("Para añadir un participante \ndeberás completar todos los campos correctamente"
                + "\n(en caso contrario se indicará)");

        Scene scene = new Scene(page);
        Stage stage = new Stage();
        stage.setTitle("Ayuda");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    @FXML
    public void salir() {
        Stage stage = (Stage) this.guardar.getScene().getWindow();
        stage.close();
    }

}
