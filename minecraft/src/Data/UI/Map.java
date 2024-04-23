package Data.UI;

import Data.Blocks.*;
import Data.Blocks.BreakableBlocks.SandBlock;
import Data.Blocks.Exceptions.BlockErrorException;
import Data.Blocks.Interfaces.SmeltableBlock;
import Data.Blocks.Interfaces.block;
import Data.Factory.FactoryBlock;
import java.util.Random;
public class Map {
    ////////////////////////////////////////////////
    // VAR -----------------------------------------
    public static final int row    = 15;
    public static final int column = 50;
    private block[][] map = new block[row][column]; // MATRICE DI BLOCCHI (BASE MAPPA)
    FactoryBlock factoryBlock;
    ////////////////////////////////////////////////
    // GETTER SETTER -------------------------------
    public block getBlockInCoord (int i, int j) {
        return this.map[i][j];
    }
    public void setBlockInCoord (int i, int j, block inBlock) {
        this.map[i][j] = inBlock;
    }
    ////////////////////////////////////////////////
    // COSTRUCTORS ---------------------------------
    // crea mappa di default
    public Map () { // INIZIALIZZO LA MAPPA A BLOCCHI ARIA (DEFUALT) E UN FIUME
        this.factoryBlock = new FactoryBlock();
        for (int i = 0; i < row; i ++) {
            for (int j = 0; j < column; j ++) {
                this.map[i][j] = factoryBlock.setAirBlock();
            }
        }
        this.random_map();
        this.intCasualBlocks();
    }
    ///////////////////////////////////////////////
    // METHODS ------------------------------------
    // METODO CHE STAMPA MATRICE (MAPPA)
    public void Display_map () {
        this.frame();
        for (int i = 0; i < row; i ++) {
            for (int j = 0; j < column; j++)
                System.out.printf(" " + this.map[i][j].display()); //stampa il blocco in pos [][]
            System.out.println();
        }
    }
    private void swap (int a, int b) {
        if (a < row - 1) {
            block temp = this.map[a + 1][b];
            this.map[a + 1][b] = this.map[a][b];
            this.map[a][b] = temp;
        }
    }
    public void fall_block (int i, int j) {
        if(i < row - 1) {
            if (map[i+1][j].getFall_through()) {
                this.swap(i, j);
                this.fall_block(i + 1, j);
            }
        }
    }
    public void random_map () {
        for (int i = 0; i < row; i ++) {
            for (int j = 0; j < column; j++) {
                if (i > 3){
                    int x = this.generate_rand(0, 5);
                    if (x == 1) {
                        this.map[i][j] = this.factoryBlock.setSandBlock();
                    } else if (x == 2) {
                        this.map[i][j] = this.factoryBlock.setEarthBlock();
                    } else if (x == 3) {
                        this.map[i][j] = this.factoryBlock.setRawIronBlock();
                    } else if (x == 4) {
                        this.map[i][j] = this.factoryBlock.setGravelBlock();
                    }
                    this.fall_block(i, j);
                }
            }
        }
        if (this.generate_rand(0, 2) == 0) {
            this.addRiver(map);
        } else if (this.generate_rand(0, 2) == 1) {
            this.addSea(map);
        }
    }
    private void addRowsOfWater (block[][] map) { // AGGIUNGE UNA RIGA D'ACQUA
        for (int k = 0; k < column; k ++) {
            map[0][k] = this.factoryBlock.setWaterBlock();
            this.fall_block(0, k);
        }
    }
    public void addRiver (block[][] map) {
        this.addRowsOfWater(map);
    }
    public void addSea (block[][] map) {
        int i = 0;
        while (i < 3) {
            for (int k = 0; k < column; k++) {
                map[0][k] = this.factoryBlock.setWaterBlock();
                this.fall_block(0, k);
            }
            i ++;
        }
    }
    boolean isSmeltable (int i, int j) {
        return this.map[i][j] instanceof SmeltableBlock;
    }
    public SmeltableBlock returnSmeltableBlock (int i, int j) throws BlockErrorException {
        if (this.isSmeltable(i, j)) {
            return (SmeltableBlock) this.map[i][j];
        } else {
            throw new BlockErrorException();
        }
    }
    public void intCasualBlocks () { // BLOCCO DI SABBIA

        Random rand = new Random();
        for (int i = 0 ; i < 1; i++) {
            block b = new SandBlock();
            int r = rand.nextInt(row);
            int c = rand.nextInt(column);
            this.map[r][c] = b;
            this.fall_block(r, c);
        }
    }
    public void fall_down (int i, int j) { // FA CADERE DALL'ALTO I BLOCCHI
        if (i >= 0 && i < row) {
            this.swap(i, j);
            this.fall_down(i-1, j);
        }
    }
    private Boolean is_pickeable(int i, int j) {
        return this.map[i][j].is_pickable();
    }
    public block gimme_pickable (int i, int j) throws BlockErrorException {
        if (this.is_pickeable(i, j)) {
            return this.map[i][j];
        } else {
            throw new BlockErrorException();
        }
    }
    ///////////////////////////////////////////////
    public void setAirBlock (int i, int j) {
        this.map[i][j] = new AirBlock();
    }
    private int generate_rand (int min, int max) {
        return (int)Math.floor(Math.random() * (max - min + 1) + min);
    }
    private void frame () {
        for (int i = 0; i < column; i ++) {
            System.out.print("__");
        }
        System.out.println();
    }
    ///////////////////////////////////////////////
}