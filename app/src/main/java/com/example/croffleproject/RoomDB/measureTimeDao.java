package com.example.croffleproject.RoomDB;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface measureTimeDao {//데이터를 엑세스하기 위한 오브젝트(객체)

    @Query("SELECT * FROM measureTimeEntity")
    LiveData<List<measureTimeEntity>> getAll(); // 리스트 전부를 받아오는 쿼리를 사용하여 getAll을 선언
    //Livedata는 TimerTableEntity의 데이터가 변경이 일어나면 관찰하던 데이터의 변경을 바로 반영함
    @Insert
    void insert(measureTimeEntity M_Time);

    @Update
    void update(measureTimeEntity M_Time);

    @Delete
    void delete(measureTimeEntity M_Time);



}
