package com.example.apps4kids.printlikeaproapp;

/**
 * Created by Jonathan on 2015-06-13.
 */
public class DatabaseHelper {

    int _id;
    String _name;
    String _checkPoint;

    public DatabaseHelper() {

    }

    public DatabaseHelper(String name, String checkPoint) {
        this._name = name;
        this._checkPoint = checkPoint;
    }

    public DatabaseHelper(int id, String name, String checkPoint) {
        this._id = id;
        this._name = name;
        this._checkPoint = checkPoint;
    }

    public int getID() {
        return this._id;
    }

    public void setID (int id) {
        this._id = id;
    }

    public String getName() {
        return this._name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public String get_checkPoint() {
        return this._checkPoint;
    }

    public void setcheckPoint(String checkPoint) {
        this._checkPoint = checkPoint;
    }

    public String toString()
    {
        return getName()+" "+get_checkPoint();
    }


}
