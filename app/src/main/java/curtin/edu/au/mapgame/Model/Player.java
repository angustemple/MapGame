package curtin.edu.au.mapgame.Model;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.*;

public class Player implements Parcelable
{
    // CLASSFIELDS --------------------------------------------------------------------------------------
    private int rowLocation;
    private int colLocation;
    private int cash;
    private double health;
    private double equipmentMass;
    private List<Equipment> equipmentList;

    // CONSTRUCTORS --------------------------------------------------------------------------------
    public Player()
    {
        this.rowLocation = 0;
        this.colLocation = 0;
        this.cash = 0;
        this.health = 100.00;
        this.equipmentMass = 0.00;
        this.equipmentList = new ArrayList<>();
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

    public int getEquipmentSize()
    {
        return this.equipmentList.size();
    }

    // MUTATORS ------------------------------------------------------------------------------------
    public void setCash(int cash)
    {
        this.cash = cash;
    }

    // SPECIFIC METHODS ----------------------------------------------------------------------------
    public boolean hasAllItems()
    {
        boolean monkey = false;
        boolean roadmap = false;
        boolean icescraper = false;

        for(Equipment item : equipmentList)
        {
            switch(item.getDescription())
            {
                case "Jade Monkey":
                    monkey = true;
                    break;
                case "Ice Scraper":
                    icescraper = true;
                    break;
                case "Road Map":
                    roadmap = true;
                    break;
            }
        }

        return(monkey && icescraper && roadmap);
    }

    public void addEquipment(Equipment newEquipment)
    {
        this.equipmentList.add(newEquipment);
        this.equipmentMass += newEquipment.getHealthMass();
    }

    public Equipment removeEquipment(int i)
    {
        Equipment equip = this.equipmentList.remove(i);
        this.equipmentMass -= equip.getHealthMass();
        return equip;
    }

    public Equipment viewEquipmentItem(int i)
    {
        return this.equipmentList.get(i);
    }

    public void consumeFood(Food inFood)
    {
        double hp = inFood.getHealthMass();
        this.health += hp;
        if(this.health > 100.00)
        {
            this.health = 100.00;
        }
    }

    public void moveNorth()
    {
        this.rowLocation--;
        this.health = Math.max(0.0, this.health - 5.0 - (equipmentMass / 2.0));
    }

    public void moveSouth()
    {
        this.rowLocation++;
        this.health = Math.max(0.0, this.health - 5.0 - (equipmentMass / 2.0));
    }

    public void moveEast()
    {
        this.colLocation++;
        this.health = Math.max(0.0, this.health - 5.0 - (equipmentMass / 2.0));
    }

    public void moveWest()
    {
        this.colLocation--;
        this.health = Math.max(0.0, this.health - 5.0 - (equipmentMass / 2.0));
    }

    // PARCELABLE METHODS --------------------------------------------------------------------------
    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags)
    {
        out.writeInt(rowLocation);
        out.writeInt(colLocation);
        out.writeInt(cash);
        out.writeDouble(health);
        out.writeDouble(equipmentMass);
        out.writeList(equipmentList);
    }

    public static final Parcelable.Creator<Player> CREATOR = new Parcelable.Creator<Player>(){
        public Player createFromParcel(Parcel in)
        {
            return new Player(in);
        }

        public Player[] newArray(int size)
        {
            return new Player[size];
        }
    };

    private Player(Parcel in)
    {
        rowLocation = in.readInt();
        colLocation = in.readInt();
        cash = in.readInt();
        health = in.readDouble();
        equipmentMass = in.readDouble();
        this.equipmentList = new ArrayList<>();
        in.readList(this.equipmentList, Equipment.class.getClassLoader());
    }
}