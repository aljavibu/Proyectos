/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectosorteo.vista;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import proyectosorteo.ProyectoSorteo;
import proyectosorteo.modelo.Participante;

/**
 *
 * @author aljavibu
 */
public class VentanaPrincipalController implements Initializable {

    //Componentes
    @FXML
    public Button editar;
    @FXML
    public Spinner<Integer> contadorGanadores;

    //Clases y variables
    private ProyectoSorteo ProgramaPrincipal;
    public ArrayList<Participante> listaParticipantes;
    int numeroGanadores;

    @FXML//Este metodo se encarga de seleccionar a los ganadores del sorteo
    public boolean Sortear() throws IOException {
        Random rand = new Random();
        boolean sorteoCorrecto = true;
        int posicionparticipanteGanador;
        //Obtenemos el numero de ganadores de este sorteo mediante el componente spinner
        numeroGanadores = contadorGanadores.getValue();

        //Si la lista de participantes no esta vacia
        if (listaParticipantes.size() > 0) {
            //Haremos un bucle de 0 al numero de ganadores
            for (int i = 0; i < numeroGanadores; i++) {
                //Obtenemos un int aleatorio que sera la posicion dentro del array del participante
                posicionparticipanteGanador = rand.nextInt(listaParticipantes.size());

                //Mostramos por pantalla los datos del ganador
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setTitle("Ganador!!");
                alerta.setHeaderText(listaParticipantes.get(posicionparticipanteGanador).toString());
                alerta.setContentText(null);
                alerta.showAndWait();
                //Si a  la lista le quedan mas de 1 participante
                if (listaParticipantes.size() > 1) {
                    //borramos al que ha  ganado
                    listaParticipantes.remove(posicionparticipanteGanador);
                } else {
                    //De lo contrario notificamos que ya han salido todos los participantes posibles
                    //Por lo que tocaria anadir nuevos participantes
                    Alert alerta2 = new Alert(Alert.AlertType.WARNING);
                    alerta2.setTitle("Informacion");
                    alerta2.setHeaderText("No quedan mas participantes por ganar");
                    alerta2.setContentText(null);
                    alerta2.showAndWait();
                    //Si no quedan salimos del bucle
                    break;
                }

            }
        } else {
            //Notificamos lista vacia
            Alert alerta = new Alert(Alert.AlertType.ERROR);
            alerta.setTitle("ERROR");
            alerta.setHeaderText("No hay participantes en la lista");
            alerta.setContentText(null);
            alerta.showAndWait();
            sorteoCorrecto = false;
        }

        return sorteoCorrecto;

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        //Inicializamos los valores del spinner min 1 ganador max 100
        contadorGanadores.setValueFactory(
                new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100));

    }

    public void setMain(ProyectoSorteo ProgramaPrincipal) {
        this.ProgramaPrincipal = ProgramaPrincipal;
    }

    //Metodo que obtiene el arrayList de la clase principal
    public void setListaParticipantes(ArrayList<Participante> listaParticipantes) {

        this.listaParticipantes = listaParticipantes;

    }

    @FXML
    private void handleVerParticipantes(ActionEvent event) throws IOException {

        ProgramaPrincipal.verParticipantes();
    }

    //Metodo que abre un textArea explicando en que consiste la ventana
    @FXML
    private void handleayuda(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ProyectoSorteo.class.getResource("vista/Ayuda.fxml"));

        //Aqui ponemos el pane principal de la ventana
        BorderPane page = (BorderPane) loader.load();

        //Aquí utilizamos el controlador de la ventana principal       
        AyudaController controlador = loader.getController();
        //Explicamos en que consiste la ventana
        controlador.setText("Clickando en el botón de sortear,\nobtendrás una ventana con los datos del participante ganador\n\n"
                + "El botón de numero de ganadores te permitará\n cambiar el número de ganadores de 1 a 100 posibles \n\n"
                + "El botón de ver Participantes te mostrará una tabla\n donde poder ver ,añadir o eliminar a los participantes");

        Scene scene = new Scene(page);
        Stage stage = new Stage();
        stage.setTitle("Ayuda");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);

        stage.show();
    }

    @FXML
    public void salir() {
        System.exit(0);
    }

}
