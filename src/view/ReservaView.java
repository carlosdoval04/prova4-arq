package view;

import controller.ReservaController;
import model.Reserva;
import model.Usuario;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ReservaView {
    private Scanner scanner = new Scanner(System.in);

    public void exibirMenuPrincipal(ReservaController controller) {
        int opcao;
        do {
            try {
                System.out.println("\nSistema de Reservas de Sala de Reunião");
                System.out.println("1. Realizar reserva");
                System.out.println("2. Cancelar reserva");
                System.out.println("3. Avançar estado da reserva");
                System.out.println("4. Exibir reserva atual");
                System.out.println("0. Sair");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine(); 

                switch (opcao) {
                    case 1:
                        realizarReserva(controller);
                        break;
                    case 2:
                        controller.cancelarReserva();
                        break;
                    case 3:
                        controller.avancarEstado();
                        break;
                    case 4:
                        exibirReserva(controller.getReserva());
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida! Por favor, insira um número.");
                scanner.nextLine();
                opcao = -1;
            } catch (Exception e) {
                System.out.println("Erro no menu principal: " + e.getMessage());
                opcao = -1;
            }
        } while (opcao != 0);
    }

    private void realizarReserva(ReservaController controller) {
        try {
            System.out.print("Digite o ID da reserva: ");
            int id = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Digite o nome do usuário: ");
            String nome = scanner.nextLine();
            System.out.print("Digite o nome da sala: ");
            String sala = scanner.nextLine();

            Usuario usuario = new Usuario(nome);
            controller.realizarReserva(id, usuario, sala);
        } catch (InputMismatchException e) {
            System.out.println("ID inválido! Por favor, insira um número inteiro.");
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Erro ao realizar reserva: " + e.getMessage());
        }
    }

    public void exibirReserva(Reserva reserva) {
        try {
            if (reserva != null) {
                System.out.println("Reserva ID: " + reserva.getEstado());
                System.out.println("Sala: " + reserva.getSala());
                System.out.println("Usuário: " + reserva.getUsuario().getNome());
                System.out.println("Estado: " + reserva.getEstado());
            } else {
                System.out.println("Nenhuma reserva realizada.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao exibir reserva: " + e.getMessage());
        }
    }

    public void exibirMensagem(String mensagem) {
        System.out.println(mensagem);
    }
}
