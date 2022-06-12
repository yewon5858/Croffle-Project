package com.example.croffleproject.RoomDB;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity(tableName = "ConcentrationTable")
public class ConcentrationTableEntity {
        @PrimaryKey(autoGenerate = true)
        @NonNull
        private int conc_id;

        @ColumnInfo
        private String conc_RecordNumberDB;

        @ColumnInfo
        private String conc_UseTimerNameDB;

        @ColumnInfo
        private String conc_UseTimerTimeDB;


        @ColumnInfo
        private LocalDateTime conc_StartTimeDB;

        @ColumnInfo
        private LocalDateTime conc_EndTimeDB;

        public ConcentrationTableEntity() {
        }

        public ConcentrationTableEntity(int conc_id, String conc_RecordNumber, String conc_UseTimerName, String conc_UseTimerTime, LocalDateTime conc_StartTime, LocalDateTime conc_EndTime) {
                this.conc_id = conc_id;
                this.conc_RecordNumberDB = conc_RecordNumber;
                this.conc_UseTimerNameDB = conc_UseTimerName;
                this.conc_UseTimerTimeDB = conc_UseTimerTime;
                this.conc_StartTimeDB = conc_StartTime;
                this.conc_EndTimeDB = conc_EndTime;
        }

        public int getConc_id() {
                return conc_id;
        }
        public void setConc_id(int conc_id) {
                this.conc_id = conc_id;
        }

        public String getConc_RecordNumberDB() { return conc_RecordNumberDB; }
        public void setConc_RecordNumberDB(String conc_RecordNumberDB) {
                this.conc_RecordNumberDB = conc_RecordNumberDB;
        }

        public String getConc_UseTimerNameDB() { return conc_UseTimerNameDB; }
        public void setConc_UseTimerNameDB(String conc_UseTimerNameDB) {
                this.conc_UseTimerNameDB = conc_UseTimerNameDB;
        }

        public String getConc_UseTimerTimeDB() { return conc_UseTimerTimeDB; }
        public void setConc_UseTimerTimeDB(String conc_UseTimerTimeDB) {
                this.conc_UseTimerTimeDB = conc_UseTimerTimeDB;
        }

        public LocalDateTime getConc_StartTimeDB() {  return conc_StartTimeDB; }
        public void setConc_StartTimeDB(LocalDateTime conc_StartTimeDB) {
                this.conc_StartTimeDB = conc_StartTimeDB;
        }

        public LocalDateTime getConc_EndTimeDB() {
                return conc_EndTimeDB;
        }
        public void setConc_EndTimeDB(LocalDateTime conc_EndTimeDB) {
                this.conc_EndTimeDB = conc_EndTimeDB;
        }
}
