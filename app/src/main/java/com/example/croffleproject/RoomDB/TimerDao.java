package com.example.croffleproject.RoomDB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.TypeConverters;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface TimerDao {
    @Query("SELECT * FROM TimerTable")
    List<TimerEntity> getAll();

    @Query("DELETE FROM TimerTable")
    void clearTable();

    @Insert
    void insert(TimerEntity timerEntity);

    @Update
    void update(TimerEntity timerEntity);

    @Delete
    void delete(TimerEntity timerEntity);

    @Query("SELECT TimerName FROM timertable")
    String get_tName();

    @Query("SELECT SetTime FROM timertable")
    int get_sTime();

    @Query("SELECT Repeat FROM timertable")
    String getRepeat();
}
