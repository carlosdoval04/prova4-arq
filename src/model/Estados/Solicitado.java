package model.Estados;

import model.Reserva;
import model.EstadoReserva;

public class Solicitado implements EstadoReserva {
    private Reserva reserva;

    public Solicitado(Reserva reserva) {
        this.reserva = reserva;
    }

    @Override
    public void cancelar() {
        System.out.println("Reserva cancelada no estado Solicitado.");
        reserva.alterarEstado(new Cancelado(reserva));
    }

    @Override
    public void proximoEstado() {
        reserva.alterarEstado(new Confirmado(reserva));
    }
}
