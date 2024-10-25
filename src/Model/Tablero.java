package Model;

public class Tablero {
    public byte[][] piezas;
    public Tablero(byte[][] piezas) {
        this.piezas = new byte[piezas.length][piezas[0].length];
        for (int i = 0; i < piezas.length; i++) {
            for (int j = 0; j < piezas[0].length; j++) {
                this.piezas[i][j] = piezas[i][j];
            }
        }
    }

    public int[] obtenerPosPiezaEnColumna(byte pieza, int columna) {
        int[] pos = new int[2];
        for (int i = 0; i < piezas.length; i++) {
            if (pieza == piezas[i][columna]) {
                pos[0] = i;
                pos[1] = columna;
                return pos;
            }
        }
        return null;
    }
    public int[] obtenerPosPiezaEnFila(byte pieza, int fila) {
        int[] pos = new int[2];
        for (int i = 0; i < piezas.length; i++) {
            if (pieza == piezas[fila][i]) {
                pos[0] = fila;
                pos[1] = i;
                return pos;
            }
        }
        return null;
    }
    public int[] obtenerPosCaballo(int fila, int columna, boolean blanco) {
        int[] pos = new int[2];
        int[][] posiblesPosiciones = {{fila+2,columna+1},{fila+2,columna-1},{fila-2,columna+1},{fila-2,columna-1},
                                      {fila+1,columna+2},{fila-1,columna+2},{fila+1,columna-2},{fila-1,columna-2}};
        for (int i = 0; i < posiblesPosiciones.length; i++) {
            if(posiblesPosiciones[i][0]>=0&&posiblesPosiciones[i][0] < 8
               &&posiblesPosiciones[i][1]>=0&&posiblesPosiciones[i][1] < 8){
                byte piezaEnPos = piezas[posiblesPosiciones[i][0]][posiblesPosiciones[i][1]];
                if((int)piezaEnPos == (blanco?3:-3)){
                    pos[0] = posiblesPosiciones[i][0];
                    pos[1] = posiblesPosiciones[i][1];
                    return pos;
                }
            }
        }
        return null;
    }

    public void cambiarPos(byte pieza, int fila, int columna) {
        this.piezas[fila][columna] = pieza;
    }

    public byte obtenerPos(int fila, int columna) {
        return this.piezas[fila][columna];
    }

    public int[] obtenerPosPieza(byte pieza){
        for (int i = 0; i < piezas.length; i++) {
            for (int j = 0; j < piezas[i].length; j++) {
                if (pieza == piezas[i][j]) {
                    return new int[]{i,j};
                }
            }
        }
        return null;
    }

    public int[] obtenerPosAlfil(int fila, int columna, boolean blanco) {
        int[] pos = new int[2];
        boolean colorCasilla = (fila+columna) % 2 == 0;

        for (int i = 0; i < piezas.length; i++) {
            for (int j = 0; j < piezas[i].length; j++) {
                boolean esCasillaBlanca = (i+j) % 2 == 0;
                boolean esIgual = ( esCasillaBlanca== colorCasilla);
                if(esIgual){
                    if((int) piezas[i][j] == (blanco?4:-4)){
                        pos[0] = i;
                        pos[1] = j;
                        return pos;
                    }
                }
            }
        }
        return null;
    }
}