package Data.Blocks.Interfaces;

public interface block extends InventoryBlock {
    ////GETTER/OTHERS/////////////////////////////////////////
    boolean getFall_through ();
    boolean getFalls_with_gravity ();
    String getBlockname () ;
    boolean getBreakable ();
    char display ();
    String toString ();
    boolean is_pickable ();
}