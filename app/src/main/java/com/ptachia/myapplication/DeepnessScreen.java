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

public class DeepnessScreen extends Fragment {

    private SeekBar deepness_seekbar;
    private TextView deep_ibdicator;
    private Button cold_button, area_button, level_button, start_search, start_search1, start_search2;
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
        return inflater.inflate(R.layout.deepness_screen, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        deepness_seekbar = view.findViewById(R.id.seekbar);
        deep_ibdicator =  view.findViewById(R.id.deep_indicator);
        deepness_seekbar.setMax(100);
        deepness_seekbar.setProgress(MainActivity.userData.my_deepness);
        deepness_seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (progress == 0){MainActivity.userData.my_deepness = 0;}
                if (progress > 0 && progress <= 25) {
                    MainActivity.userData.my_deepness = 1;
                    deep_ibdicator.setText("" + "רדוד");

                }
                if (progress > 25 && progress <= 60){
                    MainActivity.userData.my_deepness = 2;
                    deep_ibdicator.setText("" + "בינוני");
                }
                if (progress > 60){
                    MainActivity.userData.my_deepness = 3;
                    deep_ibdicator.setText("" + "עמוק");
                }
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

        area_button = view.findViewById(R.id.third);
        area_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflate_listener.areaClicked(false);
            }
        });

        level_button = view.findViewById(R.id.second);
        level_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflate_listener.levelClicked(false);
            }
        });

        start_search = view.findViewById(R.id.start_search);
        start_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.userData.is_name_search = false;
                inflate_listener.getSearchClicked();
            }
        });
        start_search1 = view.findViewById(R.id.half_circle);
        start_search1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.userData.is_name_search = false;
                inflate_listener.getSearchClicked();
            }
        });
        start_search2 = view.findViewById(R.id.half_circle1);
        start_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.userData.is_name_search = false;
                inflate_listener.getSearchClicked();
            }
        });
    }

}
