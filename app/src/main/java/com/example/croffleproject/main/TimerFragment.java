package com.example.croffleproject.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.example.croffleproject.R;
import com.google.android.material.bottomsheet.BottomSheetDialog;

///**
// * A simple {@link Fragment} subclass.
// * Use the {@link TimerFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class TimerFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ImageButton timeSettingButton;
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_timer, container, false);
        timeSettingButton = root.findViewById(R.id.timersettingbtn);

        View view1 = inflater.inflate(R.layout.timersettingbottomsheet, null);
        timeSettingButton = root.findViewById(R.id.timersettingbtn);

        timeSettingButton.setOnClickListener(view -> {
                timerSettingDialog dialog = new timerSettingDialog();
                dialog.show(getActivity().getSupportFragmentManager(), "dialog");
                Log.e("view","is viewed");

             });
            return root;

       }
}
