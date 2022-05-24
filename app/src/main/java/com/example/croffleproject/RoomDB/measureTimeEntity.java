package com.example.croffleproject.RoomDB;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class measureTimeEntity {
    @PrimaryKey(autoGenerate = true) // id 값이 하나씩 자동으로 증가(autoGenerate = true)
    private int M_id; // sql 기반의 데이터 베이스이기 때문에 Primary Key 값을 id로 받아옴
    private int M_todoTitle; // sql 기반의 데이터 베이스이기 때문에 Primary Key 값을 id로 받아옴
    private String M_date; // 일정의 이름을 받아옴
    private String M_startTime;
    private String M_endTime;

    public measureTimeEntity(int m_todoTitle, String m_date, String m_startTime, String m_endTime) {
        M_todoTitle = m_todoTitle;
        M_date = m_date;
        M_startTime = m_startTime;
        M_endTime = m_endTime;
    }

    public int getM_id() {
        return M_id;
    }

    public void setM_id(int m_id) {
        M_id = m_id;
    }

    public int getM_todoTitle() {
        return M_todoTitle;
    }

    public void setM_todoTitle(int m_todoTitle) {
        M_todoTitle = m_todoTitle;
    }

    public String getM_date() {
        return M_date;
    }

    public void setM_date(String m_date) {
        M_date = m_date;
    }

    public String getM_startTime() {
        return M_startTime;
    }

    public void setM_startTime(String m_startTime) {
        M_startTime = m_startTime;
    }

    public String getM_endTime() {
        return M_endTime;
    }

    public void setM_endTime(String m_endTime) {
        M_endTime = m_endTime;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("measureTimeEntity{");
        sb.append("M_id=").append(M_id);
        sb.append(", M_todoTitle=").append(M_todoTitle);
        sb.append(", M_date='").append(M_date).append('\'');
        sb.append(", M_startTime='").append(M_startTime).append('\'');
        sb.append(", M_endTime='").append(M_endTime).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
