package com.ptachia.myapplication;

import java.util.ArrayList;
import java.util.List;

public class UserData {

    public double NORTH_GOLAN_LAT = 33.13456;
    public double NORTH_GOLAN_LON = 35.67363;

    public double SOUTH_GOLAN_LAT = 32.92271;
    public double SOUTH_GOLAN_LON = 35.65716;

    public double GALIL_E_LAT = 32.95786;
    public double GALIL_E_LON = 35.2843;

    public double GALIL_T_LAT = 32.74527;
    public double GALIL_T_LON = 35.3718;

    public double IZRAEL_LAT = 32.59963;
    public double IZRAEL_LON = 35.28176;

    public double BET_SHEAN_LAT = 32.49871;
    public double BET_SHEAN_LON = 35.49925;

    public double CARMEL_LAT = 32.724;
    public double CARMEL_LON = 35.03855;

    public double MISHOR_HAHOF_LAT = 32.32706;
    public double MISHOR_HAHOF_LON = 34.859;

    public double SHOMRON_LAT = 32.15049;
    public double SHOMRON_LON = 35.24536;

    public double JERUSALEM_LAT = 31.77359;
    public double JERUSALEM_LON = 35.21858;

    public double HAREY_YEHUDA_LAT = 31.51942;
    public double HAREY_YEHUDA_LON = 35.10805;

    public double YAM_HAMELAH_LAT = 31.443;
    public double YAM_HAMELAH_LON = 35.31714;

    public double RAMON_LAT = 30.61122;
    public double RAMON_LON = 34.79939;

    public double BOKER_LAT = 30.85274;
    public double BOKER_LON = 34.78279;

    public double ELAT_LAT = 29.59282;
    public double ELAT_LON = 34.92889;

    public int my_area; // number between 0-15. 0 means "my location", 1-15 represent search in other areas (1 means "צפון הגולן ואצבע הגלל" and so on...)
    public double my_lat; // latitude of "my_area" choice just for search (not for navigate)
    public double my_lon; // latitude of "my_area" choice just for search (not for navigate)

    public double cur_lat; // always shows user location
    public double cur_lon; // always shows user location

    public double my_dest_lat; // will show the dest spring, will be updated after user spring choice
    public double my_dest_lon; // will show the dest spring, will be updated after user spring choice

    public int my_distance;  // default is 30 km radius around "my_area", changed on area_screen seekbar

    public int my_level; // there are 4 levels (0 to 3). default 0 means - search all the levels.
    public int my_level_helper;

    public int my_deepness; // there are 4 deep levels (0 to 3). default 0 means - search all the levels.
    public int my_deepness_helper;

    public int my_temprature; // there are 4 temperature levels (0 to 3). default 0 means - search all the levels.
    public int my_temprature_helper;

    String spring_name;
    String spring_data;
    Integer spring_img_id;

    boolean is_name_search = false;

    UserData(){


            my_area = 0;
//        // 0 means "my location", 1 means "צפון הגולן ואצבע הגלל" and so on...
//
            my_distance = 30;
//        // default is 30 km radius around "my_area", changed on area_screen seekbar
//
            my_level = 0;
            my_level_helper = 0;
//        // there are 4 levels (0 to 3). default 0 means - search all the levels.
//
            my_deepness = 0;
            my_deepness_helper = 0;
//        // there are 4 deep levels (0 to 3). default 0 means - search all the levels.
//
            my_temprature = 0;
            my_temprature_helper = 0;
//        // there are 4 temperature levels (0 to 3). default 0 means - search all the levels.


    }
}
