package model.Observador;

public class LogReservaObservador implements Observador {
    @Override
    public void atualizar(String mensagem) {
        System.out.println("Log: " + mensagem);
    }
}
