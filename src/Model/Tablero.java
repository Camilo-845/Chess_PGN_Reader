package Model;

public class Tablero {
    public byte[][] piezas;
    public Tablero(byte[][] piezas) {
        this.piezas = piezas;
    }

    public int contarPiezasEnColumna(byte pieza, int columna) {
        int contador = 0;
        for (int i = 0; i < piezas.length; i++) {
            if (pieza == piezas[i][columna]) {
                contador++;
            }
        }
        return contador;
    }
    public int contarPiezasEnFila(byte pieza, int fila) {
        int contador = 0;
        for (int i = 0; i < piezas.length; i++) {
            if (pieza == piezas[fila][i]) {
                contador++;
            }
        }
        return contador;
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