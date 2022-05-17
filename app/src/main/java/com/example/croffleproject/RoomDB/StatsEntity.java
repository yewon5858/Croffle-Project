package com.example.croffleproject.RoomDB;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;

import java.time.LocalDate;

@Entity(tableName = "StatsTable")
public class StatsEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Date")
    private LocalDate StId;

    @ColumnInfo(name = "TotalEngagedTime")
    private int TotalTime;
}
