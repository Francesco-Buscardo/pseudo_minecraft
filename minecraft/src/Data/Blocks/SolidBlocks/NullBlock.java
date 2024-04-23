package Data.Blocks.SolidBlocks;

import Data.Blocks.Interfaces.SmeltableBlock;
import Data.Blocks.Interfaces.block;

public class NullBlock extends AbstractSolidBlock implements SmeltableBlock {

    public NullBlock () {
        super();
        this.contenuto = 'N';
        this.blockName = "Null Block";
        this.pickeable = false;
    }
    ////////////////////////////////////////////////////
    @Override
    public block smelt () {
        return new NullBlock();
    };

    @Override
    public char display() {
        return super.display();
    };
}
