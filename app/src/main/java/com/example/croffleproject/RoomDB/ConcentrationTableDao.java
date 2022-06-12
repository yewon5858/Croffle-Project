package com.example.croffleproject.RoomDB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.croffleproject.RoomDB.ConcentrationTableEntity;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface ConcentrationTableDao {
    @Insert
    Single<Long> insert(ConcentrationTableEntity concentrationTableEntity);

    @Update
    Single<Integer> update(ConcentrationTableEntity concentrationTableEntity);

    @Delete
    Completable delete(ConcentrationTableEntity concentrationTableEntity);

    //Select All Data
    @Query("SELECT * FROM ConcentrationTable")
    List<ConcentrationTableEntity> getAllData();

    @Query("DELETE FROM ConcentrationTable")
    Completable deleteAll();
}
