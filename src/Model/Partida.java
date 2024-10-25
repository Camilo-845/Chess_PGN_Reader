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
            Tablero tableroB = realizarMovimiento(estados.getLast(),true, moveData[1]);
            estados.add(tableroB);
            Tablero tableroN = realizarMovimiento(estados.getLast(),false, moveData[2]);
            estados.add(tableroN);
            index++;
        }
    }

    private Tablero realizarMovimiento(Tablero tablero,  boolean blancas, String movimiento){
        tablero = new Tablero(tablero.piezas);
        String filasToInt = "abcdefgh";
        String columnaString = movimiento.replaceAll("[^a-h]","");
        columnaString = columnaString.length()==1?columnaString: columnaString.isEmpty() ?"a":""+columnaString.charAt(1);

        int columna = filasToInt.indexOf(columnaString);
        String filaString = movimiento.replaceAll("\\D","");
        int fila = (filaString.isEmpty())?0:8-Integer.parseInt(filaString);
        int[] pos;
        if(movimiento.matches("^[a-z].*")){
            pos = tablero.obtenerPosPiezaEnColumna(blancas?(byte)1:(byte)-1,filasToInt.indexOf(movimiento.charAt(0)));
            if(pos!=null){
                tablero.cambiarPos((byte) 0,(byte)pos[0],(byte)pos[1]);
                tablero.cambiarPos(blancas?(byte)1:(byte)-1,fila,columna);
            }
        }else{
            switch (movimiento.charAt(0)){
                case 'N':
                    if(movimiento.replaceAll("[^a-h]", "").length()!=1){
                        pos = tablero.obtenerPosPiezaEnColumna(blancas?(byte)3:(byte)-3,filasToInt.indexOf(movimiento.charAt(1)));
                        if(pos!=null){
                            tablero.cambiarPos((byte) 0,(byte)pos[0],(byte)pos[1]);
                            tablero.cambiarPos(blancas?(byte)3:(byte)-3,fila,columna);
                        }
                    }else{
                        pos = tablero.obtenerPosCaballo(fila,columna,blancas);
                        if(pos!=null){
                            tablero.cambiarPos((byte) 0,(byte)pos[0],(byte)pos[1]);
                            tablero.cambiarPos(blancas?(byte)3:(byte)-3,fila,columna);
                        }
                    }
                    break;
                case 'B':
                    pos = tablero.obtenerPosAlfil(fila,columna,blancas);
                    if(pos!=null){
                        tablero.cambiarPos((byte) 0,(byte)pos[0],(byte)pos[1]);
                        tablero.cambiarPos(blancas?(byte)4:(byte)-4,fila,columna);
                    }
                    break;
                case 'Q':
                    pos = tablero.obtenerPosPieza(blancas?(byte)6:(byte)-6);
                    if(pos!=null){
                        tablero.cambiarPos((byte) 0,(byte)pos[0],(byte)pos[1]);
                        tablero.cambiarPos(blancas?(byte)6:(byte)-6,fila,columna);
                    }
                    break;
                case 'K':
                    pos = tablero.obtenerPosPieza(blancas?(byte)5:(byte)-5);
                    if(pos!=null){
                        tablero.cambiarPos((byte) 0,(byte)pos[0],(byte)pos[1]);
                        tablero.cambiarPos(blancas?(byte)5:(byte)-5,fila,columna);
                    }
                    break;
                case 'R':
                    pos = tablero.obtenerPosPiezaEnColumna(blancas?(byte) 2: (byte) -2,columna);
                    if(pos==null){
                        pos = tablero.obtenerPosPiezaEnFila(blancas?(byte)2:(byte)-2,columna);
                    }
                    if(pos!=null){
                        tablero.cambiarPos((byte) 0,(byte)pos[0],(byte)pos[1]);
                        tablero.cambiarPos(blancas?(byte)2:(byte)-2,fila,columna);
                    }
                    break;
            }
        }
        return tablero;
    }

    public Tablero obtenerTableroRonda(int ronda){
        return estados.get(ronda);
    }
}
