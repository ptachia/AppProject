package com.ptachia.myapplication;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity  {

    Button area1, area2, deepness1, deepness2, cold1, cold2, level1, level2;
    Toolbar mToolbar;
    Fragment areaF, deepnessF, coldF, levelF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        area1 = findViewById(R.id.area1);
        area2 = findViewById(R.id.area2);
        deepness1 = findViewById(R.id.deepness1);
        deepness2 = findViewById(R.id.deepness2);
        cold1 = findViewById(R.id.cold1);
        cold2 = findViewById(R.id.cold2);
        level1 = findViewById(R.id.level1);
        level2 = findViewById(R.id.level2);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);

        area1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                areaF = new AreaScreen();
                android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().add(R.id.main_fragment, areaF).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_items, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //TODO fill it and verify that it affects on all the menus in all screens
        int id = item.getItemId();
        switch (id) {
            case R.id.share:
                break;
            case R.id.about:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
