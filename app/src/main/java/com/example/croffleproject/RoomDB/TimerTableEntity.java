package com.example.croffleproject.RoomDB;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class TimerTableEntity {
        @PrimaryKey(autoGenerate = true) // id 값이 하나씩 자동으로 증가(autoGenerate = true)
        private int id_todo;      // sql 기반의 데이터 베이스이기 때문에 Primary Key 값을 id로 받아옴
        private String todoTitle; // 일정의 이름을 받아옴
        private String goalTime;     // 시간관련 정보를 받아옴
        private String day;       // 반복 주기에 대한 데이터를 받아옴


    public TimerTableEntity(String todoTitle, String goalTime) {
        this.todoTitle = todoTitle;
        this.goalTime = goalTime;
    }

    public int getId() {
            return id_todo;
        }
    public void setId(int id) {
        this.id_todo = id_todo;
    }

    public String getTitle() {
            return todoTitle;
        }

    public void setTitle(String title) {
            this.todoTitle = title;
        }

    public String getGoalTime() {
        return goalTime;
    }

    public void setGoalTime(String goalTime) {
        this.goalTime = goalTime;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("TimerTableEntity{");
        sb.append("id_todo=").append(id_todo);
        sb.append(", todoTitle='").append(todoTitle).append('\'');
        sb.append(", goalTime=").append(goalTime);
        sb.append(", day='").append(day).append('\'');
        sb.append('}');
        return sb.toString();
    }
}


