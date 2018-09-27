package com.ptachia.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.ViewGroup;

public class MainApp extends Fragment {

    Button area1, area2, deepness1, deepness2, cold1, cold2, level1, level2, start_search1, start_search2;
    inflateInterface inflate_listener;

    public interface inflateInterface{
        public void coldClicked(boolean addToStack);
        public void levelClicked(boolean addToStack);
        public void areaClicked(boolean addToStack);
        public void deepnessClicked(boolean addToStack);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            inflate_listener = (inflateInterface) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString());
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.main_app, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        area1 = view.findViewById(R.id.area1);
        area1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflate_listener.areaClicked(true);
            }
        });
        area2 = view.findViewById(R.id.area2);
        area2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflate_listener.areaClicked(true);
            }
        });

        deepness1 = view.findViewById(R.id.deepness1);
        deepness1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflate_listener.deepnessClicked(true);
            }
        });
        deepness2 = view.findViewById(R.id.deepness2);
        deepness2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflate_listener.deepnessClicked(true);
            }
        });

        cold1 = view.findViewById(R.id.cold1);
        cold1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflate_listener.coldClicked(true);
            }
        });
        cold2 = view.findViewById(R.id.cold2);
        cold2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflate_listener.coldClicked(true);
            }
        });

        level1 = view.findViewById(R.id.level1);
        level1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflate_listener.levelClicked(true);
            }
        });
        level2 = view.findViewById(R.id.level2);
        level2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflate_listener.levelClicked(true);
            }
        });

        start_search1 = view.findViewById(R.id.start_search);
        start_search2 = view.findViewById(R.id.start_search1);


    }
}
