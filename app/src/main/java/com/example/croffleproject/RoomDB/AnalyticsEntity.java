package com.example.croffleproject.RoomDB;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import io.reactivex.annotations.NonNull;

@Entity(tableName = "AnalyticsTable")
public class AnalyticsEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "AnalyticsId")
    @NonNull
    private int StId;

    @ColumnInfo(name = "Date")
    private LocalDate date;

    @ColumnInfo(name = "TotalTime")
    private LocalTime total;

    @ColumnInfo(name = "RestTime")
    private LocalTime rest;

    @ColumnInfo(name = "Maximum")
    private LocalTime maximum;

    public AnalyticsEntity() {
        this.StId = 0;
        this.date = LocalDate.now();
        this.total = LocalTime.now();
        this.rest = LocalTime.now();
        this.maximum = LocalTime.now();
    }

    public AnalyticsEntity(int id, LocalDate data, LocalTime total, LocalTime rest, LocalTime max) {
        this.StId = id;
        this.date = data;
        this.total = total;
        this.rest = rest;
        this.maximum = max;
    }

    public int getStId() {
        return StId;
    }

    public void setStId(int n_StId) {
        this.StId = n_StId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate n_date) {
        this.date = n_date;
    }

    public LocalTime getTotal() {
        return total;
    }

    public void setTotal(LocalTime n_total) {
        this.total = n_total;
    }

    public LocalTime getRest() {
        return rest;
    }

    public void setRest(LocalTime n_rest) {
        this.rest = n_rest;
    }

    public LocalTime getMaximum() {
        return maximum;
    }

    public void setMaximum(LocalTime n_maximum) {
        this.maximum = n_maximum;
    }
}