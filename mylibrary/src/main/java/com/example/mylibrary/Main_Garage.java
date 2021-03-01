package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.RelativeLayout;
import android.widget.TextView;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Url;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//my module
public abstract class Main_Garage extends AppCompatActivity {

    private long startTimeStamp = 0;
    static String appName = "My Garage";
    TextView textView, timeView;
    RelativeLayout relativeLayout;
    Manager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__garage);

        //views init
        textView = findViewById(R.id.txtViewGarage);
        timeView = findViewById(R.id.timeView);
        relativeLayout = findViewById(R.id.backgroundRel);
        manager = Manager.initHelper(this.getApplicationContext());

        //callback
        downloadGarages();
    }

    private void downloadGarages() {
        new GarageControllerPro().fetchGarage(new GarageControllerPro.CallBack_Garage() {
            @Override
            public void garage(Garage garage) {
                if (garage != null) {
                    textView.setText("Cars: " + Arrays.toString(garage.getCars()) + "\n \n" + "Name:" + garage.getName() + "\n \n" + "Address: " + garage.getAddress() + "\n \n" +
                            "Is open: " + garage.getOpen() + "\n \n");
                }
            }
        });
    }

    //my functions to use from client and manager
    protected void setColor(String color) { relativeLayout.setBackgroundColor(Color.parseColor(color));}
    protected void setAppName(String appName) {
        this.appName = appName;
    }

    //calculate the time
    @Override
    protected void onResume() {
        super.onResume();
        startTimeStamp = System.currentTimeMillis();
        new Thread(new Runnable() {
            @Override
            public void run() {
                manager.getInstance().getAllLogsByTag(appName, time -> runOnUiThread(() -> {
                    float total = calculateTime(time);
                    timeView.setText( "Total Time :"+total);

                }));
            }
        }).start();
    }

    private float calculateTime(List<TimeApp> time){
        float total = 0;
        for (TimeApp timeApp:time)
            total+=(timeApp.timeInApp)/1000;
        return  total;
    }

    @Override
    protected void onPause() {
        super.onPause();
        long timeInApp = System.currentTimeMillis() - startTimeStamp;
        //insert timestamp to db
        Manager.getInstance().insertToDB(appName, timeInApp);
    }
}