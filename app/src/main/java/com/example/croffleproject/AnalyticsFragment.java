package com.example.croffleproject;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.example.croffleproject.RoomDB.MeasurementTableEntity;
import com.example.croffleproject.main.MainActivity;
import com.example.croffleproject.RoomDB.AnalyticsEntity;
import com.example.croffleproject.RoomDB.AppDatabase;
import com.example.croffleproject.RoomDB.Converters;
import com.example.croffleproject.RoomDB.SettingsEntity;
import com.example.croffleproject.RoomDB.TimerEntity;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.example.croffleproject.Theme.GraphColor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AnalyticsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AnalyticsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    // id 불러올 변수
    private Context Act;
    private TextView date[] = new TextView[7];
    private String DayOfWeek;
    private PieChart pieChart;

    private TextView max;
    private TextView rest;
    private TextView highest;

    private AppDatabase appDatabase;
    private LocalDateTime data;
    private float value;

    private int starting = 100;

    public AnalyticsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AnalyticsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AnalyticsFragment newInstance(String param1, String param2) {
        AnalyticsFragment fragment = new AnalyticsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_analytics, container, false);

        date[0] = v.findViewById(R.id.date_1);
        date[1] = v.findViewById(R.id.date_2);
        date[2] = v.findViewById(R.id.date_3);
        date[3] = v.findViewById(R.id.date_4);
        date[4] = v.findViewById(R.id.date_5);
        date[5] = v.findViewById(R.id.date_6);
        date[6] = v.findViewById(R.id.date_7);

        max = v.findViewById(R.id.Max);
        rest = v.findViewById(R.id.rest);
        highest = v.findViewById(R.id.highest);

        for (int i = 0; i < date.length; i++) {
            switch (LocalDate.now().minusDays(date.length - i - 1).getDayOfWeek().getValue()) {
                case 1:
                    DayOfWeek = "월";
                    break;
                case 2:
                    DayOfWeek = "화";
                    break;
                case 3:
                    DayOfWeek = "수";
                    break;
                case 4:
                    DayOfWeek = "목";
                    break;
                case 5:
                    DayOfWeek = "금";
                    break;
                case 6:
                    DayOfWeek = "토";
                    break;
                case 7:
                    DayOfWeek = "일";
                    date[i].setTextColor(Color.parseColor("#FE645A"));
                    break;
            }
            date[i].setText(String.valueOf(LocalDate.now().minusDays(date.length - i - 1).getDayOfMonth()) + "\n" + DayOfWeek);
        }

        Act = container.getContext();
        appDatabase = AppDatabase.getInstance(Act);
        appDatabase.measurementTableDao().insert(new MeasurementTableEntity(
                1, "sad", "정처기", "01:00", LocalDateTime.now(), LocalDateTime.now().plusHours(1)))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();

        appDatabase.measurementTableDao().insert(new MeasurementTableEntity(
                2, "sad", "개발", "01:00", LocalDateTime.now().plusHours(3), LocalDateTime.now().plusHours(5)))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();

        pieChart = v.findViewById(R.id.PieChart);


        date[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReplaceData(pieChart, date.length - 1);
            }
        });

        date[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReplaceData(pieChart, date.length - 2);
            }
        });

        date[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReplaceData(pieChart, date.length - 3);
            }
        });

        date[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReplaceData(pieChart, date.length - 4);
            }
        });

        date[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReplaceData(pieChart, date.length - 5);
            }
        });

        date[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReplaceData(pieChart, date.length - 6);
            }
        });

        date[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReplaceData(pieChart, date.length - 7);
            }
        });

        // Inflate the layout for this fragment
        return v;
    }

    public void ReplaceData(PieChart pieChart, int date) {
        ArrayList<PieEntry> time = new ArrayList<>();
        Act = getContext();
        appDatabase = AppDatabase.getInstance(Act);

        // 그래프 생성, 변경
        appDatabase.measurementTableDao().getAllData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(item -> {
                    for (MeasurementTableEntity measurementTableEntity : item) {
                        if (measurementTableEntity.getMeas_StartTimeDB().getDayOfMonth() == LocalDateTime.now().minusDays(date).getDayOfMonth()) {
                            Log.e("hi", "ok");
                            data = measurementTableEntity.getMeas_EndTimeDB();
                            data.minusHours(measurementTableEntity.getMeas_StartTimeDB().getHour());
                            data.minusMinutes(measurementTableEntity.getMeas_StartTimeDB().getMinute());
                            data.minusSeconds(measurementTableEntity.getMeas_StartTimeDB().getSecond());

                            value = data.getSecond() + (data.getMinute() * 60) + (data.getHour() * 60 * 60);
                            time.add(new PieEntry(value, measurementTableEntity.getMeas_UseTimerNameDB()));
                        }
                    }
                    PieDataSet pieDataSet = new PieDataSet(time, "");
                    pieDataSet.setColors(GraphColor.STANDARD_THEME);
                    pieDataSet.setValueTextSize(0);

                    PieData pieData = new PieData(pieDataSet);

                    pieChart.setData(pieData);
                    pieChart.getDescription().setEnabled(false);
                    pieChart.setCenterText(String.valueOf(LocalDate.now().minusDays(date).getDayOfMonth()) + "일 공부 시간");
                    pieChart.setCenterTextSize(16f);
                    pieChart.setDrawRoundedSlices(true);
                    pieChart.setHoleRadius(72);
                    pieChart.setLogEnabled(false);
                    pieChart.setDrawEntryLabels(false);
                    pieChart.setDrawMarkers(false);
                    pieChart.invalidate();
                });

        // 데이터 변경
        appDatabase.analyticsDao().getTable(starting)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSuccess(analyticsEntity -> {
                    max.setText(String.valueOf(analyticsEntity.getTotal().getHour()) + "시 "
                            + String.valueOf(analyticsEntity.getTotal().getMinute()) + "분");
                    rest.setText(String.valueOf(analyticsEntity.getRest().getHour()) + "시 "
                            + String.valueOf(analyticsEntity.getRest().getMinute()) + "분");
                    highest.setText(String.valueOf(analyticsEntity.getMaximum().getHour()) + "시 "
                            + String.valueOf(analyticsEntity.getMaximum().getMinute()) + "분");
                })
                .subscribe();

        appDatabase.analyticsDao().getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(item -> {
                    for (AnalyticsEntity analyticsEntity : item) {
                        if (analyticsEntity.getDate().equals(LocalDate.now().minusDays(date))) {
                            appDatabase.analyticsDao().getTableToDate(LocalDate.now().minusDays(date))
                                    .subscribeOn(Schedulers.io())
                                    .observeOn(AndroidSchedulers.mainThread())
                                    .doOnSuccess(analyticsEntity1 -> {
                                        max.setText(String.valueOf(analyticsEntity.getTotal().getHour()) + "시 "
                                                + String.valueOf(analyticsEntity.getTotal().getMinute()) + "분");
                                        rest.setText(String.valueOf(analyticsEntity.getRest().getHour()) + "시 "
                                                + String.valueOf(analyticsEntity.getRest().getMinute()) + "분");
                                        highest.setText(String.valueOf(analyticsEntity.getMaximum().getHour()) + "시 "
                                                + String.valueOf(analyticsEntity.getMaximum().getMinute()) + "분");
                                    })
                                    .subscribe();
                        }
                    }
                });
    }
}
