package Data.Blocks.SolidBlocks;

import Data.Blocks.Interfaces.IronSwordInterface;
import Data.Blocks.Interfaces.block;

public class RawIronBlock extends AbstractSolidBlock implements IronSwordInterface {

    public RawIronBlock () {
        super();
        this.contenuto = 'I';
        this.blockName = "Iron Block";
    };
    @Override
    public block smelt() {
        return new IronSwordBlock();
    };
}
