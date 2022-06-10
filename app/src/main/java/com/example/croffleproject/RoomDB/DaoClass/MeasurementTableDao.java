package com.example.croffleproject.RoomDB.DaoClass;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.croffleproject.RoomDB.EntityClass.MeasurementTableEntity;

import java.util.List;

@Dao
public interface MeasurementTableDao {
    @Insert
    void insert(MeasurementTableEntity measurementTableEntity);

    @Update
    void update(MeasurementTableEntity measurementTableEntity);

    @Delete
    void delete(MeasurementTableEntity measurementTableEntity);

    //Select All Data
    @Query("SELECT * FROM MeasurementTable")
    List<MeasurementTableEntity> getAllData();

    @Query("DELETE FROM MeasurementTable")
    void deleteAll();
}
