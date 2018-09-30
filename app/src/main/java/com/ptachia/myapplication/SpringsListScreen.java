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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SpringsListScreen extends Fragment {

    private Button tempParam, difficultParam, deepParam, areaParam;
    private MainApp.inflateInterface inflate_listener;
    private List<RetroSpring> springsList = new ArrayList<>();
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
        tempParam = view.findViewById(R.id.tempParam);
        tempParam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflate_listener.coldClicked(false);
            }
        });

        difficultParam = view.findViewById(R.id.difficultParam);
        difficultParam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflate_listener.levelClicked(false);
            }
        });

        areaParam = view.findViewById(R.id.areaParam);
        areaParam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflate_listener.areaClicked(false);
            }
        });

        deepParam = view.findViewById(R.id.deepParam);
        deepParam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inflate_listener.deepnessClicked(false);
            }
        });

        recyclerView = (RecyclerView) view.findViewById(R.id.rvSprings);
        mAdapter = new SpringsAdapter(springsList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(MainActivity.getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        prepareSpringsData();
    }

    private void prepareSpringsData(){
        testIt(); //todo test

        APIInterface apiInterface = RetrofitClientInstance.getRetrofitInstance().create(APIInterface.class);
        Call<List<RetroSpring>> call = apiInterface.searchSpring(new SearchSpringObj("מעיין")); //todo change prameters..
        call.enqueue(new Callback<List<RetroSpring>>() {

            @Override
            public void onResponse(Call<List<RetroSpring>> call, Response<List<RetroSpring>> response) {
//                System.out.println(response.body().get(0).getNameMayan());
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<RetroSpring>> call, Throwable t) {
//                System.out.println(t.getMessage());
                Toast.makeText(getActivity(), "Something got wrong with the search... Sorry. Try Again",
                                Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateDataList(List<RetroSpring> retroSpring){
        for (int i = 0; i < retroSpring.size(); i++){
            springsList.add(retroSpring.get(i));
        }
        mAdapter.notifyDataSetChanged();
    }

    private void testIt(){ //todo it works well, now we need to transfer data to the springScreen
        APIInterface apiInterface = RetrofitClientInstance.getRetrofitInstance().create(APIInterface.class);
        Call<List<RetroSpring>> call = apiInterface.getSpring
                (new MyTestSearchSpring("Car", "cold", 10, 0, 100,
                        31.69031, 35.14865)); //todo change prameters..
        call.enqueue(new Callback<List<RetroSpring>>() {

            @Override
            public void onResponse(Call<List<RetroSpring>> call, Response<List<RetroSpring>> response) {
                System.out.println(response.body().get(4).getNameMayan());
//                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<RetroSpring>> call, Throwable t) {
                System.out.println(t.getMessage());
                Toast.makeText(getActivity(), "Something got wrong with the search... Sorry. Try Again",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
