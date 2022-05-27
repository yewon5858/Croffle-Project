package com.example.croffleproject.main;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.room.Room;

import android.renderscript.ScriptGroup;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.Toast;

import com.example.croffleproject.R;
import com.example.croffleproject.RoomDB.AppDatabase;
import com.example.croffleproject.RoomDB.TimerTableDao;
import com.example.croffleproject.RoomDB.TimerTableEntity;
import com.example.croffleproject.databinding.ActivityMainBinding;
import com.example.croffleproject.databinding.FragmentAddtodoBinding;
import com.example.croffleproject.databinding.FragmentDetailEditBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.nex3z.togglebuttongroup.MultiSelectToggleGroup;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

//
///**
// * A simple {@link Fragment} subclass.
// * Use the {@link addTodoFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class addTodoFragment extends Fragment {

    private static final String LOG_TAG = addTodoFragment.class.getSimpleName();
    private FragmentAddtodoBinding binding = null;

    public addTodoFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // View root = inflater.inflate(R.layout.fragment_addtodo, container, false);

        binding = FragmentAddtodoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        final AppDatabase database = Room.databaseBuilder(this.getContext(), AppDatabase.class, "todoTimer").build();

        database.timerTableDao().getAll().observe(getViewLifecycleOwner(), timers -> { //todos로 데이터가 변경될 때마다 들어오게 됨(observe)
            //timers.toString();

            init();
        });

        //시간관련 입력
       String hour = binding.hourET.getText().toString();
       String minute = binding.minuteET.getText().toString();
       String second = binding.secondET.getText().toString();
        //시간정보를 int로 변환
    //    int hourInt = Integer.parseInt(String.valueOf(binding.hourET.getText()));
   //     int minuteInt = Integer.parseInt(String.valueOf(binding.minuteET.getText()));
   //     int secondInt = Integer.parseInt(String.valueOf(binding.secondET.getText()));

//
//       // if (hourInt > 24 || minuteInt > 59 || secondInt >  59) {
//            Toast.makeText(this.getContext(),"24시간,59분,59초 이내의 숫자만 입력이 가능합니다. 다시 입력해주세요!",Toast.LENGTH_SHORT);
//     //   }
//   //     else{
            String goalTime = hour+minute+second;
            binding.addButton.setOnClickListener(view -> {
                new InsertAsyncTask(database.timerTableDao())
                        .execute(new TimerTableEntity(binding.timerTitle.getText().toString(),goalTime));

                //mResultTextView.setText(getAllString(db)); // 화면 갱신
            });

   //     }


        return root;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HideBottomNavi(true);
        Log.e("hide","is hide");

    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        HideBottomNavi(false);
        Log.e("show","is show");
    }

    public void HideBottomNavi(boolean state){// bottomnav 임시로 숨기는 함수
        BottomNavigationView bottomNavigation = getActivity().findViewById(R.id.bottomNav);
        if(state) bottomNavigation.setVisibility(View.GONE);
        else bottomNavigation.setVisibility(View.VISIBLE);
    }

    //AsyncTask로 데이터를 불러옴
    private static class InsertAsyncTask extends AsyncTask<TimerTableEntity,Void,Void> {
        private TimerTableDao timerTableDao;

        public InsertAsyncTask(TimerTableDao timerTableDao) {
            this.timerTableDao = timerTableDao;
        }

        @Override
        protected Void doInBackground(TimerTableEntity... timers) {

            timerTableDao.insert(timers[0]);
            Log.e("is add",timers[0].toString());
            return null;
        }
    }
    // 다중 선택 토글의 내용 확인
    private void init() {
        MultiSelectToggleGroup multi = null;
        multi = binding.groupWeekdays.findViewById(R.id.group_weekdays);
        boolean data[] = new boolean[8];
        multi.setOnCheckedChangeListener(new MultiSelectToggleGroup.OnCheckedStateChangeListener() {
            @Override
            public void onCheckedStateChanged(MultiSelectToggleGroup group, int checkedId, boolean isChecked) {
                Log.v(LOG_TAG, "onCheckedStateChanged(): group.getCheckedIds() = " + group.getCheckedIds()+"datadata");

            }
        });
    }

//    // TODO: Rename parameter arguments, choose names that match
//    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
//    private static final String ARG_PARAM1 = "param1";
//    private static final String ARG_PARAM2 = "param2";
//
//    // TODO: Rename and change types of parameters
//    private String mParam1;
//    private String mParam2;


//
//    /**
//     * Use this factory method to create a new instance of
//     * this fragment using the provided parameters.
//     *
//     * @param param1 Parameter 1.
//     * @param param2 Parameter 2.
//     * @return A new instance of fragment addTodoFragment.
//     */
//    // TODO: Rename and change types and number of parameters
//    public static addTodoFragment newInstance(String param1, String param2) {
//        addTodoFragment fragment = new addTodoFragment();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//            mParam1 = getArguments().getString(ARG_PARAM1);
//            mParam2 = getArguments().getString(ARG_PARAM2);
//        }
//    }


}