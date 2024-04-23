package Data.Blocks.SolidBlocks;

import Data.Blocks.AbstractBlock;

public class AbstractSolidBlock extends AbstractBlock {

    public AbstractSolidBlock () {
        this.fall_through       = false;
        this.falls_with_gravity = false;
        this.pickeable          = true;
        this.breakable          = false;
    };
}
