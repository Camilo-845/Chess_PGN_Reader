import Model.Partida;

public class Controller {
    public Partida partida;
    public View view;

    public Controller (View view, String filePath) {
        this.view = view;
        this.partida = new Partida(filePath);
    }

    public void iniciar(){
        view.imprimirHeaders(partida);
        view.imprimirTablero(partida.obtenerTableroActual());
        while (true){
            char entrada = view.capturarEntrada("Siguiente movmiento (S) anterior (A) salir (0) > ").charAt(0);
            if(entrada == 'S'|| entrada == 's'){
                partida.siguienteRonda();

            }else if(entrada == 'A'|| entrada == 'a'){
                partida.anteriorRonda();
            } else if (entrada == '0') {
                break;
            }
            System.out.println("Ronda ("+partida.obtenerRondaActual()+")");
            view.imprimirTablero(partida.obtenerTableroActual());
        }
    }

    public void imprimirPartida(){

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
