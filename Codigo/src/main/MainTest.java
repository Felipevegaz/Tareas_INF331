package main;
import org.junit.jupiter.api.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {
    private static List<Sala> salas;
    private static final InputStream originalSystemIn = System.in;
    private static ByteArrayInputStream simulatedInput;

    @BeforeAll
    public static void setUpStreams() {
        // Configuración inicial
        salas = new ArrayList<>();
    }

    @BeforeEach
    public void setUp() {
        // Preparar para la prueba
        salas.clear(); // Limpiar salas antes de cada prueba
    }

    @Test
    public void testAgregarSala() {

        // Ejecutar método que agrega una sala
        Main.agregarSala("003","Sala C","Edificio C");


        // Verificar que la sala se agregó correctamente
        assertEquals(1, Main.salas.size(), "No se agregó la sala correctamente.");
        assertEquals("003", Main.salas.get(0).getCodigo(), "El código de la sala no coincide.");
        assertEquals("Sala C", Main.salas.get(0).getNombre(), "El nombre de la sala no coincide.");
        assertEquals("Edificio C", Main.salas.get(0).getUbicacion(), "La ubicación de la sala no coincide.");
        //assertTrue(outputStream.toString().contains("Sala agregada correctamente."),
                //"El mensaje de confirmación no se mostró correctamente.");
    }

    @AfterAll
    public static void restoreStreams() {
        // Restaurar entrada estándar original
        System.setIn(originalSystemIn);
    }
}

