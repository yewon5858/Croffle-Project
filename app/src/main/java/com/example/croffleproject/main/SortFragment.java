package com.example.croffleproject.main;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.croffleproject.R;
import com.example.croffleproject.databinding.FragmentSortBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SortFragment extends Fragment {

    FragmentSortBinding sortBinding = null;
    public SortFragment() {
        // Required empty public constructor
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        sortBinding = FragmentSortBinding.inflate(inflater, container, false);
        View root = sortBinding.getRoot();
        return root;
    }

    public void HideBottomNavi(boolean state){// bottomnav 임시로 숨기는 함수
        BottomNavigationView bottomNavigation = getActivity().findViewById(R.id.bottomNav);
        if(state) bottomNavigation.setVisibility(View.GONE);
        else bottomNavigation.setVisibility(View.VISIBLE);
    }

}