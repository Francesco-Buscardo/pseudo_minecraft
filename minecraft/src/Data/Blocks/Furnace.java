package Data.Blocks;

import Data.Blocks.Interfaces.SmeltableBlock;
import Data.Blocks.Interfaces.block;
import Data.Blocks.SolidBlocks.NullBlock;

public class Furnace {

    SmeltableBlock furnaceInput;
    block furnaceOutput;
    ///////////////////////////////////////////////
    // CONSTRUCTORS -------------------------------
    public Furnace () {
        this.furnaceInput  = new NullBlock();
        this.furnaceOutput = new NullBlock();
    }
    ///////////////////////////////////////////////
    // GETTER SETTER ------------------------------
    public void setFurnaceInput (SmeltableBlock inBlock) {
        this.furnaceInput = inBlock;
        this.furnaceOutput = this.furnaceInput.smelt();
    }
    public block getOutput () {
        return this.furnaceOutput;
    }

    public block getFurnaceInput () {
        return this.furnaceInput;
    }

    ///////////////////////////////////////////////
    // METHODS ------------------------------------
    public void display_on_out () {
        System.out.println("\n|| "
                + this.furnaceInput.display()
                + " --> "
                + this.furnaceOutput.display()
                + " ||");
    }
    public void smeltInFurnace () {
        this.furnaceOutput = this.furnaceInput.smelt(); // smelto inputFurnace o metto lo smelt in output
        this.furnaceInput = new NullBlock();
    }
}
