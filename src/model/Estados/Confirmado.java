package model.Estados;

import model.Reserva;
import model.EstadoReserva;

public class Confirmado implements EstadoReserva {
    private Reserva reserva;

    public Confirmado(Reserva reserva) {
        this.reserva = reserva;
    }

    @Override
    public void cancelar() {
        System.out.println("Reserva cancelada no estado Confirmado.");
        reserva.alterarEstado(new Cancelado(reserva));
    }

    @Override
    public void proximoEstado() {
        reserva.alterarEstado(new EmAndamento(reserva));
    }
}
