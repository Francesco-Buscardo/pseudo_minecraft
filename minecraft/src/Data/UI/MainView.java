package Data.UI;

import Data.Blocks.*;
import Data.Blocks.Exceptions.BlockErrorException;
import Data.Blocks.Interfaces.block;
import Data.Blocks.SolidBlocks.NullBlock;
import Data.Blocks.SolidBlocks.TorchBlock;
import Data.Factory.FactoryBlock;
public class MainView {

    ////////////////////////////////////////////////
    // VAR -----------------------------------------
    Map     M;
    Furnace F;
    FactoryBlock factoryBlock;
    Inventory inventoryBlock;
    ////////////////////////////////////////////////
    // GETTER SETTER -------------------------------
    ////////////////////////////////////////////////
    // COSTRUCTORS ---------------------------------
    public MainView () {
        this.M              = new Map();
        this.F              = new Furnace();
        this.factoryBlock   = new FactoryBlock();
        this.inventoryBlock = new Inventory();
    }
    ///////////////////////////////////////////////
    // METHODS ------------------------------------
    public void DisplayMap () {
        this.M.Display_map();    // MAPPA MODIFICATA
        this.F.display_on_out(); // BLOCCO SMELTATO
    }
    public void DisplayInventory () {
        this.inventoryBlock.display_in_inventory(); // INVENTARIO
        this.F.display_on_out();                    // BLOCCO SMELTATO
    }
    public void move_into_furnace (int i, int j) {
        try {
            this.F.setFurnaceInput(M.returnSmeltableBlock(i, j));
            M.setAirBlock(i, j);
            M.fall_down(i-1, j);
        } catch (BlockErrorException blockErrorException) {
            System.out.println("NOT SMELTABLE BLOCK!");
            blockErrorException.printStackTrace();
        }
        /*if (M.isSmeltable(i,j)) { // PER VEDERE SE MAP è UN ISTANZA DI SMELTABLEBLOCK
            this.F.setFurnaceInput(M.returnSmeltableBlock(i, j));
            M.setAirBlock(i, j);
            M.fall_down(i-1, j);
        }*/
    }
    public void move_into_inventory (int i, int j) throws BlockErrorException {
        if (M.isSmeltable(i,j)) {
            int y = 0;
            for ( ; y < this.inventoryBlock.L.size() - 1; y ++) {
                if (this.inventoryBlock.L.get(y).getClass() == NullBlock.class) {
                    this.inventoryBlock.L.set(y, M.getBlockInCoord(i, j));
                    break;
                }
            }
            M.setAirBlock(i, j);
            M.fall_down(i-1, j);
            this.move_into_furnace_inventory(y);
        } else {
            throw new BlockErrorException();
        }
    }
    public void move_into_furnace_inventory (int index) { // DAL'INVENTARIO ALLA FORNACE
        try {
            this.F.setFurnaceInput(inventoryBlock.get_smeltable(index));
            this.inventoryBlock.setNullBlock(index);
        } catch (BlockErrorException blockErrorException) {
            System.out.println("NOT SMELTABLE BLOCK!");
            blockErrorException.printStackTrace();
        }
        /*if (inventoryBlock.is_smeltable(index)) {
            this.F.setFurnaceInput(inventoryBlock.get_smeltable(index));
            this.inventoryBlock.setNullBlock(index);
        }*/
    }
    public void move_into_inventory_furnace (int index) { // DALLA FORNACE ALL' INVENTARIO
        if ((inventoryBlock.L.size() > index) && (index >= 0)) {
            this.inventoryBlock.L.set(index, this.F.getOutput());
            this.inventoryBlock.orderInventory(this.inventoryBlock.L);
        }
    }
    public void smeltMainView() {
        this.F.smeltInFurnace();
    }
    public void displayOnOutMainView () {
        this.F.display_on_out();
    }
    public block gimme_pickable (int i, int j) throws BlockErrorException {
        return M.gimme_pickable(i, j);
    }
    public void setTorchBlock (int i, int j) {
        this.M.setBlockInCoord(i, j, new TorchBlock());
        this.BreakUpper(i, j);
    }
    private void BreakUpper (int i, int j) {
        if (i >= 0 && i < Map.row && this.M.getBlockInCoord(i-1, j).getBreakable()) {
            M.setBlockInCoord(i-1, j, new AirBlock());
            M.fall_down(i - 2, j);
            this.BreakUpper(i-1, j);
        }
    }
    ///////////////////////////////////////////////
}