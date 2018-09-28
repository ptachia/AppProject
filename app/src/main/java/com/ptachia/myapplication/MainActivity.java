package com.ptachia.myapplication;

import android.Manifest;
import android.content.Context;
import android.location.Location;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity
        extends AppCompatActivity
        implements MainApp.inflateInterface {

    Button area1, area2, deepness1, deepness2, cold1, cold2, level1, level2;

    TextView textView; //todo remove

    public static UserData userData = new UserData();
    private static Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mContext = getApplicationContext();
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(MainActivity.this,new String[]{
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.INTERNET},123);
        // update GPS
        GPStracker g = new GPStracker(getApplicationContext());
        Location l = g.getLocation();
        if (l != null) {
            userData.my_lat = l.getLatitude();
            userData.my_lon = l.getLongitude();
        }
        // finished update

//        textView = findViewById(R.id.textView);//todo remove
//        textView.setText("testText"+userData.my_lat);//todo remove

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main_fragment, new MainApp()).addToBackStack(null).commit();
    }


    @Override
    public void coldClicked(boolean addToStack) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (addToStack){
            ft.replace(R.id.main_fragment, new ColdScreen()).addToBackStack(null).commit();
        } else {
            ft.replace(R.id.main_fragment, new ColdScreen()).commit();
        }
    }

    @Override
    public void levelClicked(boolean addToStack) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (addToStack){
            ft.replace(R.id.main_fragment, new LevelScreen()).addToBackStack(null).commit();
        } else {
            ft.replace(R.id.main_fragment, new LevelScreen()).commit();
        }
    }

    @Override
    public void areaClicked(boolean addToStack) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (addToStack){
            ft.replace(R.id.main_fragment, new AreaScreen()).addToBackStack(null).commit();
        } else {
            ft.replace(R.id.main_fragment, new AreaScreen()).commit();
        }
    }

    @Override
    public void deepnessClicked(boolean addToStack) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (addToStack){
            ft.replace(R.id.main_fragment, new DeepnessScreen()).addToBackStack(null).commit();
        } else {
            ft.replace(R.id.main_fragment, new DeepnessScreen()).commit();
        }
    }

    @Override
    public void getSpringClicked(boolean addToStack){
        updateGps();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (addToStack){
            ft.replace(R.id.main_fragment, new SpringsListScreen()).addToBackStack(null).commit();
        } else {
            ft.replace(R.id.main_fragment, new SpringsListScreen()).commit();
        }
    }

    public void updateGps() {
        switch (userData.my_area) {
            case 0:
                GPStracker g = new GPStracker(getApplicationContext());
                Location l = g.getLocation();
                if (l != null) {
                    insertLatLon(l.getLatitude(), l.getLongitude());
                }
                break;
            case 1:insertLatLon(userData.NORTH_GOLAN_LAT, userData.NORTH_GOLAN_LON); break;
            case 2:insertLatLon(userData.SOUTH_GOLAN_LAT, userData.SOUTH_GOLAN_LON); break;
            case 3:insertLatLon(userData.GALIL_E_LAT, userData.GALIL_E_LON); break;
            case 4:insertLatLon(userData.GALIL_T_LAT, userData.GALIL_T_LON); break;
            case 5:insertLatLon(userData.IZRAEL_LAT, userData.IZRAEL_LON); break;
            case 6:insertLatLon(userData.BET_SHEAN_LAT, userData.BET_SHEAN_LON); break;
            case 7:insertLatLon(userData.CARMEL_LAT, userData.CARMEL_LON); break;
            case 8:insertLatLon(userData.MISHOR_HAHOF_LAT, userData.MISHOR_HAHOF_LON); break;
            case 9:insertLatLon(userData.SHOMRON_LAT, userData.SHOMRON_LON); break;
            case 10:insertLatLon(userData.JERUSALEM_LAT, userData.JERUSALEM_LON); break;
            case 11:insertLatLon(userData.HAREY_YEHUDA_LAT, userData.HAREY_YEHUDA_LON); break;
            case 12:insertLatLon(userData.YAM_HAMELAH_LAT, userData.YAM_HAMELAH_LON); break;
            case 13:insertLatLon(userData.RAMON_LAT, userData.RAMON_LON); break;
            case 14:insertLatLon(userData.BOKER_LAT, userData.BOKER_LON); break;
            case 15:insertLatLon(userData.ELAT_LAT, userData.ELAT_LON); break;

        }
        textView.setText("testText" + userData.my_lat);//todo remove
    }

    public DataForSearch makeDataInstance(){
        return new DataForSearch();
    }

    private void insertLatLon(double lat, double lon) {
        userData.my_lat = lat;
        userData.my_lon = lon;
    }

    public static Context getContext() {
        return mContext;
    }
}
