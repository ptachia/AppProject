package com.ptachia.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIInterface {

    //todo add more queries according to the demands
    // todo also change queries parameters

    @POST("/search")
    Call<List<RetroSpring>> searchSpring(@Body SearchSpringObj searchSpring);

    @POST("/getSpring")
    Call<List<RetroSpring>> getSpring(@Body MyTestSearchSpring getSpring);
}

