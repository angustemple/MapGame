package curtin.edu.au.mapgame.Model;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.*;

public class Equipment extends Item implements Parcelable
{

    // CLASSFIELDS ---------------------------------------------------------------------------------
    private String description;
    private int value;
    private double mass;

    // CONSTRUCTOR ---------------------------------------------------------------------------------
    public Equipment(String description, int value, double mass)
    {
        this.description = description;
        this.value = value;
        this.mass = mass;
    }

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
        out.writeDouble(mass);
    }

    public static final Parcelable.Creator<Equipment> CREATOR = new Parcelable.Creator<Equipment>(){
        public Equipment createFromParcel(Parcel in)
        {
            return new Equipment(in);
        }

        public Equipment[] newArray(int size)
        {
            return new Equipment[size];
        }
    };

    private Equipment(Parcel in)
    {
        description = in.readString();
        value = in.readInt();
        mass = in.readDouble();
    }
}