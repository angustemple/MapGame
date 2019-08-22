package curtin.edu.au.mapgame.Model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.*;

public class Food extends Item implements Parcelable
{
    // CLASSFIELDS ---------------------------------------------------------------------------------
    private String description;
    private int value;
    private double health;

    // CONSTRUCTOR ---------------------------------------------------------------------------------
    public Food(String description, int value, double health)
    {
        this.description = description;
        this.value = value;
        this.health = health;
    }
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

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags)
    {
        out.writeString(description);
        out.writeInt(value);
        out.writeDouble(health);
    }

    public static final Parcelable.Creator<Food> CREATOR = new Parcelable.Creator<Food>(){
        public Food createFromParcel(Parcel in)
        {
            return new Food(in);
        }

        public Food[] newArray(int size)
        {
            return new Food[size];
        }
    };

    private Food(Parcel in)
    {
        description = in.readString();
        value = in.readInt();
        health = in.readDouble();
    }
}