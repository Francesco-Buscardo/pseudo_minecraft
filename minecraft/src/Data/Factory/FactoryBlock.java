package Data.Factory;

import Data.Blocks.AirBlock;
import Data.Blocks.BreakableBlocks.GravelBlock;
import Data.Blocks.BreakableBlocks.SandBlock;
import Data.Blocks.Interfaces.block;
import Data.Blocks.SolidBlocks.EarthBlock;
import Data.Blocks.SolidBlocks.NullBlock;
import Data.Blocks.SolidBlocks.RawIronBlock;
import Data.Blocks.WaterBlock;

import java.util.Random;

public class FactoryBlock {

    ////////////////////////////////////////////////
    // VAR -----------------------------------------
    private static final int RAND_UPPERBOUND = 6;
    ////////////////////////////////////////////////
    // GETTER SETTER -------------------------------
    public AirBlock setAirBlock () {
        return new AirBlock();
    }
    public EarthBlock setEarthBlock () {
        return new EarthBlock();
    }
    public GravelBlock setGravelBlock () {
        return new GravelBlock();
    }
    public NullBlock setNullBlock () {
        return new NullBlock();
    }
    public RawIronBlock setRawIronBlock () {
        return new RawIronBlock();
    }
    public SandBlock setSandBlock () {
        return new SandBlock();
    }
    public WaterBlock setWaterBlock () {
        return new WaterBlock();
    }
    ////////////////////////////////////////////////
    // COSTRUCTORS ---------------------------------
    public FactoryBlock () {

    }
    ///////////////////////////////////////////////
    // METHODS ------------------------------------
    public block randomBlock () {
        Random rand = new Random();
        int r = rand.nextInt(RAND_UPPERBOUND);
        return switch (r) {
            case 0  -> this.setRawIronBlock();
            case 1  -> this.setSandBlock();
            case 2  -> this.setAirBlock();
            case 3  -> this.setNullBlock();
            case 4  -> this.setEarthBlock();
            case 5  -> this.setGravelBlock();
            default -> throw new IllegalStateException("Unexpected value: " + r);
        };
    }
    ///////////////////////////////////////////////
}
