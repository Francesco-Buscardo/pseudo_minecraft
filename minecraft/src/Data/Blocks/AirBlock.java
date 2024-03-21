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
}
