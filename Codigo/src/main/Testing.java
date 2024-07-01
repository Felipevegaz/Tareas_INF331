package main;
import org.junit.jupiter.api.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Testing {
    private static List<Sala> salas;
    private static List<Usuario> usuarios;
    private static List<Reserva> reservas;
    private static final InputStream originalSystemIn = System.in;
    private static ByteArrayInputStream simulatedInput;

    @BeforeAll
    public static void setUpStreams() {
        // Configuración inicial
        salas = new ArrayList<>();
        usuarios = new ArrayList<>();
        reservas = new ArrayList<>();
    }

    @BeforeEach
    public void setUp() {
        // Preparar para la prueba
        Main.salas.clear(); // Limpiar salas antes de cada prueba
        Main.usuarios.clear();
    }

    @Test
    public void testAgregarSala() {
        System.out.print("Se inicia testing de adicion de salas.\n");
        // Ejecutar método que agrega una sala
        Main.agregarSala("003","Sala C","Edificio C");


        // Verificar que la sala se agregó correctamente
        assertEquals(1, Main.salas.size(), "No se agregó la sala correctamente.");
        assertEquals("003", Main.salas.get(0).getCodigo(), "El código de la sala no coincide.");
        assertEquals("Sala C", Main.salas.get(0).getNombre(), "El nombre de la sala no coincide.");
        assertEquals("Edificio C", Main.salas.get(0).getUbicacion(), "La ubicación de la sala no coincide.");
        //assertTrue(outputStream.toString().contains("Sala agregada correctamente."),
                //"El mensaje de confirmación no se mostró correctamente.")
        System.out.print("Se finaliza testing de adicion de salas con exito.\n");
    }
    @Test
    public void testActualizarSala() {
        System.out.print("Se inicia testing de actualizacion de salas.\n");
        Main.agregarSala("002", "Sala B", "Edificio B");
        Main.actualizarSala("002", "Nueva Sala B", "Nuevo Edificio B");
        assertEquals("Nueva Sala B", Main.salas.get(0).getNombre(), "No se actualizó el nombre de la sala correctamente.");
        assertEquals("Nuevo Edificio B", Main.salas.get(0).getUbicacion(), "No se actualizó la ubicación de la sala correctamente.");
        System.out.print("Se finaliza testing de actualizacion de salas con exito.\n");
    }
    @Test
    public void testEliminarSala() {
        System.out.print("Se inicia testing de eliminacion de salas.\n");
        Main.agregarSala("003", "Sala C", "Edificio C");
        Main.eliminarSala("003");
        assertEquals(0, Main.salas.size(), "No se eliminó la sala correctamente.");
        System.out.print("Se finaliza testing de eliminacion de salas con exito.\n");
    }
    //Test relacionados a los usuarios
    @Test
    public void testCrearUsuario() {
        System.out.print("Se inicia testing de creacion de usuarios.\n");
        Main.agregarUsuario("001", "Juan", "Ventas", "Usuario de ventas");
        assertEquals(1, Main.usuarios.size(), "No se creó el usuario correctamente.");
        System.out.print("Se finaliza testing de creacion de usuarios con exito.\n");
    }

    @Test
    public void testActualizarUsuario() {
        System.out.print("Se inicia testing de actualizacion de usuarios.\n");
        Main.agregarUsuario("002", "María", "Recursos Humanos", "Usuario de RRHH");
        Main.actualizarUsuario("002", "María Rodríguez", "Recursos Humanos", "Usuario senior de RRHH");
        assertEquals("María Rodríguez", Main.usuarios.get(0).getNombre(), "No se actualizó el nombre del usuario correctamente.");
        assertEquals("Usuario senior de RRHH", Main.usuarios.get(0).getDescripcion(), "No se actualizó la descripción del usuario correctamente.");
        System.out.print("Se finaliza testing de actualizacion de usuarios con exito.\n");
    }

    @Test
    public void testEliminarUsuario() {
        System.out.print("Se inicia testing de eliminacion   de usuarios.\n");
        Main.agregarUsuario("003", "Pedro", "Tecnología", "Usuario de IT");
        Main.eliminarUsuario("003");
        assertEquals(0, Main.usuarios.size(), "No se eliminó el usuario correctamente.");
        System.out.print("Se finaliza testing de eliminacion de usuarios con exito.\n");
    }

    @Test
    public void testCrearReserva() {
        Main.crearReserva("001", "001", "2024-06-30", "Reserva de prueba");
        assertEquals(1, Main.reservas.size(), "No se creó la reserva correctamente.");
    }

    @Test
    public void testActualizarReserva() {
        Main.crearReserva("002", "002", "2024-07-01", "Reserva de prueba");
        Main.actualizarReserva("002", "003", "2024-07-02", "Nueva descripción");
        assertEquals("003", Main.reservas.get(0).getSala(), "No se actualizó la sala de la reserva correctamente.");
        assertEquals("2024-07-02", Main.reservas.get(0).getFecha(), "No se actualizó la fecha de la reserva correctamente.");
    }

    @AfterAll

    public static void restoreStreams() {
        // Restaurar entrada estándar original
        System.setIn(originalSystemIn);
    }
}

