package com.example.croffleproject.RoomDB;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

// version = 1: 세팅, 통계, 타이머
// version = 2: Analytics Dao 추가
@Database(entities = { SettingsEntity.class, AnalyticsEntity.class,
        TimerEntity.class}, version = 2)
@TypeConverters({Converters.class})
public abstract class  AppDatabase extends RoomDatabase{
    public abstract SettingsDao settingsDao();
    public abstract TimerDao timerDao();
    public abstract AnalyticsDao analyticsDao();
}
