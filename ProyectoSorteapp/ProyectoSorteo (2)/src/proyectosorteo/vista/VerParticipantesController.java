/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectosorteo.vista;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import proyectosorteo.ProyectoSorteo;
import proyectosorteo.modelo.Participante;

/**
 * FXML Controller class
 *
 * @author aljavibu
 */
public class VerParticipantesController implements Initializable {

    private ProyectoSorteo ProgramaPrincipal;

    //Tableview
    @FXML
    public TableView tablaPartipantes;

    ArrayList<Participante> listaParticipantes;
    ObservableList<Participante> listaTabla;

    //TableColumn
    @FXML
    public TableColumn<Participante, String> columnaNombre;
    @FXML
    public TableColumn<Participante, String> columnaEmail;
    @FXML
    public TableColumn<Participante, String> columnaTelefono;
    @FXML
    public TableColumn<Participante, String> columnaDni;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    private void handleAnadir(ActionEvent event) throws IOException {
        ProgramaPrincipal.anadir();
        //Cada vez que anadimos a un nuevo participante llamamos a actualizar tabla para que se muestren los datos en el tableview
        actualizarTabla();
    }

    public void setSorteo(ProyectoSorteo ProgramaPrincipal) {
        this.ProgramaPrincipal = ProgramaPrincipal;

    }

    //Metodo que recibe al arraylist de la clase principal
    public void setParticipantes(ArrayList<Participante> listaParticipantesRecibida) {

        this.listaParticipantes = listaParticipantesRecibida;
        //Llamamos a actualizar tabla para que se muestren los datos en el tableview
        actualizarTabla();
    }

    @FXML
    public void salir() {
        System.exit(0);
    }

    public void actualizarTabla() {
        //Convertimos el array a observable
        listaTabla = FXCollections.observableArrayList(listaParticipantes);
        //Anadimoss los items a la tableView
        tablaPartipantes.setItems(listaTabla);

        //En cada columna ponemos los datos correspondientes
        columnaNombre.setCellValueFactory(cellData -> cellData.getValue().getPropertyNombre());
        columnaDni.setCellValueFactory(cellData -> cellData.getValue().getPropertyDni());
        columnaEmail.setCellValueFactory(cellData -> cellData.getValue().getPropertyEmail());
        columnaTelefono.setCellValueFactory(cellData -> cellData.getValue().getPropertyNumeroTelefono());

    }

    @FXML //Metodo que obtiene al participante seleccionado y lo borra del tableview y de la lista de participantes
    private void handleDelete() {
        int participanteSeleccionado = tablaPartipantes.getSelectionModel().getSelectedIndex();
        if(participanteSeleccionado>=0){
             tablaPartipantes.getItems().remove(participanteSeleccionado);
                listaParticipantes.remove(participanteSeleccionado);
        }
       
    }

}
