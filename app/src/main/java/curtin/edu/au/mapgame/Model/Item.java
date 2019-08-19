package curtin.edu.au.mapgame.Model;
import java.util.*;

public abstract class Item
{
    // CLASSFIELDS --------------------------------------------------------------------------------------
    private String description;
    private int value;

    // ACCESSORS -----------------------------------------------------------------------------------
    public String getDescription()
    {
        return this.description;
    }

    public int getValue()
    {
        return this.value;
    }

    // MUTATORS ------------------------------------------------------------------------------------
    public void setDescription(String description)
    {
        this.description = description;
    }

    public void setValue(int value)
    {
        this.value = value;
    }
}