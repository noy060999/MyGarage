package com.example.mylibrary;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GarageAPI {

    @GET("WypPzJCt")
    Call<Garage> loadGarages();
}