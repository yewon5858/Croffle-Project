package com.example.croffleproject.main;

import android.os.Bundle;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.croffleproject.R;
import com.example.croffleproject.databinding.ActivityMainBinding;
import com.example.croffleproject.databinding.FragmentAddtodoBinding;
import com.example.croffleproject.databinding.TimersettingbottomsheetBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;



public class timerSettingDialog extends BottomSheetDialogFragment {

    private TimersettingbottomsheetBinding binding;

    private Fragment addTodoFragment = new addTodoFragment();


    public timerSettingDialog() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        binding = TimersettingbottomsheetBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        toggleBottomSheet();
        // View root = inflater.inflate(R.layout.timersettingbottomsheet, container, false);
        //  toggleBottomSheet(root);
        return view;
    }
    public void toggleBottomSheet(){

        binding.timeraddlayout.setOnClickListener(view -> {
            ChangeFragment(addTodoFragment);
            dismiss();
            Log.e("add","is add");
        });

        binding.timereditlayout.setOnClickListener(view -> {
            ChangeFragment(addTodoFragment);
            dismiss();
            Log.e("edit","is edit");
        });

        binding.timerswaplayout.setOnClickListener(view -> {
            ChangeFragment(addTodoFragment);
            dismiss();
            Log.e("swap","is swap");
        });

//        add = viewer.findViewById(R.id.timeraddlayout);
//        add.setOnClickListener(view -> {
//            Log.e("add","is add");
//        });
//
//
//        edit = viewer.findViewById(R.id.timereditlayout);
//        edit.setOnClickListener(view -> {
//            Log.e("edit","is edit");
//        });
//
//        swap = viewer.findViewById(R.id.timerswaplayout);
//        swap.setOnClickListener(view ->  {
//            Log.e("swap","is swap");
//        });

    }
    void ChangeFragment(Fragment fragment){
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment);
        transaction.addToBackStack(null);
        transaction.commit();

    }

}