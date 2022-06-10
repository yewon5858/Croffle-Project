package com.example.croffleproject.RoomDB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface AnalyticsDao {
    @Query("SELECT * FROM AnalyticsTable")
    List<AnalyticsEntity> getAll();

    @Query("DELETE FROM AnalyticsTable")
    Completable clearTable();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    Single<Long> insert(AnalyticsEntity analyticsEntity);

    @Update
    Single<Integer> update(AnalyticsEntity analyticsEntity);

    @Delete
    Completable delete(AnalyticsEntity analyticsEntity);

    @Query("SELECT * FROM AnalyticsTable WHERE AnalyticsId = :id ")
    Single<AnalyticsEntity> getTable(int id);

    @Query("SELECT * FROM ANALYTICSTABLE WHERE Date = :date ")
    Single<AnalyticsEntity> getTableToDate(String date);
}
