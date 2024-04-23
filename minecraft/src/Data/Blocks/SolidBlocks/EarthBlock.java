package Data.Blocks.SolidBlocks;

import Data.Blocks.Interfaces.block;

public class EarthBlock extends AbstractSolidBlock implements block {
    public EarthBlock () {
        super();
        this.contenuto = 'T';
        this.blockName = "Earth Block";
    };
}
