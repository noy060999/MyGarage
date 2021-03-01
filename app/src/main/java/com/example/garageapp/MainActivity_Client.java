package com.example.garageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mylibrary.Main_Garage;

public class MainActivity_Client extends Main_Garage {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setColor("#55d962");
        setAppName("ClientAPP");
    }
}