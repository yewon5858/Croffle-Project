package com.example.croffleproject.RoomDB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TimerDao {
    @Query("SELECT * FROM TimerTable")
    List<TimerEntity> getAll();

    @Insert
    void insert(TimerEntity timerEntity);

    @Update
    void update(TimerEntity timerEntity);

    @Delete
    void delete(TimerEntity timerEntity);
}
