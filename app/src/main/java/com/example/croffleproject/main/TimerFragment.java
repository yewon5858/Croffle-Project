package com.example.croffleproject.main;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.croffleproject.R;
import com.example.croffleproject.RoomDB.AppDatabase;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link TimerFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class TimerFragment extends Fragment {

    RecyclerView recyclerView;
    ItemClickListener itemClickListener;
    TimerAdapter timerAdapter;
    AppDatabase appDatabase;
    Context context;
    List<String> timerTitles;

    ImageButton StartButton;
    Spinner modeSelect;

    TextView timerSet;
    TextView modeSet;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ImageButton timeSettingButton;
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_timer, container, false);
        context = container.getContext();
        appDatabase = AppDatabase.getInstance(context);
        recyclerView = root.findViewById(R.id.recycler_view);

        StartButton = root.findViewById(R.id.start_timer_btn);
        modeSelect = root.findViewById(R.id.selectmode);

        timerSet = root.findViewById(R.id.timerset);
        modeSet = root.findViewById(R.id.modeset);

        ArrayList<String> arrayList = new ArrayList<>();

        // timer title data 받아오기
        appDatabase.timerDao().TimerNames()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSuccess(strings -> {
                    timerTitles = strings;
                    Log.e(String.valueOf(timerTitles),"is titles");

                    itemClickListener = new ItemClickListener() {
                        @Override
                        public void onClick(String s) {
                            recyclerView.post(new Runnable() {
                                @Override
                                public void run() {
                                    timerAdapter.notifyDataSetChanged();
                                }
                            });
                            timerSet.setText(s);
                            Toast.makeText(getContext(),"Selected : " + s,Toast.LENGTH_SHORT).show();
                        }
                    };
                    recyclerView.setLayoutManager(new LinearLayoutManager(context));
                    timerAdapter = new TimerAdapter((ArrayList<String>) timerTitles,itemClickListener);
                    recyclerView.setAdapter(timerAdapter);
                })
                .subscribe();

        Log.e(String.valueOf(timerTitles),"is Timertitles");

        StartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timerSet.getContext();
                modeSet.getContext();
            }
        });

//        itemClickListener = new ItemClickListener() {
//            @Override
//            public void onClick(String s) {
//                recyclerView.post(new Runnable() {
//                    @Override
//                    public void run() {
//                        timerAdapter.notifyDataSetChanged();
//                    }
//                });
//                Toast.makeText(getContext(),"Selected : " + getContext().toString(),Toast.LENGTH_SHORT).show();
//
//            }
//        };

//        recyclerView.setLayoutManager(new LinearLayoutManager(context));
//        timerAdapter = new TimerAdapter(arrayList,itemClickListener);
//        recyclerView.setAdapter(timerAdapter);

        modeSelect.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                modeSet.setText(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        StartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



        // 타이머 설정 버튼 (타이머추가, 타이머 수정 및 삭제, 타이머 순서 변경)
        timeSettingButton = root.findViewById(R.id.timersettingbtn);

        timeSettingButton.setOnClickListener(view -> {

            timerSettingDialog dialog = new timerSettingDialog();
            dialog.show(getActivity().getSupportFragmentManager(), "dialog");
            Log.e("view","is viewed");

        });
        return root;

    }


}

