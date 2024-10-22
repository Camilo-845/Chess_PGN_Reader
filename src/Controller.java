import Model.Partida;

public class Controller {
    public Partida partida;
    public View view;

    public Controller (View view, String filePath) {
        this.view = view;
        this.partida = new Partida(filePath);
    }

    public void imprimirTablero(){
        view.imprimirTablero(partida.tableroActual);
    }
}
