package com.example.croffleproject;

import android.graphics.Color;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class StatsPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats_page);

        PieChart pieChart = findViewById(R.id.PieChart);

        ArrayList<PieEntry> time = new ArrayList<>();
        time.add(new PieEntry(508, "개발"));
        time.add(new PieEntry(600, "토익"));
        time.add(new PieEntry(750,"자격증"));
        time.add(new PieEntry(600,"과제"));

        PieDataSet pieDataSet = new PieDataSet(time, "");
        pieDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        pieDataSet.setValueTextColor(Color.BLACK);
        pieDataSet.setValueTextSize(16f);

        PieData pieData = new PieData(pieDataSet);

        pieChart.setData(pieData);
        pieChart.getDescription().setEnabled(false);
        pieChart.setCenterText("타이머 시간");
    }
}