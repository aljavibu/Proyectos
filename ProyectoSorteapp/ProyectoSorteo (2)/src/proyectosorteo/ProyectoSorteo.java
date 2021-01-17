/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectosorteo;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

import javafx.scene.Scene;
import javafx.scene.image.Image;

import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import proyectosorteo.modelo.Participante;
import proyectosorteo.vista.AñadirParticipanteController;

import proyectosorteo.vista.VentanaPrincipalController;
import proyectosorteo.vista.VerParticipantesController;

/**
 *
 * @author aljavibu
 */
public class ProyectoSorteo extends Application {

    public ArrayList<Participante> listaParticipantes = new ArrayList<Participante>();

    @Override
    public void start(Stage stage) throws Exception {
        //Anadimos un ejemplo de participante para mostrarselo al usuario de la app
        listaParticipantes.add(new Participante("Ejemplo", 600000000, "ejemplo@gmail.com", "00000000x"));

        //Abrimos la ventana principal
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ProyectoSorteo.class.getResource("vista/VentanaPrincipal.fxml"));

        //Aqui ponemos el pane principal de la ventana
        BorderPane page = (BorderPane) loader.load();

        //Aquí utilizamos el controlador de la ventana principal       
        VentanaPrincipalController controlador = loader.getController();

        controlador.setMain(this);

        controlador.setListaParticipantes(listaParticipantes);

        //Anadimos el icono de nuestra aplicacion
        stage.getIcons().add(new Image("proyectosorteo/sorteoIconoApp.png"));

        Scene scene = new Scene(page);
        stage.setTitle("SorteApp");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    //Metodo que abrira la ventana para ver a los participantes
    public void verParticipantes() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ProyectoSorteo.class.getResource("vista/VerParticipantes.fxml"));

        //Aqui ponemos el pane principal de la ventana
        BorderPane page = (BorderPane) loader.load();

        //Aquí utilizamos el controlador de la ventana principal       
        VerParticipantesController controlador = loader.getController();
        //Enlazamos el main con esta ventana para que pueda abrir secundarias
        controlador.setSorteo(this);
        //Pasamos nuestro arraylist de participantes a esta nueva ventana
        controlador.setParticipantes(listaParticipantes);

        Scene scene = new Scene(page);
        Stage stage = new Stage();
        stage.setTitle("Participantes");
        stage.setScene(scene);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setResizable(false);
        stage.show();

    }

//Metodo que abrira una ventana con la que podremos anadir participantes
    public void anadir() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(ProyectoSorteo.class.getResource("vista/AñadirParticipante.fxml"));

        //Aqui ponemos el pane principal de la ventana
        BorderPane page = (BorderPane) loader.load();

        //Aquí utilizamos el controlador de la ventana principal       
        AñadirParticipanteController controlador = loader.getController();

        controlador.setMainApp(this);

        Scene scene = new Scene(page);
        Stage stage = new Stage();
        stage.setTitle("Añadir participante");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.show();

    }

    //Metodo para anadir participantes a nuestra arrayList
    public void addParticipantes(Participante participanteRecibido) throws IOException {
        listaParticipantes.add(participanteRecibido);

    }

    @FXML //Metodod para cerrar la app
    public void salir() {
        System.exit(0);
    }

}
