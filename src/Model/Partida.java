package Model;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import utils.Lector;

public class Partida{
    private ArrayList<Tablero> estados;
    private int rondas;
    private String evento;
    private String sitio;
    private String fecha;
    private String Blancas;
    private String Negras;
    private String Resultado;

    private int rondaActual;
    private Tablero tableroActual;

    public Partida(){
        estados = new ArrayList<Tablero>();
        try{
            estados.add(new Tablero(new Lector("resources/InitBoard.txt").leerMatrizTablero()));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        rondas = 0;
    }

    public void siguienteRonda(){
        rondaActual++;
    }
    public void anteriorRonda(){
        rondaActual--;
    }
}
