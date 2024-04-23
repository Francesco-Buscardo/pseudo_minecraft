package Data.Blocks.BreakableBlocks;

import Data.Blocks.AbstractBlock;
import Data.Blocks.Interfaces.block;

public class GravelBlock extends AbstractBlock implements block {

    public GravelBlock () {
        this.contenuto          = 'G';
        this.fall_through       = false;
        this.falls_with_gravity = true;
        this.pickeable          = true;
        this.blockName          = "Gravel Block";
        this.breakable          = true;
    }
    ////////////////////////////////////////////////////
}
