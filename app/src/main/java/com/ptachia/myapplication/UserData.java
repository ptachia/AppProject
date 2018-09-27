package com.ptachia.myapplication;

public class UserData {

    public int my_area;

    public int my_distance;

    public int my_level;

    public int my_deepness;

    public int my_temprature;

    public UserData(){
        my_area = 0;
        // 0 means "my location", 1 means "צפון הגולן ואצבע הגלל" and so on...

        my_distance = 30;
        // default is 30 km radius around "my_area", changed on area_screen seekbar

        my_level = 0;
        // there are 4 levels (0 to 3). default 0 means - search all the levels.

        my_deepness = 0;
        // there are 4 deep levels (0 to 3). default 0 means - search all the levels.

        my_temprature = 0;
        // there are 4 temperature levels (0 to 3). default 0 means - search all the levels.

    }


}
