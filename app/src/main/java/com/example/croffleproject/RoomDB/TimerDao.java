package com.example.croffleproject.RoomDB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Single;

@Dao
public interface TimerDao {
    @Query("SELECT * FROM TimerTable")
    List<TimerEntity> getAll();

    @Query("DELETE FROM TimerTable")
    void clearTable();

    @Query("SELECT TimerName FROM TimerTable")
    Single<List<String>> TimerNames();

    // 행 개수 반환
    @Query("SELECT COUNT(*) FROM TimerTable")
    int CountRow();

    @Insert
    Single<Long> insert(TimerEntity timerEntity);

    @Update
    Single<Integer> update(TimerEntity timerEntity);

    @Delete
    Completable delete(TimerEntity timerEntity);
}
