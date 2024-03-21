package Data.Blocks;

public interface block {

    boolean getFall_through ();
    boolean getFalls_with_gravity ();
    char display ();
}
 // se facessi block A = new sottoclasse di AbstractBlock
 // allora A puo usare solo i metodi definiti nell'interfaccia block