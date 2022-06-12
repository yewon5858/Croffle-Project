package com.example.croffleproject.main;

<<<<<<< HEAD
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.room.Room;

=======
import android.content.Context;
import android.os.Bundle;
>>>>>>> 6535136c2834dd72e5b07b6b77f02df1a1167edb
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

import com.example.croffleproject.DetectionActivity;
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
    View root;
    ImageButton ultra_start;
    ImageButton timeSettingButton;

<<<<<<< HEAD
    @Nullable
=======
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

>>>>>>> 6535136c2834dd72e5b07b6b77f02df1a1167edb
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        // Inflate the layout for this fragment
<<<<<<< HEAD
        root = inflater.inflate(R.layout.fragment_timer, container, false);
=======
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
>>>>>>> 6535136c2834dd72e5b07b6b77f02df1a1167edb
        timeSettingButton = root.findViewById(R.id.timersettingbtn);
        ultra_start = root.findViewById(R.id.start_timer_btn);

        ultra_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(),DetectionActivity.class); //fragment라서 activity intent와는 다른 방식
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        timeSettingButton.setOnClickListener(view -> {
<<<<<<< HEAD
            timerSettingDialog dialog = new timerSettingDialog();
            dialog.show(getActivity().getSupportFragmentManager(), "dialog");
//            BottomSheetDialog d = new BottomSheetDialog(getActivity(),R.style.DialogStyle);
//            d.requestWindowFeature(Window.FEATURE_NO_TITLE);
//            d.setContentView(R.layout.timersettingbottomsheet);
//            d.show();
//            d.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
//            d.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            Log.e("view", "is viewed");
        });
        return root;
=======

            timerSettingDialog dialog = new timerSettingDialog();
            dialog.show(getActivity().getSupportFragmentManager(), "dialog");
            Log.e("view","is viewed");

        });
        return root;

    }
>>>>>>> 6535136c2834dd72e5b07b6b77f02df1a1167edb

    }

}

