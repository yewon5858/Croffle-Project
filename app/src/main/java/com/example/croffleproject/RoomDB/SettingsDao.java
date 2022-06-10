package com.example.croffleproject.RoomDB;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Single;

@Dao
public interface SettingsDao {
    @Query("SELECT * FROM SettingsTable")
    LiveData<List<SettingsEntity>> getAll();

    @Query("DELETE FROM SettingsTable")
    Completable clearTable();

    @Query("SELECT * FROM SettingsTable WHERE SettingId = :id ")
    Single<SettingsEntity> getTable(int id);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    Single<Long> insert(SettingsEntity settingsEntity);

    @Update
    Single<Integer> update(SettingsEntity settingsEntity);
}
