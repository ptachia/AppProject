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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.ptachia.myapplication.MainActivity.*;

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

        TextView level_choice = view.findViewById(R.id.level_choice2);
        TextView temp_choice = view.findViewById(R.id.temp_choice2);
        TextView area_choice = view.findViewById(R.id.area_choice2);
        TextView deep_choice = view.findViewById(R.id.deep_choice2);
        if (!MainActivity.userData.is_name_search){
            level_choice.setText(""+inflate_listener.levelToHebrew(MainActivity.userData.my_level));
            temp_choice.setText(""+inflate_listener.tempToHebrew(MainActivity.userData.my_temprature));
            area_choice.setText(""+inflate_listener.areaToHebrew(MainActivity.userData.my_area)+ "\n" + "רדיוס:"+ MainActivity.userData.my_distance);
            deep_choice.setText(""+inflate_listener.deepToHebrew(MainActivity.userData.my_deepness));
        }

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
        mAdapter = new SpringsAdapter(springsList, MainActivity.getContext(), inflate_listener);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(MainActivity.getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(mAdapter);
        if (MainActivity.userData.is_name_search) { // this is search by name
            prepareSpringsData();
        }
        else // this is search by parameters
        {
            testIt();
        }
    }

    private void prepareSpringsData(){

        APIInterface apiInterface = RetrofitClientInstance.getRetrofitInstance().create(APIInterface.class);
        Call<List<RetroSpring>> call = apiInterface.searchSpring(new SearchSpringObj(MainActivity.userData.spring_name));
        call.enqueue(new Callback<List<RetroSpring>>() {

            @Override
            public void onResponse(Call<List<RetroSpring>> call, Response<List<RetroSpring>> response) {
//                System.out.println(response.body().get(0).getNameMayan());
                if (response.body().size() == 0){
                    Toast.makeText(getActivity(), ""+"לא נמצאו התאמות. נסה לשנות את הפרמטרים", Toast.LENGTH_LONG).show();
                }
                else {
                    generateDataList(response.body());}
            }

            @Override
            public void onFailure(Call<List<RetroSpring>> call, Throwable t) {
//                System.out.println(t.getMessage());
                Toast.makeText(getActivity(), ""+"משהו השתבש במהלך החיפוש, נסה לחפש שוב",
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    private void generateDataList(List<RetroSpring> retroSpring){
        for (int i = 0; i < retroSpring.size(); i++){
            springsList.add(retroSpring.get(i));
        }
        mAdapter.notifyDataSetChanged();
    }

    private void testIt(){
        APIInterface apiInterface = RetrofitClientInstance.getRetrofitInstance().create(APIInterface.class);
        Call<List<RetroSpring>> call = apiInterface.getSpring
                (new MyTestSearchSpring(convertLevelToStr(MainActivity.userData.my_level),
                        convertTemplToStr(MainActivity.userData.my_temprature),
                        MainActivity.userData.my_distance,
                        0, // todo doesnt work with 1 value
                        200, //todo should be replaced by "userdata.my_deepness"
                        MainActivity.userData.my_lat,
                        MainActivity.userData.my_lon));

        call.enqueue(new Callback<List<RetroSpring>>() {

            @Override
            public void onResponse(Call<List<RetroSpring>> call, Response<List<RetroSpring>> response) {
                if (response.body().size() == 0){
                    Toast.makeText(getActivity(), ""+"לא נמצאו התאמות. נסה לשנות את הפרמטרים", Toast.LENGTH_LONG).show();
                }
                else {
                generateDataList(response.body());}
            }

            @Override
            public void onFailure(Call<List<RetroSpring>> call, Throwable t) {
                Toast.makeText(getActivity(), ""+"משהו השתבש במהלך החיפוש, נסה לחפש שוב",
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    private String convertTemplToStr(int my_temperature) {
        switch (my_temperature){
            case 0: return "All";
            case 1: return "hot";
            case 2: return "cold";
            case 3: return "very cold";
        }
        return "All";
    }

    private String convertLevelToStr(int my_level) {
        switch (my_level){
            case 0: return "All";
            case 1: return "Car";
            case 2: return "Jeep";
            case 3: return "Leg";
        }
        return "All";
    }


}
