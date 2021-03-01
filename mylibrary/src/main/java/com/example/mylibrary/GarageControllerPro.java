package com.example.mylibrary;

import android.util.Log;

import com.example.mylibrary.Garage;
import com.example.mylibrary.GarageAPI;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class GarageControllerPro {

    final String BASE_URL = "https://pastebin.com/raw/";
    private CallBack_Garage callBack_garage;

    Callback<Garage> garageCallBack = new Callback<Garage>() {
        @Override
        public void onResponse(Call<Garage> call, Response<Garage> response) {
            if (response.isSuccessful()) {
                Garage garage = response.body();

                if (callBack_garage != null) {
                    callBack_garage.garage(garage);
                }
            } else {
                System.out.println(response.errorBody());
            }
        }

        @Override
        public void onFailure(Call<Garage> call, Throwable t) {
            t.printStackTrace();
        }
    };


    public void fetchGarage(CallBack_Garage callBack_garage) {
        this.callBack_garage = callBack_garage;
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        GarageAPI garageAPI = retrofit.create(GarageAPI.class);

        Call<Garage> call = garageAPI.loadGarages();
        call.enqueue(garageCallBack);
    }

    public interface CallBack_Garage {
        void garage(Garage garage);
    }

}