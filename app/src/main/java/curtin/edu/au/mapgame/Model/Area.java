package curtin.edu.au.mapgame.Model;
import java.util.*;

public class Area
{
    // CLASSFIELDS ---------------------------------------------------------------------------------
    private boolean town;
    private List<Item> items;

    // CONSTRUCTOR ---------------------------------------------------------------------------------
    public Area()
    {
        this.town = false;
        this.items = new LinkedList<Item>();
    }

    // ACCESSORS -----------------------------------------------------------------------------------
    public boolean getTown()
    {
        return this.town;
    }

    public List<Item> getItems()
    {
        return this.items;
    }

    // MUTATORS ------------------------------------------------------------------------------------
    public void setTown(boolean town)
    {
        this.town = town;
    }

    public void setItems(List<Item> items)
    {
        this.items = items;
    }

    // SPECIFIC METHODS ----------------------------------------------------------------------------
    public void addItem(Item item)
    {
        items.add(item);
    }
}