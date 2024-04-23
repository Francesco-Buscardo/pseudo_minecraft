package Data.UI;

import Data.Blocks.Exceptions.BlockErrorException;
import Data.Blocks.Interfaces.InventoryBlock;
import Data.Blocks.Interfaces.SmeltableBlock;
import Data.Blocks.Interfaces.block;
import Data.Factory.FactoryBlock;
import Data.Utils.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Inventory implements InventoryBlock {

    ///////////////////////////////////////////////
    // VAR ----------------------------------------
    List<block> L;
    FactoryBlock factoryBlock;
    Comparator<block> comparator;
    ///////////////////////////////////////////////
    // CONSTRUCTORS -------------------------------
    public Inventory () {
        this.comparator = new AlphabeticalBlockComparator();
        this.L = new ArrayList<>(9); // LISTA DI BLOCCHI
        this.factoryBlock = new FactoryBlock();
        for (int i = 0; i < 36; i++) {               // INIT INVENTARIO DI 36 POSTI
            this.add_block(factoryBlock.randomBlock());
            /*
            Random rand = new Random();
            int x = rand.nextInt(3);
            if (x == 0)
                this.add_block(new NullBlock());
            if (x == 1)
                this.add_block(new SandBlock());
            if (x == 2)
                this.add_block(new EarthBlock());
            */
            //this.orderInventory(this.L);
        }
    }
    ///////////////////////////////////////////////
    // METHODS ------------------------------------
    public void display_in_inventory () {
        for (block i : L) // i = E' UN BLOCCO DENTRO UNA LISTA DI BLOCCHI
            System.out.printf(i.display() + " ");
    }
    private void add_block (block b) {
        this.L.add(b);
    }
    private boolean is_smeltable (int index) {
        return this.L.get(index) instanceof SmeltableBlock;
    }
    public SmeltableBlock get_smeltable (int index) throws BlockErrorException {
        if (this.is_smeltable(index)) {
            return (SmeltableBlock) this.L.get(index);
        } else {
            throw new BlockErrorException();
        }
    }
    public void setNullBlock (int index) {
        this.L.set(index, this.factoryBlock.setNullBlock());
    }
    public void orderInventory (List<block> L) {
        for (int i = 0; i < L.size() - 1; i ++) {
            for (int j = 0; j < L.size() - 1; j ++) {
                if (comparator.compare(L.get(j), L.get(j + 1)) > 0)
                    this.swap(L, j, j + 1);
            }
        }
    }
    private void swap (List<block> L, int i, int j) {
        block temp = L.get(i);
        L.set(i, L.get(j));
        L.set(j, temp);
    }
    public Comparator<block> changeComparator (Comparator<block> comparator) {
        if (comparator.getClass() == this.comparator.getClass()) {
            return new BlockComparator();
        } else {
            return new AlphabeticalBlockComparator();
        }
    }
    ///////////////////////////////////////////////
}
