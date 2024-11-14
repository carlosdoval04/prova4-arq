package model.Estados;

import model.Reserva;
import model.EstadoReserva;

public class Cancelado implements EstadoReserva {
    private Reserva reserva;

    public Cancelado(Reserva reserva) {
        this.reserva = reserva;
    }

    @Override
    public void cancelar() {
        System.out.println("A reserva já está cancelada.");
    }

    @Override
    public void proximoEstado() {
        System.out.println("A reserva foi cancelada e não pode avançar.");
    }
}
