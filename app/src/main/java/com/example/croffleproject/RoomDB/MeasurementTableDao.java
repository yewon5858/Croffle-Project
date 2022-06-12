package com.example.croffleproject.RoomDB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.example.croffleproject.RoomDB.MeasurementTableEntity;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;

@Dao
public interface MeasurementTableDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Single<Long> insert(MeasurementTableEntity measurementTableEntity);

    @Update
    Single<Integer> update(MeasurementTableEntity measurementTableEntity);

    @Delete
    Completable delete(MeasurementTableEntity measurementTableEntity);

    //Select All Data
    @Query("SELECT * FROM MeasurementTable")
    Flowable<List<MeasurementTableEntity>> getAllData();

    @Query("DELETE FROM MeasurementTable")
    void deleteAll();
}
