package com.example.croffleproject.main;

import android.os.Bundle;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;

import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.croffleproject.R;
import com.example.croffleproject.databinding.ActivityMainBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;


public class timerSettingDialog extends BottomSheetDialogFragment {

    private LinearLayoutCompat add;
    private LinearLayoutCompat edit;
    private LinearLayoutCompat swap;

    public timerSettingDialog() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.timersettingbottomsheet, container, false);
        toggleBottomSheet(root);

        return root;
    }
    public void toggleBottomSheet(View viewer){

        add = viewer.findViewById(R.id.timeraddlayout);
        add.setOnClickListener(view -> {
            Log.e("add","is add");
                    });

        edit = viewer.findViewById(R.id.timereditlayout);
        edit.setOnClickListener(view -> {
            Log.e("edit","is edit");
        });


        swap = viewer.findViewById(R.id.timerswaplayout);
        swap.setOnClickListener(view ->  {
            Log.e("swap","is swap");
        });

    }

}