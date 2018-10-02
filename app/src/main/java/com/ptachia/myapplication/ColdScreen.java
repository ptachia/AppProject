package com.ptachia.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import static com.ptachia.myapplication.MainActivity.*;
import static com.ptachia.myapplication.MainActivity.userData;

public class ColdScreen extends Fragment {

    private SeekBar temprature_seekbar;
    private TextView temp_indicator;
    private Button deepness_button, area_button, level_button, continue1, continue2, start_search;
    private MainApp.inflateInterface inflate_listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            inflate_listener = (MainApp.inflateInterface) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString());
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.cold_screen, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        temprature_seekbar = view.findViewById(R.id.seekbar1);
        temp_indicator = view.findViewById(R.id.temp_indicator);
        temprature_seekbar.setMax(100);
        temprature_seekbar.setProgress(userData.my_temprature_helper);
        putText(userData.my_temprature_helper);
        temprature_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                userData.my_temprature_helper = progress;
                putText(progress);

            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        deepness_button = view.findViewById(R.id.third);
        deepness_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflate_listener.deepnessClicked(false);
            }
        });

        area_button = view.findViewById(R.id.second);
        area_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflate_listener.areaClicked(false);
            }
        });

        level_button = view.findViewById(R.id.first);
        level_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflate_listener.levelClicked(false);
            }
        });

        continue1 = view.findViewById(R.id.half_circle);
        continue2 = view.findViewById(R.id.half_circle1);
        continue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflate_listener.levelClicked(true);
            }
        });
        continue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflate_listener.levelClicked(true);
            }
        });

        start_search = view.findViewById(R.id.start_search);
        start_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                userData.is_name_search = false;
                inflate_listener.getSearchClicked();
            }
        });
    }

    private void putText(int progress) {
        if (progress == 0){
            userData.my_temprature = 0;
            temp_indicator.setText(""+"חם/קר");}
        if (progress > 0 && progress <= 15) {
            userData.my_temprature = 1;
            temp_indicator.setText(""+"קפוא");

        }
        if (progress > 15 && progress <= 85){
            userData.my_temprature = 2;
            if (progress <= 30){
                temp_indicator.setText(""+"קר מאוד");}
            else if (progress <= 60){
                temp_indicator.setText(""+"קר");}
            else{
                temp_indicator.setText(""+"נעים");}
        }
        if (progress > 85){
            userData.my_temprature = 3;
            if (progress <= 95){
                temp_indicator.setText(""+"חם");}
            else {
                temp_indicator.setText(""+"לוהט");}
        }
    }

}
