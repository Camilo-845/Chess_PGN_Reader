package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Lector{
    public String path;
    public Scanner scanner;
    public File file;
    public Lector(String path) throws FileNotFoundException {
        this.path = path;
        this.file = new File(path);
        this.scanner = new Scanner(file);
    }

    public char[][] leerMatrizTablero(){
        char[][] tablero = new char[8][8];
        int line = 0;
        while(scanner.hasNext()){
            String linea = scanner.nextLine();
            tablero[line] = linea.toCharArray();
            line++;
        }
        return tablero;
    }
}
