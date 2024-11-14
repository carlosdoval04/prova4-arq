package controller;

import model.Facade.ReservaFacade;
import model.Reserva;
import model.Usuario;
import view.ReservaView;

public class ReservaController {
    private ReservaFacade facade;
    private ReservaView view;
    private Reserva reserva;

    public ReservaController(ReservaFacade facade, ReservaView view) {
        this.facade = facade;
        this.view = view;
    }

    public void realizarReserva(int id, Usuario usuario, String sala) {
        try {
            reserva = facade.criarReserva(id, usuario, sala);
            reserva.adicionarObservador(usuario);
            view.exibirReserva(reserva);
        } catch (Exception e) {
            view.exibirMensagem("Erro ao realizar reserva: " + e.getMessage());
        }
    }

    public void cancelarReserva() {
        try {
            if (reserva != null) {
                facade.cancelarReserva(reserva);
                view.exibirMensagem("Reserva cancelada com sucesso.");
            } else {
                view.exibirMensagem("Nenhuma reserva para cancelar.");
            }
        } catch (Exception e) {
            view.exibirMensagem("Erro ao cancelar reserva: " + e.getMessage());
        }
    }

    public void avancarEstado() {
        try {
            if (reserva != null) {
                reserva.proximoEstado();
                view.exibirReserva(reserva);
            } else {
                view.exibirMensagem("Nenhuma reserva para avançar.");
            }
        } catch (Exception e) {
            view.exibirMensagem("Erro ao avançar estado da reserva: " + e.getMessage());
        }
    }

    public Reserva getReserva() {
        return reserva;
    }
}
