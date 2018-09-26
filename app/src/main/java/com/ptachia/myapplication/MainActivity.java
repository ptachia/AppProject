package com.ptachia.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button area1, area2, deepness1, deepness2, cold1, cold2, level1, level2;

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
    }
}
