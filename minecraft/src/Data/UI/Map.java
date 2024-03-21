package Data.UI;
import Data.Blocks.*;
public class Map {
    ////////////////////////////////////////////////
    // VAR -----------------------------------------
    private static final int row    = 15;
    private static final int column = 50;
    private AbstractBlock map[][] = new AbstractBlock[row][column]; // MATRICE DI BLOCCHI (BASE MAPPA)
    ////////////////////////////////////////////////
    // GETTER SETTER -------------------------------
    public static int getRow () {
        return row;
    };
    public static int getColumn () {
        return column;
    };
    ////////////////////////////////////////////////
    // COSTRUCTORS ---------------------------------
    // crea mappa di default
    public Map () { //  INIZILAIZZO LA MAPPA A BLOCCHI ARIA (DEFUALT)
        for (int i = 0; i < this.row; i ++) {
            for (int j = 0; j < this.column; j ++) {
                this.map[i][j] = new AirBlock();
            }
        }
        this.addRiver(map);
    };
    ///////////////////////////////////////////////
    // METHODS ------------------------------------
    // MATODO CHE STAMPA MATRICE (MAPPA)
    public void Display_map () {
        this.frame();
        this.random_map();
        int x = this.generate_rand(0, 1);
        if (x == 0)
            this.addRiver(map);
        else
            this.addSea(map);
        for (int i = 0; i < row; i ++) {
            for (int j = 0; j < column; j++)
                System.out.printf(" " + this.map[i][j].display()); //stampa il blocco in pos [][]
            System.out.println();
        }

    };
    /*public void change_cell (int a, int b) {  //genara nelle coord [a][b] il blocco ?
        if (a >= this.row || b >= this.column || a < 0 || b < 0)
            System.out.printf("The value exceed the map dimension!" + "\n");
        else
           this.map[a][b] = new AirBlock('?'); //blocco non di default
    };*/
    private void swap (int a, int b) { //scambia le coordinate passate con il blocco di sotto per emulare la gravita
        if (a < this.row - 1) {
            AbstractBlock temp = map[a + 1][b];     //creo blocco temporaneo alle coordinate [a+1][b]
            map[a + 1][b] = map[a][b];
            map[a][b] = temp;
        }
    };
    public void fall_block (int i, int j) {
        if(i < this.row - 1) {
            if (map[i+1][j].getFall_through()) {
                this.swap(i, j);
                this.fall_block(i + 1, j);
            }
        }
    };
    public void random_map () {
        this.frame();
        for (int i = 0; i < this.row; i ++) {
                for (int j = 0; j < this.column; j++) {
                    if (i > 3){
                        int x = this.generate_rand(0, 2);
                        if (x == 1) {  // BLOCCO NON DEFAULT
                            map[i][j] = new AirBlock('0', false, false);
                            this.fall_block(i, j);
                        }
                        else if (x == 2) {  // SABBIA
                            map[i][j] = new SandBlock();
                            this.fall_block(i, j);
                        }
                    }
                }
        }
    };
    private void addRowsOfWater (AbstractBlock map[][]) { // AGGIUNGE UNA RIGA D'ACQUA
        for (int k = 0; k < this.column; k ++) {
            map[0][k] = new WaterBlock();
            this.fall_block(0, k);
        }
    }
    public void addRiver (AbstractBlock map[][]) {
        this.addRowsOfWater(map);
    }
    public void addSea (AbstractBlock map[][]) {
        int i = 0;
        while (i < 3) {
            for (int k = 0; k < this.column; k++) {
                map[0][k] = new WaterBlock();
                this.fall_block(0, k);
            }
            i ++;
        }
    }
    private int generate_rand (int min, int max) {
        return (int)Math.floor(Math.random() * (max - min + 1) + min);
    };
    private void frame () {
        for (int i = 0; i < this.column; i ++) {
            System.out.printf("__");
        }
        System.out.println("");
    }
    ///////////////////////////////////////////////
}
