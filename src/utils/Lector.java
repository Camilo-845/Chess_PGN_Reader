package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lector{
    public String path;
    public Scanner scanner;
    public File file;

    private String regexRondas = "(\\d+.[\\n ](([a-zA-Z]+\\d[#+]*)|(\\d-\\d))[\\n ]+(([a-zA-Z]+\\d[#+]*)|(\\w-\\w)))";
    private String regexHeaders = "\\[[\\S\\W]*\\]";

    public Lector(String path) throws FileNotFoundException {
        this.path = path;
        this.file = new File(path);
        this.scanner = new Scanner(file);
    }

    public byte[][] leerMatrizTablero(){
        byte[][] tablero = new byte[8][8];
        int line = 0;
        while(scanner.hasNext()){
            String linea = scanner.nextLine();
            String[] itemsLinea = linea.split(",");
            for(int i = 0; i < itemsLinea.length; i++){
                tablero[line][i] = Byte.parseByte(itemsLinea[i]);
            };
            line++;
        }
        return tablero;
    }

    public String leerPGN_header(String header){
        while(scanner.hasNextLine()){
            String linea = scanner.nextLine();
            if(linea.matches("\\["+header+" [a-zA-z \"]*")){
                String regex = "(\"[\\w\\d. ]*\")";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(linea);
                if(matcher.find()){
                    try{
                        return matcher.group(1).replace("\"","");
                    }
                    catch(Exception e){
                        return "NULL";
                    }
                }else{
                    return "null";
                }
            };
        }
        return "null";
    }

    public String[] leerPGN_moves(){
        StringBuilder mainStringBuilder = new StringBuilder();
        //Leer todo el documento y agregarlo al string
        while(scanner.hasNextLine()){
            mainStringBuilder.append(" " + scanner.nextLine());
        }
        String mainString = mainStringBuilder.toString();
        //Usa Regex para agrupar coincidencias(Movimientos)

        Pattern pattern = Pattern.compile(regexRondas);
        Matcher matcher = pattern.matcher(mainString);
        List<String> moves = new ArrayList<>();
        while (matcher.find()) {
            moves.add(matcher.group());
        }
        return moves.toArray(new String[0]);
    }

}
