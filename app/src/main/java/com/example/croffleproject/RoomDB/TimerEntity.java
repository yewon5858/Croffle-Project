package com.example.croffleproject.RoomDB;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;

import java.util.List;


@Entity(tableName = "TimerTable")
public class TimerEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "DisplayNumber")
    private int Tid;

    @ColumnInfo(name = "TimerName")
    private String timer_name;

    @ColumnInfo(name = "SetTime")
    private String set_time;

    @ColumnInfo(name = "Repeat")
    private List<String> day;


    public int getTid() {
        return Tid;
    }

    public void setTid(int n_Tid) {
        this.Tid = n_Tid;
    }

    public String getTimerName() {
        return timer_name;
    }

    public void setTimerName(String n_timer_name) {
        this.timer_name = n_timer_name;
    }

    public String getSetTime() {
        return set_time;
    }

    public void setSetTime(String n_set_time) {
        this.set_time = n_set_time;
    }

    public List<String> getRepeat() {
        return day;
    }

    public void setRepeat(List<String> n_day) {
        this.day = n_day;
    }
}
