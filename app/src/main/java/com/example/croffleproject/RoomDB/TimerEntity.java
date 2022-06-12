package com.example.croffleproject.RoomDB;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;

import java.util.ArrayList;


@Entity(tableName = "TimerTable")
public class TimerEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "TimerNumber")
    private int Tid;

    @ColumnInfo(name = "TimerName")
    private String timer_name;

    @ColumnInfo(name = "SetTime")
    private String set_time;

    @ColumnInfo(name = "Repeat")
    private ArrayList<String> repeat;

    public TimerEntity(String timer_name, String set_time, ArrayList<String> repeat) {
        this.timer_name = timer_name;
        this.set_time = set_time;
        this.repeat = repeat;
    }

    public int getTid() {
        return Tid;
    }

    public void setTid(int n_Tid) {
        this.Tid = n_Tid;
    }

    public String getTimer_name() {
        return timer_name;
    }

    public void setTimer_name(String n_timer_name) {
        this.timer_name = n_timer_name;
    }


    public String getSet_time() {
        return set_time;
    }

    public void setSet_time(String n_set_time) {

        this.set_time = n_set_time;
    }

    public ArrayList<String> getRepeat() {
        return repeat;
    }

    public void setRepeat(ArrayList<String> n_repeat) {
        this.repeat = n_repeat;
    }
}
