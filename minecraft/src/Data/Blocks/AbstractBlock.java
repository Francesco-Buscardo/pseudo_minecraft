package Data.Blocks;

import Data.Blocks.Interfaces.block;

abstract public class AbstractBlock implements block {
    ///////////////////////////////////////////////
    // VAR ----------------------------------------
    public char    contenuto;
    public boolean falls_with_gravity,
                   fall_through,
                   pickeable,
                   breakable;
    public String  blockName;
    ///////////////////////////////////////////////
    // CONSTRUCTOR --------------------------------
    public AbstractBlock () {
        this.pickeable = false;
    }
    ///////////////////////////////////////////////
    // GETTER SETTER ------------------------------
    public void setFall_through (boolean x) {
        this.fall_through = x;
    };
    public boolean getFall_through () {
        return this.fall_through;
    };
    public void setFalls_with_gravity (boolean x) {
        this.falls_with_gravity = x;
    };
    public boolean getFalls_with_gravity () {
        return this.falls_with_gravity;
    };
    public void  setBlockname (String blockname) {
        this.blockName = blockname;
    };
    public String getBlockname () {
        return this.blockName;
    };
    public void setPeackeable (boolean pickeable) {
        this.pickeable = pickeable;
    };
    public boolean getBreakable () {
        return this.breakable;
    }
    public void setBreakable(boolean breakable) {
        this.breakable = breakable;
    }

    ///////////////////////////////////////////////
    // METHODS ------------------------------------
    public char display () {
        return this.contenuto;
    };
    public String toString () {
        return "Il blocco " + this.blockName.toUpperCase() + " ha le seguenti proprietà: " + "\n" +
                "-> Falls whit gravity: " + this.falls_with_gravity + "\n" +
                "-> Falls through: " + this.fall_through;
    };
    public void  display_in_inventory () {
        System.out.println("[" + this.contenuto + "]");
    };
    public boolean is_pickable () {
        return (this.pickeable);
    }
    ///////////////////////////////////////////////
}
