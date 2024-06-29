package main;

import java.time.LocalDate;

public class Reserva {
    private Sala sala;
    private Usuario usuario;
    private LocalDate fecha;
    private String detalleReserva;

    public Reserva(Sala sala, Usuario usuario, LocalDate fecha, String detalleReserva) {
        this.sala = sala;
        this.usuario = usuario;
        this.fecha = fecha;
        this.detalleReserva = detalleReserva;
    }

    // Getters y setters
    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getDetalleReserva() {
        return detalleReserva;
    }

    public void setDetalleReserva(String detalleReserva) {
        this.detalleReserva = detalleReserva;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "sala=" + sala +
                ", usuario=" + usuario +
                ", fecha=" + fecha +
                ", detalleReserva='" + detalleReserva + '\'' +
                '}';
    }
}
