package curtin.edu.au.mapgame.Model;
import java.util.*;

public class Player
{
    // CLASSFIELDS --------------------------------------------------------------------------------------
    private int rowLocation;
    private int colLocation;
    private int cash;
    private double health;
    private double equipmentMass;
    private List<Equipment> equipmentList;

    // CONSTRUCTORS --------------------------------------------------------------------------------
    public Player(int rowLocation, int colLocation, int cash, double health, double equipmentMass,
                  List<Equipment> equipmentList)
    {
        this.rowLocation = rowLocation;
        this.colLocation = colLocation;
        this.cash = cash;
        this.health = health;
        this.equipmentMass = equipmentMass;
        this.equipmentList = equipmentList;
    }

    public Player()
    {
        this.rowLocation = 0;
        this.colLocation = 0;
        this.cash = 0;
        this.health = 100.00;
        this.equipmentMass = 0.00;
        this.equipmentList = new LinkedList<Equipment>();
    }

    // ACCESSORS -----------------------------------------------------------------------------------
    public int getRowLocation()
    {
        return this.rowLocation;
    }

    public int getColLocation()
    {
        return this.colLocation;
    }

    public int getCash()
    {
        return this.cash;
    }

    public double getHealth()
    {
        return this.health;
    }

    public double getEquipmentMass()
    {
        return this.equipmentMass;
    }

    public List<Equipment> getEquipmentList()
    {
        return this.equipmentList;
    }

    // MUTATORS ------------------------------------------------------------------------------------
    public void setRowLocation(int rowLocation)
    {
        this.rowLocation = rowLocation;
    }

    public void setColLocation(int colLocation)
    {
        this.colLocation = colLocation;
    }

    public void setCash(int cash)
    {
        this.cash = cash;
    }

    public void setHealth(double health)
    {
        this.health = health;
    }

    public void setEquipmentMass(double equipmentMass)
    {
        this.equipmentMass = equipmentMass;
    }

    public void setEquipmentList(List<Equipment> equipmentList)
    {
        this.equipmentList = equipmentList;
    }

    // SPECIFIC METHODS ----------------------------------------------------------------------------
    public void addEquipment(Equipment newEquipment)
    {
        this.equipmentList.add(newEquipment);
    }
}