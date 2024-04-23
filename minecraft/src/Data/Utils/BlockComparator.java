package Data.Utils;

import Data.Blocks.*;
import Data.Blocks.BreakableBlocks.SandBlock;
import Data.Blocks.Interfaces.block;
import Data.Blocks.SolidBlocks.EarthBlock;
import Data.Blocks.SolidBlocks.GlassBlock;
import Data.Blocks.SolidBlocks.NullBlock;
import Data.Blocks.SolidBlocks.RawIronBlock;

import java.util.Comparator;

// COMPARA I DUE BLOCCHI IN MODO ASSOLUTO
public class BlockComparator implements Comparator<block> {

    @Override
    public int compare (block Block1, block Block2) {
        if (this.num_block(Block1) > this.num_block(Block2)) {
            return 1;
        } else if (this.num_block(Block1) == this.num_block(Block2)){
            return 0;
        } else {
            return -1;
        }
    }
    private int num_block (block inBlock) {
        return switch (inBlock) {
            case AirBlock     ignored -> 1;
            case EarthBlock ignored -> 2;
            case GlassBlock ignored -> 5;
            case NullBlock ignored -> 3;
            case RawIronBlock ignored -> 7;
            case SandBlock ignored -> 6;
            case WaterBlock   ignored -> 4;
            case null, default        -> 0;
        };
    }
}
