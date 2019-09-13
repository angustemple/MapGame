package curtin.edu.au.mapgame.Model;
import java.util.*;

public abstract class Item
{
    // CLASSFIELDS ---------------------------------------------------------------------------------
    protected String description;
    protected int value;
    protected double healthmass;

    // Default Constructor -------------------------------------------------------------------------
    public Item()
    {
        // Do nothing
    }

    // Constructor ---------------------------------------------------------------------------------
    public Item(String description, int value, double healthmass)
    {
        this.description = description;
        this.value = value;
        this.healthmass = healthmass;
    }

    // ACCESSORS -----------------------------------------------------------------------------------
    public String getDescription()
    {
        return description;
    }

    public int getValue()
    {
        return this.value;
    }

    public double getHealthMass()
    {
        return this.healthmass;
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

    public void setHealthmass(double healthmass)
    {
        this.healthmass = healthmass;
    }
}