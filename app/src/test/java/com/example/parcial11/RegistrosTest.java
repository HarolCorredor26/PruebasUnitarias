package com.example.parcial11;

import static org.junit.Assert.*;

import android.widget.EditText;

import org.junit.Before;
import org.junit.Test;

public class RegistrosTest {

    private Registros registros;

    @Before
    public void setUp() {
        registros = new Registros();
        // Asumimos que DB es una clase que maneja la base de datos
        // Aquí podemos configurar la clase DB si es necesario
    }
    @Test
    public void onClick() {
        // Arrange
        String name = "Juan";
        String contact = "juan@example.com";
        String dob = "1990-01-01";
        // Act
        boolean result = registros.DB.insertuserdata(name, contact, dob);
        // Assert
        assertTrue(result);
    }
    @Test
    public void onClick_showsErrorToastIfRegistrationFails() {
        // Arrange
        String name = "";
        String contact = "juan@example.com";
        String dob = "1990-01-01";
        // Act
        boolean result = registros.DB.insertuserdata(name, contact, dob);
        // Assert
        assertFalse(result);
    }


}