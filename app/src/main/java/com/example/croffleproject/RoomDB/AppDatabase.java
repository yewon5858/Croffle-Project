package com.example.croffleproject.RoomDB;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {engagedTimeEntity.class, measureTimeEntity.class
        , TimerTableEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract engagedTimeDao engagedTimeDao();
    public abstract measureTimeDao measureTimeDao();
    public abstract TimerTableDao timerTableDao();
}
