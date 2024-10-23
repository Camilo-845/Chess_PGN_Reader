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
    private Lector lectorPGN;
    private Lector lectorMatriz;

    private int rondaActual;
    public Tablero tableroActual;

    public Partida(String filePath){
        try{
            lectorMatriz = new Lector("resources/InitBoard.txt");
            lectorPGN = new Lector(filePath);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        estados = new ArrayList<>();
        estados.add(new Tablero(lectorMatriz.leerMatrizTablero()));
        rondas = 0;
        rondaActual = 0;
        tableroActual = estados.get(rondaActual);
        obtenerMovimientos();
    }

    public void siguienteRonda(){
        rondaActual++;
    }
    public void anteriorRonda(){
        rondaActual--;
    }
    private void obtenerMovimientos(){
        String[] movimientos = lectorPGN.leerPGN_moves();
    }
}
