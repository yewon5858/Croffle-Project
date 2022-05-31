package com.example.croffleproject.RoomDB;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface AnalyticsDao {
    @Query("SELECT * FROM AnalyticsTable")
    List<AnalyticsEntity> getAll();

    @Insert
    void insert(AnalyticsEntity analyticsEntity);

    @Update
    void update(AnalyticsEntity analyticsEntity);

    @Delete
    void delete(AnalyticsEntity analyticsEntity);
}
