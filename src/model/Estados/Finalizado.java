package model.Estados;

import model.Reserva;
import model.EstadoReserva;

public class Finalizado implements EstadoReserva {
    private Reserva reserva;

    public Finalizado(Reserva reserva) {
        this.reserva = reserva;
    }

    @Override
    public void cancelar() {
        System.out.println("Não é possível cancelar uma reserva finalizada.");
    }

    @Override
    public void proximoEstado() {
        System.out.println("A reserva já está finalizada.");
    }
}
