package com.example.croffleproject.RoomDB;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.croffleproject.RoomDB.Converter.DateConverters;
import com.example.croffleproject.RoomDB.DaoClass.ConcentrationTableDao;
import com.example.croffleproject.RoomDB.DaoClass.MeasurementTableDao;
import com.example.croffleproject.RoomDB.EntityClass.ConcentrationTableEntity;
import com.example.croffleproject.RoomDB.EntityClass.MeasurementTableEntity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Database(entities = {MeasurementTableEntity.class, ConcentrationTableEntity.class}, version = 1, exportSchema = false)
@TypeConverters({DateConverters.class})
public abstract class DetectionRoomDatabase extends RoomDatabase {

    public abstract MeasurementTableDao getMeasurementTableDao();
    public abstract ConcentrationTableDao getConcentrationTableDao();
    public static final int NUMBER_OF_THREADS = 4;
    private static volatile DetectionRoomDatabase INSTANCE;
    public static final ExecutorService databaseWriteExecutor
            = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    public static DetectionRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
                synchronized (DetectionRoomDatabase.class) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            DetectionRoomDatabase.class, "detection_database")
                            .allowMainThreadQueries() // modified
                            .build();
                }
            }
        return INSTANCE;
    }
}