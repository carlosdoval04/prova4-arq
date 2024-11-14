package model;

import model.Observador.Observador;

public class Usuario implements Observador {
    private String nome;

    public Usuario(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public void atualizar(String mensagem) {
        System.out.println("Notificação para " + nome + ": " + mensagem);
    }
}
