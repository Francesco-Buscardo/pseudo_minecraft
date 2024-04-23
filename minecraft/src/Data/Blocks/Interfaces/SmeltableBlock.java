package Data.Blocks.Interfaces;

import Data.Blocks.Interfaces.block;

public interface SmeltableBlock extends block {
    ////GETTER/OTHERS/////////////////////////////////////////
    block smelt ();
    ////SETTER////////////////////////////////////////////////
    @Override
    char display();
}
