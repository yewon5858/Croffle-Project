package com.example.croffleproject.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.croffleproject.R;
import com.example.croffleproject.databinding.ActivityMainBinding;
import com.example.croffleproject.databinding.FragmentAddtodoBinding;
import com.example.croffleproject.databinding.FragmentEditBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class editFragment extends Fragment {
    MainActivity mainActivity = (MainActivity)MainActivity.mContext;
    FragmentEditBinding editBinding = null;
    public editFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        editBinding = FragmentEditBinding.inflate(inflater, container, false);
        View root = editBinding.getRoot();
        mainActivity.HideBottomNavi(true);
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








}