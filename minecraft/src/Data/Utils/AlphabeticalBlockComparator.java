package Data.Utils;

import Data.Blocks.Interfaces.block;
import java.util.Comparator;

// COMPARA I DUE BLOCCHI IN MODO ALFABETICO
public class AlphabeticalBlockComparator implements Comparator<block> {

    @Override
    public int compare (block Block1, block Block2) {
        return Block1.toString().compareTo(Block2.toString());
    }
}
