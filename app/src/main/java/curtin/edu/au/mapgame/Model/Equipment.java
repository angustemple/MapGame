package curtin.edu.au.mapgame.Model;
import android.os.Parcel;
import android.os.Parcelable;

import java.util.*;

public class Equipment extends Item implements Parcelable
{
    // CONSTRUCTOR ---------------------------------------------------------------------------------
    public Equipment(String description, int value, double mass)
    {
        super(description, value, mass);
    }

    // ACCESSORS -----------------------------------------------------------------------------------

    // MUTATORS ------------------------------------------------------------------------------------
    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags)
    {
        out.writeString(super.description);
        out.writeInt(super.value);
        out.writeDouble(super.healthmass);
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
        super();
        super.description = in.readString();
        super.value = in.readInt();
        super.healthmass = in.readDouble();
    }
}