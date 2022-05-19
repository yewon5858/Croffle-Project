package com.example.croffleproject.RoomDB;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = { SettingsEntity.class, StatsEntity.class,
        TimerEntity.class }, version = 1)
@TypeConverters({Converters.class})
public abstract class  AppDatabase extends RoomDatabase{
    public abstract SettingsDao settingsDao();
    public abstract TimerDao timerDao();
}
