package Data.Blocks;

public class AirBlock extends AbstractBlock{
    public AirBlock () { //costruttore di blocco di default
        this.contenuto          = ' ';
        this.fall_through       = true;
        this.falls_with_gravity = false;
    };
    public AirBlock (char c, boolean f_t, boolean f_w) { //costruttore di blocco NON di default
        this.contenuto          = c;
        this.fall_through       = f_t;
        this.falls_with_gravity = f_w;
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
