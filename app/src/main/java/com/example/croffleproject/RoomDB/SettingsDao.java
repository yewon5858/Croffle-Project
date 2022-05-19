package com.example.croffleproject.RoomDB;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface SettingsDao {
    @Query("SELECT * FROM SettingsTable")
    LiveData<List<SettingsEntity>> getAll();

    @Insert
    void insert(SettingsEntity settingsEntity);

    @Update
    void update(SettingsEntity settingsEntity);

    @Delete
    void delete(SettingsEntity settingsEntity);
}
