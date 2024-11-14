package model.Estados;

import model.Reserva;
import model.EstadoReserva;

public class EmAndamento implements EstadoReserva {
    private Reserva reserva;

    public EmAndamento(Reserva reserva) {
        this.reserva = reserva;
    }

    @Override
    public void cancelar() {
        System.out.println("Não é possível cancelar uma reserva em andamento.");
    }

    @Override
    public void proximoEstado() {
        reserva.alterarEstado(new Finalizado(reserva));
    }
}
