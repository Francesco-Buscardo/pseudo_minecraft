package Data.Blocks;

public class WaterBlock extends AbstractBlock {
    public WaterBlock () {
        this.contenuto          = '=';
        this.fall_through       = true;
        this.falls_with_gravity = true;
    };
}
