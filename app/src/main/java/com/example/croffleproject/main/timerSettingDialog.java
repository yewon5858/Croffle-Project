package com.example.croffleproject.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.croffleproject.R;
import com.example.croffleproject.databinding.TimersettingbottomsheetBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;



public class timerSettingDialog extends BottomSheetDialogFragment {

    private TimersettingbottomsheetBinding binding;

    private Fragment addTodoFragment = new addTodoFragment();
    private Fragment editFragment = new editFragment();
    private Fragment SortFragment = new SortFragment();
    public timerSettingDialog() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //binding을 사용
        binding = TimersettingbottomsheetBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        // bottom Sheet 내부 토글
        toggleBottomSheet();
        return view;
    }
    // 타이머 설정 관련 bottom sheet 함수
    public void toggleBottomSheet(){

        binding.timeraddlayout.setOnClickListener(view -> {
            ChangeFragment(addTodoFragment);
            dismiss();
            Log.e("add","is add");
        });

        binding.timereditlayout.setOnClickListener(view -> {
            ChangeFragment(editFragment);
            dismiss();
            Log.e("edit","is edit");
        });

        binding.timerswaplayout.setOnClickListener(view -> {
            ChangeFragment(SortFragment);
            dismiss();
            Log.e("swap","is swap");
        });

// binding 사용 전
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