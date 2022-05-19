package com.example.croffleproject.RoomDB;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.ColumnInfo;

// 설정 테이블
@Entity(tableName = "SettingsTable")
public class SettingsEntity {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "TemplateNumber")
    private int Sid;

    @ColumnInfo(name = "Set_SavingMode")
    private boolean saving;

    @ColumnInfo(name = "Set_NotificationMode")
    private boolean notification;

    @ColumnInfo(name = "Set_VibrationMode")
    private boolean vibration;

    @ColumnInfo(name = "Set_SoundMode")
    private boolean sound;


    public int getSid() {
        return Sid;
    }

    public void setSid(int n_sid) {
        this.Sid = n_sid;
    }

    public boolean getSavingMode() {
        return saving;
    }

    public void setSavingMode(boolean n_saving) {
        this.saving = n_saving;
    }

    public boolean getNotificationMode() {
        return notification;
    }

    public void setNotificationMode(boolean n_notification) {
        this.notification = n_notification;
    }

    public boolean getVibrationMode() {
        return vibration;
    }

    public void setVibrationMode(boolean n_vibration) {
        this.vibration = n_vibration;
    }

    public boolean getSoundMode() {
        return sound;
    }

    public void setSoundMode(boolean n_sound) {
        this.sound = n_sound;
    }
}
