package curtin.edu.au.mapgame.Model;
import android.os.Parcel;
import android.os.Parcelable;

import java.lang.reflect.Array;
import java.util.*;

public class Area implements Parcelable
{
    // CLASSFIELDS ---------------------------------------------------------------------------------
    private boolean town;
    private List<Item> items;

    // CONSTRUCTOR ---------------------------------------------------------------------------------
    public Area()
    {
        this.town = false;
        this.items = new ArrayList<Item>();
    }

    // ACCESSORS -----------------------------------------------------------------------------------
    public boolean getTown()
    {
        return this.town;
    }

    public List<Item> getItems()
    {
        return this.items;
    }

    public int getItemSize()
    {
        return this.items.size();
    }

    // MUTATORS ------------------------------------------------------------------------------------
    public void setTown(boolean town)
    {
        this.town = town;
    }

    public void setItems(List<Item> items)
    {
        this.items = items;
    }

    // SPECIFIC METHODS ----------------------------------------------------------------------------
    public void addItem(Item item)
    {
        items.add(item);
    }

    public Item getItem(int i)
    {
        return items.get(i);
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
        out.writeInt(town ? 1 : 0);
        out.writeList(items);
    }

    public static final Parcelable.Creator<Area> CREATOR = new Parcelable.Creator<Area>(){
        public Area createFromParcel(Parcel in)
        {
            return new Area(in);
        }

        public Area[] newArray(int size)
        {
            return new Area[size];
        }
    };

    private Area(Parcel in)
    {
        this.town = in.readInt() == 1;
        this.items = new ArrayList<Item>();
        in.readList(this.items, Item.class.getClassLoader());
    }
}