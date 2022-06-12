package com.example.croffleproject.main;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.croffleproject.R;
import com.example.croffleproject.RoomDB.AppDatabase;
import com.example.croffleproject.RoomDB.TimerEntity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
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
    String[] data ={"data1","data2","data3","data4"
            ,"data5","data6","data7","data8","data9"
            ,"data10","data11","data12","data13","data14"
            ,"data15","data16","data17","data18","data19"};


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ImageButton timeSettingButton;
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_timer, container, false);
        context = container.getContext();
        appDatabase = AppDatabase.getInstance(context);

        recyclerView = root.findViewById(R.id.recycler_view);

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
                            Toast.makeText(getContext(),"Selected : " + s,Toast.LENGTH_SHORT).show();
                        }
                    };

                    recyclerView.setLayoutManager(new LinearLayoutManager(context));
                    timerAdapter = new TimerAdapter((ArrayList<String>) timerTitles,itemClickListener);
                    recyclerView.setAdapter(timerAdapter);
                })
                .subscribe();

        Log.e(String.valueOf(timerTitles),"is Timertitles");

//        for (int i = 0; i< data.length;i++){
//            arrayList.add(data[i]);
//        }
//        arrayList = (ArrayList<String>) timerTitles;
//        Log.e(String.valueOf(arrayList),"is arrayList");

        itemClickListener = new ItemClickListener() {
            @Override
            public void onClick(String s) {
                recyclerView.post(new Runnable() {
                    @Override
                    public void run() {
                        timerAdapter.notifyDataSetChanged();
                    }
                });
                Toast.makeText(getContext(),"Selected : " + s,Toast.LENGTH_SHORT).show();
            }
        };

        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        timerAdapter = new TimerAdapter(arrayList,itemClickListener);
        recyclerView.setAdapter(timerAdapter);

        // 타이머 설정 버튼 (타이머추가, 타이머 수정 및 삭제, 타이머 순서 변경)
        timeSettingButton = root.findViewById(R.id.timersettingbtn);

        timeSettingButton.setOnClickListener(view -> {

            timerSettingDialog dialog = new timerSettingDialog();
            dialog.show(getActivity().getSupportFragmentManager(), "dialog");
//            BottomSheetDialog d = new BottomSheetDialog(getActivity(),R.style.DialogStyle);
//            d.requestWindowFeature(Window.FEATURE_NO_TITLE);
//            d.setContentView(R.layout.timersettingbottomsheet);
//            d.show();
//            d.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
//            d.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//

            Log.e("view","is viewed");

        });
        return root;

    }


}

