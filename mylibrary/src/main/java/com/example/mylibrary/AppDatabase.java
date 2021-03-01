package com.example.mylibrary;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {com.example.mylibrary.TimeApp.class}, version = 1)
    abstract class AppDatabase extends RoomDatabase {
        public abstract TimeAppDao timeAppDao();

}
