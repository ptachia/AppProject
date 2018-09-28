package com.ptachia.myapplication;

public class DataForSearch {

    double lat, lon;
    int distance, level, deepness, temperature;

    public DataForSearch(){
        lat = MainActivity.userData.my_lat;
        lon = MainActivity.userData.my_lon;
        distance = MainActivity.userData.my_distance;
        level = MainActivity.userData.my_level;
        deepness = MainActivity.userData.my_deepness;
        temperature = MainActivity.userData.my_temprature;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public int getDistance() {
        return distance;
    }

    public int getLevel() {
        return level;
    }

    public int getDeepness() {
        return deepness;
    }

    public int getTemperature() {
        return temperature;
    }
}
