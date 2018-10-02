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
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class SpringScreen extends Fragment {

    private static final String BASE_URL = "https://ppc1.herokuapp.com/";

    ImageView spring_image;
    Button cold_button, level_button, area_button, deepness_button, nav1, nav2;
    TextView spring_name, spring_description, level_choice, temp_choice, area_choice, deep_choice;
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
        return inflater.inflate(R.layout.spring_screen, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        spring_description = view.findViewById(R.id.description);
        spring_description.setText(MainActivity.userData.spring_data);
        spring_name = view.findViewById(R.id.spring_name);
        spring_name.setText(MainActivity.userData.spring_name);

        level_choice = view.findViewById(R.id.level_choice);
        temp_choice = view.findViewById(R.id.temp_choice);
        area_choice = view.findViewById(R.id.area_choice);
        deep_choice = view.findViewById(R.id.deep_choice);
        if (!MainActivity.userData.is_name_search) {
            level_choice.setText(String.format("%s", inflate_listener.levelToHebrew(MainActivity.userData.my_level)));
            temp_choice.setText(String.format("%s", inflate_listener.tempToHebrew(MainActivity.userData.my_temprature)));
            area_choice.setText(String.format("%s", inflate_listener.areaToHebrew(MainActivity.userData.my_area)));
            deep_choice.setText(String.format("%s", inflate_listener.deepToHebrew(MainActivity.userData.my_deepness)));
        }

        spring_image = view.findViewById(R.id.spring_picture);
        Picasso.
                with(MainActivity.getContext()).
                load(BASE_URL + "img?id=MayanKAY" + MainActivity.userData.spring_img_id+ ".jpg")
                .resize(1080,582)
                .into(spring_image, new Callback() {
                    @Override
                    public void onSuccess() {
                        System.out.println("success on loading spring img");
                    }

                    @Override
                    public void onError() {
                        System.out.println("failure on loading spring img");
                    }
                });

        cold_button = view.findViewById(R.id.temprature);
        cold_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflate_listener.coldClicked(false);
            }
        });
        area_button = view.findViewById(R.id.area);
        area_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflate_listener.areaClicked(false);
            }
        });
        deepness_button = view.findViewById(R.id.deepness);
        deepness_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflate_listener.deepnessClicked(false);
            }
        });
        level_button = view.findViewById(R.id.level);
        level_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflate_listener.levelClicked(false);
            }
        });
        
        
        nav1 = view.findViewById(R.id.navigate1);
        nav2 = view.findViewById(R.id.navigate2);
        nav1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflate_listener.getDirectionOnMap();
            }
        });
        nav2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflate_listener.getDirectionOnMap();
            }
        });
    }
}
