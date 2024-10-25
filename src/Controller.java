import Model.Partida;

public class Controller {
    public Partida partida;
    public View view;

    public Controller (View view, String filePath) {
        this.view = view;
        this.partida = new Partida(filePath);
    }

    public void imprimirTablero(){
        for(int i = 0,j=1; i<partida.estados.size() ; i++){
            System.out.println("-----------------------------");
            if(i%2!=0){
                System.out.println("Ronda ("+j+")");
                j++;
            }
            view.imprimirTablero(partida.estados.get(i));
        }
    }
}
