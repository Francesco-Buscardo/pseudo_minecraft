package Data.Blocks;

public class AirBlock extends AbstractBlock {

    public AirBlock () { //costruttore di blocco di default
        super();
        this.contenuto          = ' ';
        this.fall_through       = true;
        this.falls_with_gravity = false;
        this.blockName          = "Air Block";
    };
    ////////////////////////////////////////////////////
}
