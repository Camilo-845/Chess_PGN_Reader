import Model.Tablero;

import java.util.HashMap;

public class View {

    public void imprimirTablero (Tablero tablero1){
        // La mejor visualización se consigue poniendo como fuente de consola el tipo de letra "Arial Unicode MS"

        char[][] tablero = {
                {'♜', '♞', '♝', '♛', '♚', '♝', '♞', '♜'},
                {'♟', ' ', '♟', '♟', '♟', '♟', '♟', '♟'},
                {' ', '♟', ' ', ' ', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', '♗', ' '},
                {' ', ' ', ' ', '♙', ' ', ' ', ' ', ' '},
                {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '},
                {'♙', '♙', '♙', ' ', '♙', '♙', '♙', '♙'},
                {'♖', '♘', ' ', '♕', '♔', '♗', '♘', '♖'},
        };

        for (int i = 0; i < tablero.length; i++) {
            System.out.print(anchoFijo((8 - i) + " "));
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(anchoFijo(tablero[i][j]));
            }
            System.out.println();
        }
        System.out.println(anchoFijo("  abcdefgh"));
    }



    public static char[][] mapearTablero(char[][] tablero){


    }

    public static char anchoFijo(char letra) {

        // REF: Caracteres de ancho completo Unicode: http://xahlee.info/comp/unicode_full-width_chars.html
        // REF: Halfwidth and fullwidth forms: https://en.wikipedia.org/wiki/Halfwidth_and_fullwidth_forms

        char resultado = letra;

        if (letra >= 0x30 && letra <= 0x39) {  // [0-9]
            resultado = (char) (letra - 0x30 + 0xff10);
        } else if (letra >= 0x41 && letra <= 0x5A) { // [A-Z]
            resultado = (char) (letra - 0x41 + 0xff21);
        } else if (letra >= 0x61 && letra <= 0x7A) { // [a-z]
            resultado = (char) (letra - 0x61 + 0xff41);
        } else if (letra == 0x20) { // espacio
            resultado = (char) (0x3000);
        }

        return resultado;
    }

    /**
     * Convierte un dígito a un carácter Unicode de ancho fijo
     *
     * @param n El dígito en el rango [0-9] a convertir
     * @return El carácter de ancho fijo o un espacio en blanco si no es válido
     */
    public static char anchoFijo(int n) {

        char resultado = 0x3000;

        if (n >= 0 && n <= 9) {
            resultado = anchoFijo(Character.forDigit(n, 10));
        }

        return resultado;
    }

    /**
     * Convierte una cadena de texto a su equivalente en caracteres Unicode de de ancho fijo
     *
     * @param cadena La cadena a convertir
     * @return La cadena con los caracteres convertibles reemplazados
     */
    public static String anchoFijo(String cadena) {

        StringBuilder resultado = new StringBuilder();

        for (int i = 0; i < cadena.length(); i++) {
            resultado.append(anchoFijo(cadena.charAt(i)));
        }

        return resultado.toString();
    }
}
