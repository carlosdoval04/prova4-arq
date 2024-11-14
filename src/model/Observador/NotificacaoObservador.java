package model.Observador;

public class NotificacaoObservador implements Observador {
    @Override
    public void atualizar(String mensagem) {
        System.out.println("Notificação: " + mensagem);
    }
}
