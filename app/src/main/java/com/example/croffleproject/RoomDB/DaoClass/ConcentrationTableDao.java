package com.example.croffleproject.RoomDB.DaoClass;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.croffleproject.RoomDB.EntityClass.ConcentrationTableEntity;

import java.util.List;

@Dao
public interface ConcentrationTableDao {
    @Insert
    void insert(ConcentrationTableEntity concentrationTableEntity);

    @Update
    void update(ConcentrationTableEntity concentrationTableEntity);

    @Delete
    void delete(ConcentrationTableEntity concentrationTableEntity);

    //Select All Data
    @Query("SELECT * FROM ConcentrationTable")
    List<ConcentrationTableEntity> getAllData();

    @Query("DELETE FROM ConcentrationTable")
    void deleteAll();
}
