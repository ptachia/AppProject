package com.ptachia.myapplication;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity implements MainApp.inflateInterface {

    Button area1, area2, deepness1, deepness2, cold1, cold2, level1, level2;

    public static UserData userData = new UserData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
}
