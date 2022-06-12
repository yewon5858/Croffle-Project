package com.example.croffleproject.RoomDB;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class engagedTimeEntity {
    @PrimaryKey(autoGenerate = true) // id 값이 하나씩 자동으로 증가(autoGenerate = true)
    private int E_id; // sql 기반의 데이터 베이스이기 때문에 Primary Key 값을 id로 받아옴
    private int E_todoTitle; // sql 기반의 데이터 베이스이기 때문에 Primary Key 값을 id로 받아옴
    private String E_date; // 일정의 이름을 받아옴
    private String E_startTime;
    private String E_endTime;

    public engagedTimeEntity() {

    }

    public engagedTimeEntity(int e_todoTitle, String e_date, String e_startTime, String e_endTime) {
        E_todoTitle = e_todoTitle;
        E_date = e_date;
        E_startTime = e_startTime;
        E_endTime = e_endTime;
    }

    public int getE_id() {
        return E_id;
    }

    public void setE_id(int e_id) {
        E_id = e_id;
    }

    public int getE_todoTitle() {
        return E_todoTitle;
    }

    public void setE_todoTitle(int e_todoTitle) {
        E_todoTitle = e_todoTitle;
    }

    public String getE_date() {
        return E_date;
    }

    public void setE_date(String e_date) {
        E_date = e_date;
    }

    public String getE_startTime() {
        return E_startTime;
    }

    public void setE_startTime(String e_startTime) {
        E_startTime = e_startTime;
    }

    public String getE_endTime() {
        return E_endTime;
    }

    public void setE_endTime(String e_endTime) {
        E_endTime = e_endTime;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("engagedTimeEntity{");
        sb.append("E_id=").append(E_id);
        sb.append(", E_todoTitle=").append(E_todoTitle);
        sb.append(", E_date='").append(E_date).append('\'');
        sb.append(", E_startTime='").append(E_startTime).append('\'');
        sb.append(", E_endTime='").append(E_endTime).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
