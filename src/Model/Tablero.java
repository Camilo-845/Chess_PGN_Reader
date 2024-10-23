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

    public int[] ObtenerPosPiezaEnColumna(byte pieza, int columna) {
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
    public int[] ObtenerPosPiezaEnFila(byte pieza, int fila) {
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
    public void cambiarPos(byte pieza, int fila, int columna) {
        this.piezas[fila][columna] = pieza;
    }

    public byte obtenerPos(int fila, int columna) {
        return this.piezas[fila][columna];
    }

    public byte[] obtenerPosPieza(byte pieza){
        for (int i = 0; i < piezas.length; i++) {
            for (int j = 0; j < piezas[i].length; j++) {
                if (pieza == piezas[i][j]) {
                    byte[] arr = {(byte) i,(byte) j};
                    return arr;
                }
            }
        }
        return null;
    }
}