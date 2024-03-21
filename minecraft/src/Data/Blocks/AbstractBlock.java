package Data.Blocks;

public class AbstractBlock implements block {
     char    contenuto;
     boolean falls_with_gravity,
             fall_through;

    ///////////////////////////////////////////////
    // GETTER SETTER ------------------------------
    public void setFall_through (boolean x) {          //setter getter servono per settare ed ridare il valore
        this.fall_through = x;                         //delle variabili che sono private
    };
    public void setFalls_with_gravity (boolean x) {
        this.falls_with_gravity = x;
    };
    public boolean getFall_through () {
        return this.fall_through;
    };
    public boolean getFalls_with_gravity () {
        return this.falls_with_gravity;
    };
    ///////////////////////////////////////////////
    // COSTRUCTORS --------------------------------
    // SONO NEI FIGLI CHE SAREBBE I VARI TIPI DI BLOCCHI
    ///////////////////////////////////////////////
    // METHODS ------------------------------------
    public char display () {
        return this.contenuto;
    };
    ///////////////////////////////////////////////
}
