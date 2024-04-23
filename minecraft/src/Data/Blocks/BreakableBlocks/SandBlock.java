package Data.Blocks.BreakableBlocks;

import Data.Blocks.AbstractBlock;
import Data.Blocks.Interfaces.SmeltableBlock;
import Data.Blocks.Interfaces.block;
import Data.Blocks.SolidBlocks.GlassBlock;

public class SandBlock extends AbstractBlock implements SmeltableBlock {

    public SandBlock () {
        this.contenuto          = '$';
        this.fall_through       = false;
        this.falls_with_gravity = true;
        this.pickeable          = true;
        this.blockName          = "Sand Block";
        this.breakable          = true;
    }
    ////////////////////////////////////////////////////
    @Override
    public block smelt () {
        return new GlassBlock();
    }
}
