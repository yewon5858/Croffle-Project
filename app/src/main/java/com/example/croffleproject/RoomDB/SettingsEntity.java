package com.example.croffleproject.RoomDB;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;

// 설정 테이블
@Entity(tableName = "SettingsTable")
public class SettingsEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "SettingId")
    private int Sid;

    @ColumnInfo(name = "Saving")
    private boolean saving;

    @ColumnInfo(name = "Notification")
    private boolean notification;

    @ColumnInfo(name = "Vibration")
    private boolean vibration;

    @ColumnInfo(name = "SoundMode")
    private boolean sound;


    public int getSid() {
        return Sid;
    }

    public void setSid(int n_sid) {
        this.Sid = n_sid;
    }

    public boolean getSaving() {
        return saving;
    }

    public void setSaving(boolean n_saving) {
        this.saving = n_saving;
    }

    public boolean getNotification() {
        return notification;
    }

    public void setNotification(boolean n_notification) {
        this.notification = n_notification;
    }

    public boolean getVibration() {
        return vibration;
    }

    public void setVibration(boolean n_vibration) {
        this.vibration = n_vibration;
    }

    public boolean getSound() {
        return sound;
    }

    public void setSound(boolean n_sound) {
        this.sound = n_sound;
    }
}
