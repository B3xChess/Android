package fr.snak.chess.Models;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by sylvain on 03/05/2016.
 */
public class Player implements Parcelable {
    private String name;
    private int color; //type

    public Player() {
    }

    public Player(String name, int color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    //Parcelable
    public Player(Parcel in) {
        this.name = in.readString();
        this.color = in.readInt();
    }

    public static final Parcelable.Creator<Player> CREATOR
            = new Parcelable.Creator<Player>() {
        public Player createFromParcel(Parcel in) {
            //System.out.println("IN : " + in);
            return new Player(in);
            //return new Player(name,color);
            //return null;
        }

        public Player[] newArray(int size) {
            return new Player[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        //out.writeInt(mData);
        out.writeString(name);
        out.writeInt(color);

    }

}
