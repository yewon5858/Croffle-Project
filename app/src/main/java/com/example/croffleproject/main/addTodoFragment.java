package com.example.croffleproject.main;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.croffleproject.R;
import com.example.croffleproject.RoomDB.AppDatabase;
import com.example.croffleproject.RoomDB.TimerEntity;
import com.example.croffleproject.databinding.FragmentAddtodoBinding;
import com.nex3z.togglebuttongroup.MultiSelectToggleGroup;
import com.nex3z.togglebuttongroup.button.CircularToggle;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

//
///**
// * A simple {@link Fragment} subclass.
// * Use the {@link addTodoFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class addTodoFragment extends Fragment {

    MainActivity mainActivity = (MainActivity)MainActivity.mContext;
    private static final String LOG_TAG = addTodoFragment.class.getSimpleName();
    private FragmentAddtodoBinding binding = null;
    Context context;
    AppDatabase appDatabase;
    String title;
    String hour;
    String minute;
    String second;
    String goalTime;
    boolean[] weekCycleOn = new boolean[7];
    ArrayList<String> repeat = new ArrayList<>();

    public addTodoFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentAddtodoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        init();

        context = container.getContext();
        appDatabase = AppDatabase.getInstance(context);


        binding.addButton.setOnClickListener(view -> {
            for(int i = 0 ; i< weekCycleOn.length;i++){
                repeat.add(weekCycleOn[i]+"");
            }
            for(int i =0;i<7;i++){
                Log.e(repeat+", "+weekCycleOn[i]+", "+i,"is weekCycleOn");
            }
            title = binding.timerTitle.getText().toString();
            //시간관련 입력
            hour = binding.hourET.getText().toString();
            minute = binding.minuteET.getText().toString();
            second = binding.secondET.getText().toString();
            goalTime = hour+minute+second;

            appDatabase.timerDao().insert(new TimerEntity(
                    title,goalTime,repeat))
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnError(Throwable->Throwable.toString())
                    .subscribe();
        });

        return root;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainActivity.HideBottomNavi(true);
        Log.e("hide","is hide");

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        mainActivity.HideBottomNavi(false);
        Log.e("show","is show");
    }

    // 다중 선택 토글의 내용 확인
    private void init() {
        MultiSelectToggleGroup multi = null;
        multi = binding.groupWeekdays.findViewById(R.id.group_weekdays);
        CircularToggle sun = multi.findViewById(R.id.sun);
        CircularToggle mon = multi.findViewById(R.id.mon);
        CircularToggle tue = multi.findViewById(R.id.tue);
        CircularToggle wen = multi.findViewById(R.id.wen);
        CircularToggle thu = multi.findViewById(R.id.thu);
        CircularToggle fri = multi.findViewById(R.id.fri);
        CircularToggle sat = multi.findViewById(R.id.sat);



        multi.setOnCheckedChangeListener(new MultiSelectToggleGroup.OnCheckedStateChangeListener() {

            @Override
            public void onCheckedStateChanged(MultiSelectToggleGroup group, int checkedId, boolean isChecked) {
                // Log.v(LOG_TAG, "onCheckedStateChanged(): group.getCheckedIds() = " + group.getCheckedIds());

                if(checkedId == sun.getId() && isChecked){
                    weekCycleOn[0] = true;
                    Log.e("","Checked sun!!!");
                }
                if(checkedId == mon.getId() && isChecked) {
                    weekCycleOn[1] = true;
                    Log.e("", "Checked mon!!!");
                }
                if (checkedId == tue.getId() && isChecked) {
                    weekCycleOn[2] = true;
                    Log.e("", "Checked tue!!!");
                }
                if (checkedId == wen.getId() && isChecked) {
                    weekCycleOn[3] = true;
                    Log.e("", "Checked wen!!!");
                }

                if (checkedId == thu.getId() && isChecked) {
                    weekCycleOn[4] = true;
                    Log.e("", "Checked thu!!!");
                }
                if (checkedId == fri.getId() && isChecked) {
                    weekCycleOn[5] = true;
                    Log.e("", "Checked sat!!!");
                }

                if (checkedId == sat.getId() && isChecked) {
                    weekCycleOn[6] = true;
                    Log.e("", "Checked sat!!!");
                }

            }
        });
    }

}