/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectosorteo.modelo;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author aljavibu
 */
public class Participante {

    private StringProperty nombre, email, dni, numeroTelefono;

    public Participante(String nombre, int numeroTelefono, String email, String dni) {
        this.nombre = new SimpleStringProperty(nombre);
        this.numeroTelefono = new SimpleStringProperty(String.valueOf(numeroTelefono));
        this.email = new SimpleStringProperty(email);
        this.dni = new SimpleStringProperty(dni);

    }

    public StringProperty getPropertyNombre() {
        return nombre;
    }

    public void setPropertyNombre(StringProperty nombre) {
        this.nombre = nombre;
    }

    public StringProperty getPropertyEmail() {
        return email;
    }

    public void setPropertyEmail(StringProperty email) {
        this.email = email;
    }

    public StringProperty getPropertyDni() {
        return dni;
    }

    public void setDni(StringProperty dni) {
        this.dni = dni;
    }

    public StringProperty getPropertyNumeroTelefono() {
        return numeroTelefono;
    }

    public String getNombre() {
        return nombre.get();
    }

    public void setNombre(String nombre) {
        this.nombre.set(nombre);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getDni() {
        return dni.get();
    }

    public void setDni(String dni) {
        this.dni.set(dni);
    }

    public String toString() {
        return "Participante " + nombre.getValue() + " \nDNI: " + dni.getValue() + " \n Email: " + email.getValue() + " \nNumero de Telefono " + numeroTelefono.getValue();
    }

}
