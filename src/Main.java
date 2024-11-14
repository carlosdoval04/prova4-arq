import controller.ReservaController;
import model.Facade.ReservaFacade;
import view.ReservaView;

public class Main {
    public static void main(String[] args) {
        try {
            ReservaFacade facade = new ReservaFacade();
            ReservaView view = new ReservaView();
            ReservaController controller = new ReservaController(facade, view);

            view.exibirMenuPrincipal(controller);
        } catch (Exception e) {
            System.out.println("Erro inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
