package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<Sala> salas = new ArrayList<>();
    private static List<Usuario> usuarios = new ArrayList<>();
    private static List<Reserva> reservas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada
            switch (opcion) {
                case 1:
                    gestionarSalas();
                    break;
                case 2:
                    gestionarUsuarios();
                    break;
                case 3:
                    gestionarReservas();
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Menú Principal ---");
        System.out.println("1. Gestión de Salas");
        System.out.println("2. Gestión de Usuarios");
        System.out.println("3. Gestión de Reservas");
        System.out.println("4. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void gestionarSalas() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- Gestión de Salas ---");
            System.out.println("1. Mostrar todas las salas");
            System.out.println("2. Agregar nueva sala");
            System.out.println("3. Actualizar sala");
            System.out.println("4. Eliminar sala");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada
            switch (opcion) {
                case 1:
                    mostrarSalas();
                    break;
                case 2:
                    agregarSala();
                    break;
                case 3:
                    actualizarSala();
                    break;
                case 4:
                    eliminarSala();
                    break;
                case 5:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }

    private static void mostrarSalas() {
        System.out.println("\n--- Lista de Salas ---");
        for (Sala sala : salas) {
            System.out.println(sala);
        }
    }

    private static void agregarSala() {
        System.out.println("\n--- Agregar Nueva Sala ---");
        System.out.print("Ingrese código de la sala: ");
        String codigo = scanner.nextLine();
        System.out.print("Ingrese nombre de la sala: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese ubicación de la sala: ");
        String ubicacion = scanner.nextLine();
        Sala nuevaSala = new Sala(codigo, nombre, ubicacion);
        salas.add(nuevaSala);
        System.out.println("Sala agregada correctamente.");
    }

    private static void actualizarSala() {
        System.out.println("\n--- Actualizar Sala ---");
        System.out.print("Ingrese código de la sala a actualizar: ");
        String codigo = scanner.nextLine();
        Sala salaEncontrada = buscarSalaPorCodigo(codigo);
        if (salaEncontrada != null) {
            System.out.print("Ingrese nuevo nombre de la sala: ");
            String nuevoNombre = scanner.nextLine();
            System.out.print("Ingrese nueva ubicación de la sala: ");
            String nuevaUbicacion = scanner.nextLine();
            salaEncontrada.setNombre(nuevoNombre);
            salaEncontrada.setUbicacion(nuevaUbicacion);
            System.out.println("Sala actualizada correctamente.");
        } else {
            System.out.println("No se encontró ninguna sala con ese código.");
        }
    }

    private static void eliminarSala() {
        System.out.println("\n--- Eliminar Sala ---");
        System.out.print("Ingrese código de la sala a eliminar: ");
        String codigo = scanner.nextLine();
        Sala salaEncontrada = buscarSalaPorCodigo(codigo);
        if (salaEncontrada != null) {
            salas.remove(salaEncontrada);
            System.out.println("Sala eliminada correctamente.");
        } else {
            System.out.println("No se encontró ninguna sala con ese código.");
        }
    }

    private static Sala buscarSalaPorCodigo(String codigo) {
        for (Sala sala : salas) {
            if (sala.getCodigo().equals(codigo)) {
                return sala;
            }
        }
        return null;
    }

    private static void gestionarUsuarios() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- Gestión de Usuarios ---");
            System.out.println("1. Mostrar todos los usuarios");
            System.out.println("2. Agregar nuevo usuario");
            System.out.println("3. Actualizar usuario");
            System.out.println("4. Eliminar usuario");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada
            switch (opcion) {
                case 1:
                    mostrarUsuarios();
                    break;
                case 2:
                    agregarUsuario();
                    break;
                case 3:
                    actualizarUsuario();
                    break;
                case 4:
                    eliminarUsuario();
                    break;
                case 5:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }

    private static void mostrarUsuarios() {
        System.out.println("\n--- Lista de Usuarios ---");
        for (Usuario usuario : usuarios) {
            System.out.println(usuario);
        }
    }

    private static void agregarUsuario() {
        System.out.println("\n--- Agregar Nuevo Usuario ---");
        System.out.print("Ingrese identificador del usuario: ");
        String identificador = scanner.nextLine();
        System.out.print("Ingrese nombre del usuario: ");
        String nombre = scanner.nextLine();
        System.out.print("Ingrese departamento del usuario: ");
        String departamento = scanner.nextLine();
        System.out.print("Ingrese descripción del usuario: ");
        String descripcion = scanner.nextLine();
        Usuario nuevoUsuario = new Usuario(identificador, nombre, departamento, descripcion);
        usuarios.add(nuevoUsuario);
        System.out.println("Usuario agregado correctamente.");
    }

    private static void actualizarUsuario() {
        System.out.println("\n--- Actualizar Usuario ---");
        System.out.print("Ingrese identificador del usuario a actualizar: ");
        String identificador = scanner.nextLine();
        Usuario usuarioEncontrado = buscarUsuarioPorIdentificador(identificador);
        if (usuarioEncontrado != null) {
            System.out.print("Ingrese nuevo nombre del usuario: ");
            String nuevoNombre = scanner.nextLine();
            System.out.print("Ingrese nuevo departamento del usuario: ");
            String nuevoDepartamento = scanner.nextLine();
            System.out.print("Ingrese nueva descripción del usuario: ");
            String nuevaDescripcion = scanner.nextLine();
            usuarioEncontrado.setNombre(nuevoNombre);
            usuarioEncontrado.setDepartamento(nuevoDepartamento);
            usuarioEncontrado.setDescripcion(nuevaDescripcion);
            System.out.println("Usuario actualizado correctamente.");
        } else {
            System.out.println("No se encontró ningún usuario con ese identificador.");
        }
    }

    private static void eliminarUsuario() {
        System.out.println("\n--- Eliminar Usuario ---");
        System.out.print("Ingrese identificador del usuario a eliminar: ");
        String identificador = scanner.nextLine();
        Usuario usuarioEncontrado = buscarUsuarioPorIdentificador(identificador);
        if (usuarioEncontrado != null) {
            usuarios.remove(usuarioEncontrado);
            System.out.println("Usuario eliminado correctamente.");
        } else {
            System.out.println("No se encontró ningún usuario con ese identificador.");
        }
    }

    private static Usuario buscarUsuarioPorIdentificador(String identificador) {
        for (Usuario usuario : usuarios) {
            if (usuario.getIdentificador().equals(identificador)) {
                return usuario;
            }
        }
        return null;
    }

    private static void gestionarReservas() {
        boolean volver = false;
        while (!volver) {
            System.out.println("\n--- Gestión de Reservas ---");
            System.out.println("1. Mostrar todas las reservas");
            System.out.println("2. Crear nueva reserva");
            System.out.println("3. Actualizar reserva");
            System.out.println("4. Eliminar reserva");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada
            switch (opcion) {
                case 1:
                    mostrarReservas();
                    break;
                case 2:
                    crearReserva();
                    break;
                case 3:
                    actualizarReserva();
                    break;
                case 4:
                    eliminarReserva();
                    break;
                case 5:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
                    break;
            }
        }
    }

    private static void mostrarReservas() {
        System.out.println("\n--- Lista de Reservas ---");
        for (Reserva reserva : reservas) {
            System.out.println(reserva);
        }
    }

    private static void crearReserva() {
        System.out.println("\n--- Crear Nueva Reserva ---");
        System.out.print("Ingrese código de la sala a reservar: ");
        String codigoSala = scanner.nextLine();
        Sala salaReserva = buscarSalaPorCodigo(codigoSala);
        if (salaReserva == null) {
            System.out.println("No se encontró ninguna sala con ese código.");
            return;
        }
        if (salaReserva.isReservada()) {
            System.out.println("La sala ya está reservada.");
            return;
        }
        System.out.print("Ingrese identificador del usuario que reserva: ");
        String identificadorUsuario = scanner.nextLine();
        Usuario usuarioReserva = buscarUsuarioPorIdentificador(identificadorUsuario);
        if (usuarioReserva == null) {
            System.out.println("No se encontró ningún usuario con ese identificador.");
            return;
        }
        System.out.print("Ingrese fecha de la reserva (YYYY-MM-DD): ");
        String fechaString = scanner.nextLine();
        LocalDate fecha;
        try {
            fecha = LocalDate.parse(fechaString);
        } catch (Exception e) {
            System.out.println("Formato de fecha incorrecto. Use el formato YYYY-MM-DD.");
            return;
        }
        System.out.print("Ingrese detalle de la reserva: ");
        String detalleReserva = scanner.nextLine();
        Reserva nuevaReserva = new Reserva(salaReserva, usuarioReserva, fecha, detalleReserva);
        reservas.add(nuevaReserva);
        salaReserva.setReservada(true);
        System.out.println("Reserva creada correctamente.");
    }

    private static void actualizarReserva() {
        System.out.println("\n--- Actualizar Reserva ---");
        System.out.print("Ingrese código de la sala de la reserva a actualizar: ");
        String codigoSala = scanner.nextLine();
        Sala salaReserva = buscarSalaPorCodigo(codigoSala);
        if (salaReserva == null) {
            System.out.println("No se encontró ninguna sala con ese código.");
            return;
        }
        if (!salaReserva.isReservada()) {
            System.out.println("La sala no está reservada actualmente.");
            return;
        }
        System.out.print("Ingrese identificador del usuario de la reserva a actualizar: ");
        String identificadorUsuario = scanner.nextLine();
        Usuario usuarioReserva = buscarUsuarioPorIdentificador(identificadorUsuario);
        if (usuarioReserva == null) {
            System.out.println("No se encontró ningún usuario con ese identificador.");
            return;
        }
        boolean reservaEncontrada = false;
        for (Reserva reserva : reservas) {
            if (reserva.getSala().getCodigo().equals(codigoSala) &&
                    reserva.getUsuario().getIdentificador().equals(identificadorUsuario)) {
                System.out.print("Ingrese nueva fecha de la reserva (YYYY-MM-DD): ");
                String fechaString = scanner.nextLine();
                LocalDate nuevaFecha;
                try {
                    nuevaFecha = LocalDate.parse(fechaString);
                } catch (Exception e) {
                    System.out.println("Formato de fecha incorrecto. Use el formato YYYY-MM-DD.");
                    return;
                }
                System.out.print("Ingrese nuevo detalle de la reserva: ");
                String nuevoDetalle = scanner.nextLine();
                reserva.setFecha(nuevaFecha);
                reserva.setDetalleReserva(nuevoDetalle);
                reservaEncontrada = true;
                System.out.println("Reserva actualizada correctamente.");
                break;
            }
        }
        if (!reservaEncontrada) {
            System.out.println("No se encontró ninguna reserva con esos datos.");
        }
    }

    private static void eliminarReserva() {
        System.out.println("\n--- Eliminar Reserva ---");
        System.out.print("Ingrese código de la sala de la reserva a eliminar: ");
        String codigoSala = scanner.nextLine();
        Sala salaReserva = buscarSalaPorCodigo(codigoSala);
        if (salaReserva == null) {
            System.out.println("No se encontró ninguna sala con ese código.");
            return;
        }
        System.out.print("Ingrese identificador del usuario de la reserva a eliminar: ");
        String identificadorUsuario = scanner.nextLine();
        Usuario usuarioReserva = buscarUsuarioPorIdentificador(identificadorUsuario);
        if (usuarioReserva == null) {
            System.out.println("No se encontró ningún usuario con ese identificador.");
            return;
        }
        boolean reservaEncontrada = false;
        for (Reserva reserva : reservas) {
            if (reserva.getSala().getCodigo().equals(codigoSala) &&
                    reserva.getUsuario().getIdentificador().equals(identificadorUsuario)) {
                reservas.remove(reserva);
                salaReserva.setReservada(false);
                reservaEncontrada = true;
                System.out.println("Reserva eliminada correctamente.");
                break;
            }
        }
        if (!reservaEncontrada) {
            System.out.println("No se encontró ninguna reserva con esos datos.");
        }
    }
}

