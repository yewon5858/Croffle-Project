package com.example.croffleproject.main;

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

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.croffleproject.DetectionActivity;
import com.example.croffleproject.R;
import com.example.croffleproject.RoomDB.AppDatabase;
import com.example.croffleproject.RoomDB.TimerTableDao;
import com.example.croffleproject.RoomDB.TimerTableEntity;
import com.google.android.material.bottomsheet.BottomSheetDialog;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link TimerFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class TimerFragment extends Fragment {
    View root;
    ImageButton ultra_start;
    ImageButton timeSettingButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        root = inflater.inflate(R.layout.fragment_timer, container, false);
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
/*
>>>>>>> origin/PJC
        timeSettingButton.setOnClickListener(view -> {
            timerSettingDialog dialog = new timerSettingDialog();
            dialog.show(getActivity().getSupportFragmentManager(), "dialog");
//            BottomSheetDialog d = new BottomSheetDialog(getActivity(),R.style.DialogStyle);
//            d.requestWindowFeature(Window.FEATURE_NO_TITLE);
//            d.setContentView(R.layout.timersettingbottomsheet);
//            d.show();
//            d.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
//            d.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            Log.e("view", "is viewed");
        });*/
        return root;

    }

}

