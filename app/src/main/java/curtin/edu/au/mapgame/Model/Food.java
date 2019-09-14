package curtin.edu.au.mapgame.Model;

import android.os.Parcel;
import android.os.Parcelable;

public class Food extends Item implements Parcelable
{
    // CONSTRUCTOR ---------------------------------------------------------------------------------
    Food(String description, int value, double health)
    {
        super(description, value, health);
    }

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
        super();
        super.description = in.readString();
        super.value = in.readInt();
        super.healthmass= in.readDouble();
    }
}