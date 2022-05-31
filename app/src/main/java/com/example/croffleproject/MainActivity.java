package com.example.croffleproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.room.Room;

import android.os.Bundle;

import com.example.croffleproject.RoomDB.AnalyticsEntity;
import com.example.croffleproject.RoomDB.AppDatabase;
import com.example.croffleproject.RoomDB.SettingsEntity;
import com.example.croffleproject.RoomDB.TimerEntity;
import com.example.croffleproject.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase database = Room.databaseBuilder(this, AppDatabase.class,
                "Mytime-db").allowMainThreadQueries().build();

        database.timerDao().insert(new TimerEntity());
        database.settingsDao().insert(new SettingsEntity());
        database.analyticsDao().insert(new AnalyticsEntity());

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        replaceFragment(new TimerFragment());

        binding.bottomNav.setOnItemSelectedListener(item -> {

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
    private void replaceFragment(Fragment fragment){ //fragment를 변경하는 함수

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,fragment);
        fragmentTransaction.commit();
    }


}