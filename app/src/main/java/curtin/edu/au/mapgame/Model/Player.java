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
        this.equipmentList = new ArrayList<Equipment>();
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

    public Equipment getEquipmentItem(int i)
    {
        return this.equipmentList.get(i);
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
        this.equipmentMass += newEquipment.getHealthMass();
    }

    public Equipment removeEquipment(int i)
    {
        Equipment equip = this.equipmentList.remove(i);
        this.equipmentMass -= equip.getHealthMass();
        return equip;
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
        this.equipmentList = new ArrayList<Equipment>();
        in.readList(this.equipmentList, Equipment.class.getClassLoader());
    }
}