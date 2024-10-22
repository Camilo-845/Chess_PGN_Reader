# TABLERO DE AJEDREZ
Tablero de ajedrez en consola basado en la lectura y escritura de archivos de datos de juego desarrollado
bajo el patron de arquitectura MVC
- Basado en al lectura de archivos [PGN(Portable Game Notation)](https://en.wikipedia.org/wiki/Portable_Game_Notation)
- El tablero se imprime en consola con los caracteres en unicode de cada una de las piezas del ajedrez

## Sintaxis y mapeo

### Valores para matriz de tablero
| **PIEZA**   | **BLANCO** | **NEGRO** |
|:------------|:----------:|:---------:|
| **NINGUNA** |     0      |     0     |
| **PEON**    |     1      |    _1     |
| **TORRE**   |     2      |    _2     |
| **CABALLO** |     3      |    _3     |
| **ALFIL**   |     4      |    _4     |
| **REY**     |     5      |    _5     |
| **REINA**   |     6      |    _6     |

#### Ejemplo de tablero inicial:
````
_2,_3,_4,_6,_5,_4,_3,_2
_1,_1,_1,_1,_1,_1,_1,_1
0,0,0,0,0,0,0,0
0,0,0,0,0,0,0,0
0,0,0,0,0,0,0,0
0,0,0,0,0,0,0,0
1,1,1,1,1,1,1,1
2,3,4,5,6,4,3,2
````

### Mapeo de valores de matriz a unicode

| **VALOR**   | 1 | 2 | 3 | 4 | 5 | 6 | _1 | _2 | _3 | _4 | _5 | _6 |
|-------------|---|---|---|---|---|---|----|----|----|----|----|----|
| **UNICODE** | ♟ | ♜ | ♞ | ♝ | ♚ | ♛ | ♙  | ♖  | ♘  | ♗  | ♔  | ♕  |