package com.ptachia.myapplication;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity
        extends AppCompatActivity
        implements MainApp.inflateInterface {

    Button search;

    public static UserData userData = new UserData();

    @SuppressLint("StaticFieldLeak")
    private static Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mContext = getApplicationContext();
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        search = findViewById(R.id.search1);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText search_by_name = findViewById(R.id.editText);
                if (search_by_name.getVisibility() == View.GONE) {
                    search_by_name.setVisibility(View.VISIBLE);
                }
                else {
                    if (TextUtils.isEmpty((search_by_name.getText()))) {
                        search_by_name.setVisibility(View.GONE);
                    } else {
                        userData.spring_name = search_by_name.getText().toString().trim();
                        Pattern pattern = Pattern.compile("[a-zA-Z0-9]+"); // check only hebrew text
                        Matcher matcher = pattern.matcher(userData.spring_name);
                        if (matcher.find()) {
                            Toast.makeText(MainActivity.this,
                                    ""+"חיפוש לא תקין. נא להכניס אותיות עבריות בלבד",
                                    Toast.LENGTH_LONG).show();
                        } else {
                            search_by_name.setVisibility(View.GONE);
                            userData.is_name_search = true;
                            getSearchClicked();
                        }
                    }
                }
            }
        });

        ActivityCompat.requestPermissions(MainActivity.this,new String[]{
                Manifest.permission.ACCESS_FINE_LOCATION,
                Manifest.permission.ACCESS_COARSE_LOCATION,
                Manifest.permission.INTERNET},123);

        // update GPS
        GPStracker g = new GPStracker(getApplicationContext());
        Location l = g.getLocation();
        if (l != null) {
            userData.my_lat = l.getLatitude();
            userData.cur_lat = l.getLatitude();
            userData.my_lon = l.getLongitude();
            userData.cur_lon = l.getLongitude();
        }
        else { // just default for search
            userData.my_lat = userData.JERUSALEM_LAT;
            userData.cur_lat = userData.JERUSALEM_LAT;
            userData.my_lon = userData.JERUSALEM_LON;
            userData.cur_lon = userData.JERUSALEM_LON;

        }
        // finished update

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
    public void getSpringClicked() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main_fragment, new SpringScreen()).addToBackStack(null).commit();
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
    public void getSearchClicked(){
        updateGps();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.main_fragment, new SpringsListScreen()).addToBackStack(null).commit();
    }

    @Override
    public void getDirectionOnMap() {
        Intent handler_intent = new Intent(MainActivity.this, MapsActivity.class);
        startActivity(handler_intent);
    }



    public void updateGps() {
        GPStracker g = new GPStracker(getApplicationContext());
        Location l = g.getLocation();
        if (l != null) {
            userData.cur_lat = l.getLatitude();
            userData.cur_lon = l.getLongitude();
        }
        switch (userData.my_area) {
            case 0:break;
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
    }

    private void insertLatLon(double lat, double lon) {
        userData.my_lat = lat;
        userData.my_lon = lon;
    }

    public static Context getContext() {
        return mContext;
    }

    @Override
    public String levelToHebrew(int i) {
        switch (i){
            case 0: return "הכל";
            case 1: return "רכב";
            case 2: return "4x4";
            case 3: return "הליכה ברגל";
        }
        return "הכל";
    }

    @Override
    public String tempToHebrew(int i) {
        switch (i){
            case 0: return "הכל";
            case 1: return "חם";
            case 2: return "קר";
            case 3: return "קר מאוד";
        }
        return "הכל";
    }

    @Override
    public String areaToHebrew(int i) {
        switch (i){
            case 0:return "מיקום נוכחי";
            case 1:return "צפון הגולן";
            case 2:return "דרום הגולן";
            case 3:return "גליל עליון";
            case 4:return "גליל תחתון";
            case 5:return "עמק יזרעאל";
            case 6:return "בית שאן";
            case 7:return "כרמל";
            case 8:return "מישור החוף";
            case 9:return "שומרון ובנימין";
            case 10:return "הרי ירושלים";
            case 11:return "הרי יהודה";
            case 12:return "ים המלח";
            case 13:return "מצפה רמון";
            case 14:return "שדה בוקר";
            case 15:return "אילת";
        }
        return "המיקום הנוכחי";
    }

    @Override
    public String deepToHebrew(int i) {
        switch (i){
            case 0: return "הכל";
            case 1: return "רדוד";
            case 2: return "בינוני";
            case 3: return "עמוק";
        }
        return "הכל";
    }
}
