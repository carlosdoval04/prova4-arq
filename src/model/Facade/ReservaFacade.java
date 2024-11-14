package model.Facade;

import model.Reserva;
import model.Usuario;
import model.Observador.LogReservaObservador;
import model.Observador.NotificacaoObservador;

public class ReservaFacade {
    public Reserva criarReserva(int id, Usuario usuario, String sala) {
        Reserva reserva = new Reserva(id, usuario, sala);
        reserva.adicionarObservador(new LogReservaObservador());
        reserva.adicionarObservador(new NotificacaoObservador());
        return reserva;
    }

    public void cancelarReserva(Reserva reserva) {
        reserva.cancelar();
    }
}
