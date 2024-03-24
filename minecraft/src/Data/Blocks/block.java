package Data.Blocks;

public interface block {

    boolean getFall_through ();
    boolean getFalls_with_gravity ();
    char display ();
    ////////////////////////////////////////////////////
    void setFall_through (boolean x);
    void setFalls_with_gravity (boolean x);
}
 // se facessi block A = new sottoclasse di AbstractBlock
 // allora A puo usare solo i metodi definiti nell'interfaccia block
