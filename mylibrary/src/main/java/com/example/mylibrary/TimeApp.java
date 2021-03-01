package com.example.mylibrary;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

//room sql table
@Entity(tableName = "times")
public class TimeApp {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "app_name")
    public String nameApp;

    @ColumnInfo(name = "time_in_app")
    public float timeInApp;


    public TimeApp() { }

    @Ignore
    public TimeApp(float timeInApp, String nameApp) {
        this.timeInApp = timeInApp;
        this.nameApp = nameApp;
    }
}


