package com.example.croffleproject.RoomDB.EntityClass;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.*;

import java.time.LocalDateTime;
import java.util.List;


@Entity(tableName = "MeasurementTable")
public class MeasurementTableEntity {

    @PrimaryKey(autoGenerate = true)
    @NonNull
    private int meas_id;

    @ColumnInfo
    private String meas_RecordNumberDB;

    @ColumnInfo
    private String meas_UseTimerNameDB;

    @ColumnInfo
    private String meas_UseTimerTimeDB;

    @ColumnInfo
    private LocalDateTime meas_StartTimeDB;

    @ColumnInfo
    private LocalDateTime meas_EndTimeDB;

    public MeasurementTableEntity() {
    }

    public MeasurementTableEntity(int meas_id, String meas_RecordNumber, String meas_UseTimerName, String meas_UseTimerTime, LocalDateTime meas_StartTime, LocalDateTime meas_EndTime) {
        this.meas_id = meas_id;
        this.meas_RecordNumberDB = meas_RecordNumber;
        this.meas_UseTimerNameDB = meas_UseTimerName;
        this.meas_UseTimerTimeDB = meas_UseTimerTime;
        this.meas_StartTimeDB = meas_StartTime;
        this.meas_EndTimeDB = meas_EndTime;
    }

    public int getMeas_id() {
        return meas_id;
    }
    public void setMeas_id(int meas_id) {
        this.meas_id = meas_id;
    }

    public String getMeas_RecordNumberDB() { return meas_RecordNumberDB; }
    public void setMeas_RecordNumberDB(String meas_RecordNumberDB) {
        this.meas_RecordNumberDB = meas_RecordNumberDB;
    }

    public String getMeas_UseTimerNameDB() { return meas_UseTimerNameDB; }
    public void setMeas_UseTimerNameDB(String meas_UseTimerNameDB) {
        this.meas_UseTimerNameDB = meas_UseTimerNameDB;
    }

    public String getMeas_UseTimerTimeDB() { return meas_UseTimerTimeDB; }
    public void setMeas_UseTimerTimeDB(String meas_UseTimerTimeDB) {
        this.meas_UseTimerTimeDB = meas_UseTimerTimeDB;
    }

    public LocalDateTime getMeas_StartTimeDB() {  return meas_StartTimeDB; }
    public void setMeas_StartTimeDB(LocalDateTime meas_StartTimeDB) {
        this.meas_StartTimeDB = meas_StartTimeDB;
    }

    public LocalDateTime getMeas_EndTimeDB() {
        return meas_EndTimeDB;
    }
    public void setMeas_EndTimeDB(LocalDateTime meas_EndTimeDB) {
        this.meas_EndTimeDB = meas_EndTimeDB;
    }
}