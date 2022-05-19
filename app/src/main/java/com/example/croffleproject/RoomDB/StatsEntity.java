package com.example.croffleproject.RoomDB;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;

import java.time.LocalDate;
import java.util.ArrayList;

import com.example.croffleproject.RoomDB.TimerEntity;

@Entity(tableName = "StatsTable")
public class StatsEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "Date")
    private LocalDate StId;

    @ColumnInfo(name = "UsedTimer")
    private ArrayList<Integer> used;

    @ColumnInfo(name = "TotalTime")
    private int TotalTime;
}