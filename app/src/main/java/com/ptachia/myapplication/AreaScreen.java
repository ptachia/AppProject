package com.ptachia.myapplication;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class AreaScreen extends Fragment{

    Spinner israel_places;
    SeekBar radius;
    TextView radius_range_indicator;
    Button deepness_button, cold_button, level_button, continue1, continue2, start_search;
    MainApp.inflateInterface inflate_listener;

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
        return inflater.inflate(R.layout.area_screen, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // define seekbar
        radius = view.findViewById(R.id.seekbar);
        radius_range_indicator = view.findViewById(R.id.radiusIndicator);
        radius.setMax(100);
        radius.setProgress(MainActivity.userData.my_distance);
        radius_range_indicator.setText(""+MainActivity.userData.my_distance);
        radius.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                MainActivity.userData.my_distance = progress;
                radius_range_indicator.setText(""+MainActivity.userData.my_distance);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        // define spinner
        israel_places = view.findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(view.getContext(),
               R.array.places, R.layout.spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        israel_places.setAdapter(adapter);
        israel_places.setSelection(MainActivity.userData.my_area);
        israel_places.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                MainActivity.userData.my_area = position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        //enf of spinner

        // define buttons
        deepness_button = view.findViewById(R.id.third);
        deepness_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflate_listener.deepnessClicked(false);
            }
        });

        cold_button = view.findViewById(R.id.first);
        cold_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflate_listener.coldClicked(false);
            }
        });

        level_button = view.findViewById(R.id.second);
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
                inflate_listener.deepnessClicked(true);
            }
        });
        continue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflate_listener.deepnessClicked(true);
            }
        });

        start_search = view.findViewById(R.id.start_search);
        start_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflate_listener.getSpringClicked(true);
            }
        });

    }

}
