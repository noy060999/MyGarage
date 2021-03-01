package com.example.managerapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mylibrary.Main_Garage;

public class MainActivity_Manager extends Main_Garage {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setColor("#34aeeb");
        setAppName("ManagerAPP");
    }
}