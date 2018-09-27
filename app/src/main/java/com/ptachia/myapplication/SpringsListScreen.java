package com.ptachia.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

public class SpringsListScreen extends Fragment {

    private Button tempParam, difficultParam, deepParam, areaParam;
    private MainApp.inflateInterface inflate_listener;
    private List<SpringItem> springsList = new ArrayList<>();
    private RecyclerView recyclerView;
    private SpringsAdapter mAdapter;

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            inflate_listener = (MainApp.inflateInterface) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.springs_choose, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = (RecyclerView) view.findViewById(R.id.rvSprings);
        mAdapter = new SpringsAdapter(springsList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(MainActivity.getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        prepareSpringsData();
    }

    private void prepareSpringsData(){
        String path;
        SpringItem springItem;

        path = "C:\\NitzanApp\\AppProject\\app\\src\\main\\res\\mipmap-xxhdpi\\app_mayan_logo_01.png";
        springItem = new SpringItem("סתם מעין","מעין חמוד ונחמד שאוהב את כל אחד",path);
        springsList.add(springItem);

        path = "C:\\NitzanApp\\AppProject\\app\\src\\main\\res\\mipmap-xxhdpi\\bird.png";
        springItem = new SpringItem("סתם מעין2","מעין חמוד ונחמד שאוהב את כל אחד",path);
        springsList.add(springItem);

        path = "C:\\NitzanApp\\AppProject\\app\\src\\main\\res\\mipmap-xxhdpi\\bird.png";
        springItem = new SpringItem("סתם מעין23","מעין חמוד ונחמד שאוהב את כל אחד",path);
        springsList.add(springItem);

        path = "C:\\NitzanApp\\AppProject\\app\\src\\main\\res\\mipmap-xxhdpi\\bird.png";
        springItem = new SpringItem("סתם מעין342","מעין חמוד ונחמד שאוהב את כל אחד",path);
        springsList.add(springItem);

        path = "C:\\NitzanApp\\AppProject\\app\\src\\main\\res\\mipmap-xxhdpi\\bird.png";
        springItem = new SpringItem("סתם מעין3432","מעין חמוד ונחמד שאוהב את כל אחד",path);
        springsList.add(springItem);

        path = "C:\\NitzanApp\\AppProject\\app\\src\\main\\res\\mipmap-xxhdpi\\bird.png";
        springItem = new SpringItem("סתם מעין33332","מעין חמוד ונחמד שאוהב את כל אחד",path);
        springsList.add(springItem);

        mAdapter.notifyDataSetChanged();
    }
}
