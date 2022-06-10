package com.example.croffleproject.RoomDB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.TypeConverters;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface TimerDao {
    @Query("SELECT * FROM TimerTable")
    List<TimerEntity> getAll();

    @Query("DELETE FROM TimerTable")
    void clearTable();

    @Insert
    Single<Long> insert(TimerEntity timerEntity);

    @Update
    Single<Integer> update(TimerEntity timerEntity);

    @Delete
    Completable delete(TimerEntity timerEntity);
}
