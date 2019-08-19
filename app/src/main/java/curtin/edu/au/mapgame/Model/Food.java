package curtin.edu.au.mapgame.Model;

import java.util.*;

public class Food extends Item
{
    // CLASSFIELDS --------------------------------------------------------------------------------------
    private String description;
    private int value;
    private double health;

    // ACCESSORS -----------------------------------------------------------------------------------
    public double getHealth()
    {
        return this.health;
    }

    // MUTATORS ------------------------------------------------------------------------------------
    public void setHealth(double health)
    {
        this.health = health;
    }
}