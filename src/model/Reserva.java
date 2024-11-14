package model;

import model.Estados.Confirmado;
import model.Estados.Solicitado;
import model.Observador.Observador;
import java.util.ArrayList;
import java.util.List;

public class Reserva {
    private int id;
    private Usuario usuario;
    private EstadoReserva estado;
    private String sala;
    private List<Observador> observadores = new ArrayList<>();

    public Reserva(int id, Usuario usuario, String sala) {
        this.id = id;
        this.usuario = usuario;
        this.sala = sala;
        this.estado = new Solicitado(this);
    }

    public void cancelar() {
        try {
            if (estado instanceof Solicitado || estado instanceof Confirmado) {
                estado.cancelar();
                notificarObservadores("Reserva cancelada.");
            } else {
                System.out.println("Não é possível cancelar neste estado.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao cancelar reserva: " + e.getMessage());
        }
    }

    public void proximoEstado() {
        try {
            estado.proximoEstado();
            notificarObservadores("Estado alterado para: " + estado.getClass().getSimpleName());
        } catch (Exception e) {
            System.out.println("Erro ao avançar estado: " + e.getMessage());
        }
    }

    public void alterarEstado(EstadoReserva novoEstado) {
        try {
            this.estado = novoEstado;
        } catch (Exception e) {
            System.out.println("Erro ao alterar estado: " + e.getMessage());
        }
    }

    public void adicionarObservador(Observador observador) {
        try {
            observadores.add(observador);
        } catch (Exception e) {
            System.out.println("Erro ao adicionar observador: " + e.getMessage());
        }
    }

    public void removerObservador(Observador observador) {
        try {
            observadores.remove(observador);
        } catch (Exception e) {
            System.out.println("Erro ao remover observador: " + e.getMessage());
        }
    }

    public void notificarObservadores(String mensagem) {
        for (Observador observador : observadores) {
            try {
                observador.atualizar(mensagem);
            } catch (Exception e) {
                System.out.println("Erro ao notificar observador: " + e.getMessage());
            }
        }
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public String getSala() {
        return sala;
    }

    public String getEstado() {
        return estado.getClass().getSimpleName();
    }
}
