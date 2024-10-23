package Model;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import utils.Lector;

public class Partida{
    public ArrayList<Tablero> estados;
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
        int index = 1;
        for(String movimiento :movimientos){
            String[] moveData = movimiento.split(" ");

            if(index != movimientos.length){
                Tablero tableroB = realizarMovimiento(estados.getLast(),true, moveData[1]);
                estados.add(tableroB);
                Tablero tableroN = realizarMovimiento(estados.getLast(),false, moveData[2]);
                estados.add(tableroN);
                index++;
            }
            else{
                if(moveData.length>=3){
                    //Cuando las negras ganan
                }
                else{
                    //Cuando las blancas ganan
                }
            }
        }
    }

    private Tablero realizarMovimiento(Tablero tablero,  boolean blancas, String movimiento){
        tablero = new Tablero(tablero.piezas);
        String filasToInt = "abcdefgh";
        String columnaString = movimiento.split("x")[0].replaceAll("[A-Z\\d\\W]","");
        int columna = filasToInt.indexOf(columnaString);
        String filaString = movimiento.replaceAll("[^\\d]","");
        int fila = (filaString.equals(""))?0:Integer.parseInt(filaString);

        if(movimiento.matches("^[a-z].*")){
            int[] pos = tablero.ObtenerPosPiezaEnColumna(blancas?(byte)1:(byte)-1,columna);
            tablero.cambiarPos((byte) 0,(byte)pos[0],(byte)pos[1]);
            tablero.cambiarPos(blancas?(byte)1:(byte)-1,fila,columna);
        }
        return tablero;
    }

    public Tablero obtenerTableroRonda(int ronda){
        return estados.get(ronda);
    }
}
