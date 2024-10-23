public class Main {
    public static void main(String[] args) {
        View vista =  new View();
        Controller c = new Controller(vista,"resources/TestFiles/krnilesh7_vs_Canss845_2024.08.08.pgn");
        c.imprimirTablero();
    }
}
