package com.example.croffleproject.RoomDB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;
import androidx.room.Update;

import java.time.LocalDate;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.annotations.NonNull;

@Dao
@TypeConverters({Converters.class})
public interface AnalyticsDao {
    @Query("SELECT * FROM AnalyticsTable")
    Flowable<List<AnalyticsEntity>> getAll();

    @Query("DELETE FROM AnalyticsTable")
    Completable clearTable();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Single<Long> insert(AnalyticsEntity analyticsEntity);

    @Update
    Single<Integer> update(AnalyticsEntity analyticsEntity);

    @Delete
    Completable delete(AnalyticsEntity analyticsEntity);

    @Query("SELECT * FROM AnalyticsTable WHERE AnalyticsId = :id ")
    Single<AnalyticsEntity> getTable(int id);

    @Query("SELECT * FROM AnalyticsTable WHERE Date = :date")
    Single<AnalyticsEntity> getTableToDate(LocalDate date);
}
