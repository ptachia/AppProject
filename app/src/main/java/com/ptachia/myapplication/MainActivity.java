package com.ptachia.myapplication;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity  {

    Button area1, area2, deepness1, deepness2, cold1, cold2, level1, level2;
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

        area1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                areaF = new AreaScreen();
                android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().add(R.id.main_fragment, areaF).addToBackStack(null).commit();
            }
        });
    }
}
