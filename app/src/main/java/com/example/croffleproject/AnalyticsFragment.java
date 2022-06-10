package com.example.croffleproject;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

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

    private int starting = 0;

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
        appDatabase.analyticsDao().insert(new AnalyticsEntity(
                starting, LocalDate.now(), null, LocalTime.of(0, 0),
                LocalTime.of(0, 0), LocalTime.of(0, 0)))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError(Throwable -> Throwable.toString())
                .subscribe();

        pieChart = v.findViewById(R.id.PieChart);

        ArrayList<PieEntry> time = new ArrayList<>();
        time.add(new PieEntry(72, "개발"));
        time.add(new PieEntry(60, "토익"));
        time.add(new PieEntry(120,"자격증"));

        PieDataSet pieDataSet = new PieDataSet(time, "");
        pieDataSet.setColors(GraphColor.STANDARD_THEME);
        pieDataSet.setValueTextSize(0);

        PieData pieData = new PieData(pieDataSet);

        pieChart.setData(pieData);
        pieChart.getDescription().setEnabled(false);
        pieChart.setCenterText(String.valueOf(LocalDate.now().getDayOfMonth()) + "일 공부 시간");
        pieChart.setCenterTextSize(16f);
        pieChart.setDrawRoundedSlices(true);
        pieChart.setHoleRadius(72);
        pieChart.setLogEnabled(false);
        pieChart.setDrawEntryLabels(false);
        pieChart.setDrawMarkers(false);

        date[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pieChart.setCenterText(String.valueOf(LocalDate.now()
                        .minusDays(date.length - 1).getDayOfMonth()) + "일 공부 시간");
            }
        });
        date[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pieChart.setCenterText(String.valueOf(LocalDate.now()
                        .minusDays(date.length - 2).getDayOfMonth()) + "일 공부 시간");
            }
        });
        date[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pieChart.setCenterText(String.valueOf(LocalDate.now()
                        .minusDays(date.length - 3).getDayOfMonth()) + "일 공부 시간");
            }
        });
        date[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pieChart.setCenterText(String.valueOf(LocalDate.now()
                        .minusDays(date.length - 4).getDayOfMonth()) + "일 공부 시간");
            }
        });
        date[4].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pieChart.setCenterText(String.valueOf(LocalDate.now()
                        .minusDays(date.length - 5).getDayOfMonth()) + "일 공부 시간");
            }
        });
        date[5].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pieChart.setCenterText(String.valueOf(LocalDate.now()
                        .minusDays(date.length - 6).getDayOfMonth()) + "일 공부 시간");
            }
        });
        date[6].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pieChart.setCenterText(String.valueOf(LocalDate.now()
                        .getDayOfMonth()) + "일 공부 시간");
            }
        });

        // Inflate the layout for this fragment
        return v;
    }
}
