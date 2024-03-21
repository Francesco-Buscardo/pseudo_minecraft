import Data.UI.*;

public class main {
    public static void main (String[] args) {
        Map M = new Map();
        // CREO UNA MAPPA CASUALE
        map(M);
        System.out.println("");
    }
    // PROCEDURA CHE STAMPA LA MAPPA
    static public void map (Map M) {
        M.Display_map();
    }
}