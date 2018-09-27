package com.ptachia.myapplication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

public class SpringScreen extends Fragment {

    ImageView spring_image;
    Button cold_button, level_button, area_button, deepness_button, nav1, nav2;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.deepness_screen, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        cold_button = view.findViewById(R.id.temprature);
        level_button = view.findViewById(R.id.level);
        area_button = view.findViewById(R.id.area);
        deepness_button = view.findViewById(R.id.deepness);

        nav1 = view.findViewById(R.id.navigate1);
        nav2 = view.findViewById(R.id.navigate2);

        spring_image = view.findViewById(R.id.spring_picture);



    }

}
