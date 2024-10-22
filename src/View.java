import Model.Tablero;

import java.util.HashMap;

public class View {

    public void imprimirTablero (Tablero TableroObj){
        // La mejor visualización se consigue poniendo como fuente de consola el tipo de letra "Arial Unicode MS"

        char[][] tablero = mapearTablero(TableroObj.piezas);
        for (int i = 0; i < tablero.length; i++) {
            System.out.print((8 - i) + " ");
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("  a b c d e f g h");
    }



    public static char[][] mapearTablero(byte[][] tablero){
        char[][] mapear = new char[tablero.length][tablero[0].length];
        char[] arregloDeMapeoBlanco = {' ','♟','♜','♞','♝','♚','♛'};
        char[] arregloDeMapeoNegro = {' ','♙','♖','♘','♗','♔','♕'};
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if(tablero[i][j] >= 0){
                    mapear[i][j] = arregloDeMapeoBlanco[tablero[i][j]];
                }
                else{
                    mapear[i][j] = arregloDeMapeoNegro[-tablero[i][j]];
                }
            }
        }
        return mapear;
    }
}
