package com.example.croffleproject.RoomDB;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Converters {
    // ArrayList <-> String
    @TypeConverter
    public static ArrayList<String> fromString(String value) {
        Type listType = new TypeToken<ArrayList<String>>() {}.getType();
        return new Gson().fromJson(value, listType);
    }

    @TypeConverter
    public static String fromArrayList(ArrayList<String> list) {
        Gson gson = new Gson();
        String json = gson.toJson(list);
        return json;
    }

    // LocalDate Convert
    @TypeConverter
    public static LocalDate toDate(String dateString) {
        if (dateString == null) {
            return null;
        } else {
            return LocalDate.parse(dateString);
        }
    }

    @TypeConverter
    public static String toDateString(LocalDate date) {
        if (date == null) {
            return null;
        } else {
            return date.toString();
        }
    }

    // LocalTime Convert
    @TypeConverter
    public static LocalTime toTime(String timeString) {
        if (timeString == null) {
            return null;
        } else {
            return LocalTime.parse(timeString);
        }
    }

    @TypeConverter
    public static String toTimeString(LocalTime time) {
        if (time == null) {
            return null;
        } else {
            return time.toString();
        }
    }
}
