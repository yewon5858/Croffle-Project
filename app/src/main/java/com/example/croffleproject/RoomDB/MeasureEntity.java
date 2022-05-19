package com.example.croffleproject.RoomDB;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class MeasureEntity {
    @PrimaryKey
    @ColumnInfo(name = "TimerName")
    String timer_name;
}
