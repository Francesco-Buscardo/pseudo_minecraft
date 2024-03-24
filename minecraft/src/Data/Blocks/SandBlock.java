package Data.Blocks;

public class SandBlock extends AbstractBlock {
    public SandBlock () {
        this.contenuto          = '$';
        this.fall_through       = false;
        this.falls_with_gravity = true;
    };
    ////////////////////////////////////////////////////
    @Override
    public void setFall_through (boolean x) {
        this.fall_through = x;
    };
    @Override
    public boolean getFall_through () {
        return this.fall_through;
    };
    @Override
    public void setFalls_with_gravity (boolean x) {
        this.falls_with_gravity = x;
    };
    @Override
    public boolean getFalls_with_gravity () {
        return this.falls_with_gravity;
    };
}
