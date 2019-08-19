package curtin.edu.au.mapgame.Model;
import java.util.*;

public class Equipment extends Item
{
    // CLASSFIELDS --------------------------------------------------------------------------------------
    private String description;
    private int value;
    private double mass;

    // ACCESSORS -----------------------------------------------------------------------------------
    public double getMass()
    {
        return this.mass;
    }

    // MUTATORS ------------------------------------------------------------------------------------
    public void setMass(double mass)
    {
        this.mass = mass;
    }
}