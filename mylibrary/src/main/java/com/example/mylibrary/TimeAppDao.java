package com.example.mylibrary;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface  TimeAppDao {


    @Insert
    void insertToDB(com.example.mylibrary.TimeApp timeApp);

    @Insert
    void insertNameApp(com.example.mylibrary.TimeApp app);

    @Query("SELECT * FROM times WHERE app_name LIKE :app_name ")
    List<com.example.mylibrary.TimeApp> getAll(String app_name);

    @Query("SELECT * FROM times")
    List<com.example.mylibrary.TimeApp> getAll();

    @Query("DELETE FROM times")
    void deleteAll();

}
