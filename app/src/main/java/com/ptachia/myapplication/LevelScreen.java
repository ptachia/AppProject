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

public class LevelScreen extends Fragment {

    private SeekBar level_seekbar;
    private TextView level_indicator;
    private Button cold_button, area_button, deepness_button, continue1, continue2, start_search;
    private MainApp.inflateInterface inflate_listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            inflate_listener = (MainApp.inflateInterface) context;
        } catch (ClassCastException e){
            throw new ClassCastException(context.toString());
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.level_screen, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        level_seekbar = view.findViewById(R.id.seekbar3);
        level_indicator = view.findViewById(R.id.level_indicator);
        level_seekbar.setMax(100);
        level_seekbar.setProgress(userData.my_level_helper);
        putText(userData.my_level_helper);
        level_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                userData.my_level_helper = progress;
                putText(progress);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        cold_button = view.findViewById(R.id.first);
        cold_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflate_listener.coldClicked(false);
            }
        });

        area_button = view.findViewById(R.id.second);
        area_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflate_listener.areaClicked(false);
            }
        });

        deepness_button = view.findViewById(R.id.third);
        deepness_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflate_listener.deepnessClicked(false);
            }
        });

        continue1 = view.findViewById(R.id.half_circle);
        continue2 = view.findViewById(R.id.half_circle1);
        continue1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflate_listener.areaClicked(true);
            }
        });
        continue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflate_listener.areaClicked(true);
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
            userData.my_level = 0;
            level_indicator.setText(""+"קליל/קשוח");
        }
        if (progress > 0 && progress <= 45) {
            userData.my_level = 1;
            if (progress <= 20){
                level_indicator.setText("" + "משפחתי קליל");
            }
            else {
                level_indicator.setText("" + "משפחתי קל");
            }
        }
        if (progress > 45 && progress <= 80){
            userData.my_level = 2;
            level_indicator.setText("" + "4X4");
        }
        if (progress > 80){
            userData.my_level = 3;
            level_indicator.setText(""+"לוחם סיירת");
        }
    }

}
