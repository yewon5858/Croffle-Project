package com.example.croffleproject.main;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.croffleproject.R;
import com.example.croffleproject.databinding.ActivityMainBinding;
import com.example.croffleproject.databinding.FragmentAddtodoBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

//
///**
// * A simple {@link Fragment} subclass.
// * Use the {@link addTodoFragment#newInstance} factory method to
// * create an instance of this fragment.
// */
public class addTodoFragment extends Fragment {

    private FragmentAddtodoBinding binding;

    public addTodoFragment() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // View root = inflater.inflate(R.layout.fragment_addtodo, container, false);

        binding = FragmentAddtodoBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        return view;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HideBottomNavi(true);
        Log.e("hide","is hide");

      //  Canceladd();
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        HideBottomNavi(false);
        //Canceladd();
        Log.e("show","is show");
    }

    public void HideBottomNavi(boolean state){

        BottomNavigationView bottomNavigation = getActivity().findViewById(R.id.bottomNav);
        if(state) bottomNavigation.setVisibility(View.GONE);
        else bottomNavigation.setVisibility(View.VISIBLE);
    }
//    private void Canceladd() {
//        binding.cancelBtn.setOnClickListener(view -> {
//            Intent intent = new Intent(getActivity(),MainActivity.class);
//            startActivity(intent);
//
//        });
//    }
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