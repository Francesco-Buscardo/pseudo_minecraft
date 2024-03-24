package Data.Blocks;

abstract public class AbstractBlock implements block {
     char    contenuto;
     boolean falls_with_gravity,
             fall_through;
    ///////////////////////////////////////////////
    // GETTER SETTER ------------------------------
    abstract public void setFall_through (boolean x) ; /*{
        this.fall_through = x;
    };*/
    abstract public void setFalls_with_gravity (boolean x); /*{
        this.falls_with_gravity = x;
    };*/
    abstract public boolean getFall_through () ; /* {
        return this.fall_through;
    };*/
    abstract public boolean getFalls_with_gravity ();/* {
        return this.falls_with_gravity;
    };*/
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
