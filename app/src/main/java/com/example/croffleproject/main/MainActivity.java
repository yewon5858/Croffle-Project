package com.example.croffleproject.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.croffleproject.AnalyticsFragment;
import com.example.croffleproject.R;
import com.example.croffleproject.SettingFragment;
import com.example.croffleproject.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {


    public ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(activityMainBinding.getRoot());
        replaceFragment(new TimerFragment());

        activityMainBinding.bottomNav.setOnItemSelectedListener(item -> {

            switch (item.getItemId()){
                case R.id.item_timer:
                    replaceFragment(new TimerFragment());
                    break;
                case R.id.item_analytics:
                    replaceFragment(new AnalyticsFragment());
                    break;
                case R.id.item_settings:
                    replaceFragment(new SettingFragment());
                    break;
            }
            return true;
        });
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        HideBottomNavi(false);
        Log.e("show","is show");
    }
    public void replaceFragment(Fragment fragment){ //fragment를 변경하는 함수

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }

    public void HideBottomNavi(boolean state){
        if(state) activityMainBinding.bottomNav.setVisibility(View.GONE);
        else activityMainBinding.bottomNav.setVisibility(View.VISIBLE);
    }


}