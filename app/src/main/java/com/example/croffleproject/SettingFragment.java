package com.example.croffleproject;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.room.Database;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;

import com.example.croffleproject.RoomDB.AppDatabase;
import com.example.croffleproject.RoomDB.SettingsEntity;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SettingFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SettingFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    // id 불러올 변수
    private Context Sct;
    private Switch saving;
    private Switch noti;
    private Switch vibe;
    private Switch sound;

    private int PhoneId = 57;
    private AppDatabase appDatabase;

    public SettingFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SettingFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SettingFragment newInstance(String param1, String param2) {
        SettingFragment fragment = new SettingFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_setting, container, false);

        saving = v.findViewById(R.id.Power_mode);
        noti = v.findViewById(R.id.notice);
        vibe = v.findViewById(R.id.vibration);
        sound = v.findViewById(R.id.sound);

        Sct = container.getContext();
        appDatabase = AppDatabase.getInstance(Sct);
        appDatabase.settingsDao().insert(new SettingsEntity(
                PhoneId, saving.isChecked(), noti.isChecked(), vibe.isChecked(), sound.isChecked()))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSuccess(aLong -> {
                    appDatabase.settingsDao().getTable(PhoneId)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .doOnSuccess(settingsEntity -> {
                                saving.setChecked(settingsEntity.getSaving());
                                noti.setChecked(settingsEntity.getNotification());
                                vibe.setChecked(settingsEntity.getVibration());
                                sound.setChecked(settingsEntity.getSound());
                            })
                            .subscribe();
                })
                .subscribe();



        saving.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    appDatabase.settingsDao().getTable(PhoneId)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .doOnSuccess(settingsEntity -> {
                                settingsEntity.setSaving(true);
                                appDatabase.settingsDao().update(settingsEntity)
                                        .subscribeOn(Schedulers.io())
                                        .observeOn(AndroidSchedulers.mainThread())
                                        .subscribe();
                            })
                            .doOnError(throwable -> throwable.toString())
                            .subscribe();
                } else {
                    appDatabase.settingsDao().getTable(PhoneId)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .doOnSuccess(settingsEntity -> {
                                settingsEntity.setSaving(false);
                                appDatabase.settingsDao().update(settingsEntity)
                                        .subscribeOn(Schedulers.io())
                                        .observeOn(AndroidSchedulers.mainThread())
                                        .subscribe();
                            })
                            .doOnError(throwable -> throwable.toString())
                            .subscribe();
                }
            }
        });

        noti.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    appDatabase.settingsDao().getTable(PhoneId)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .doOnSuccess(settingsEntity -> {
                                settingsEntity.setNotification(true);
                                appDatabase.settingsDao().update(settingsEntity)
                                        .subscribeOn(Schedulers.io())
                                        .observeOn(AndroidSchedulers.mainThread())
                                        .subscribe();
                            })
                            .doOnError(throwable -> throwable.toString())
                            .subscribe();
                } else {
                    appDatabase.settingsDao().getTable(PhoneId)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .doOnSuccess(settingsEntity -> {
                                settingsEntity.setNotification(false);
                                appDatabase.settingsDao().update(settingsEntity)
                                        .subscribeOn(Schedulers.io())
                                        .observeOn(AndroidSchedulers.mainThread())
                                        .subscribe();
                            })
                            .doOnError(throwable -> throwable.toString())
                            .subscribe();
                }
            }
        });

        vibe.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    appDatabase.settingsDao().getTable(PhoneId)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .doOnSuccess(settingsEntity -> {
                                settingsEntity.setVibration(true);
                                appDatabase.settingsDao().update(settingsEntity)
                                        .subscribeOn(Schedulers.io())
                                        .observeOn(AndroidSchedulers.mainThread())
                                        .subscribe();
                            })
                            .doOnError(throwable -> throwable.toString())
                            .subscribe();
                } else {
                    appDatabase.settingsDao().getTable(PhoneId)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .doOnSuccess(settingsEntity -> {
                                settingsEntity.setVibration(false);
                                appDatabase.settingsDao().update(settingsEntity)
                                        .subscribeOn(Schedulers.io())
                                        .observeOn(AndroidSchedulers.mainThread())
                                        .subscribe();
                            })
                            .doOnError(throwable -> throwable.toString())
                            .subscribe();
                }
            }
        });

        sound.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    appDatabase.settingsDao().getTable(PhoneId)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .doOnSuccess(settingsEntity -> {
                                settingsEntity.setSound(true);
                                appDatabase.settingsDao().update(settingsEntity)
                                        .subscribeOn(Schedulers.io())
                                        .observeOn(AndroidSchedulers.mainThread())
                                        .subscribe();
                            })
                            .doOnError(throwable -> throwable.toString())
                            .subscribe();
                } else {
                    appDatabase.settingsDao().getTable(PhoneId)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .doOnSuccess(settingsEntity -> {
                                settingsEntity.setSound(false);
                                appDatabase.settingsDao().update(settingsEntity)
                                        .subscribeOn(Schedulers.io())
                                        .observeOn(AndroidSchedulers.mainThread())
                                        .subscribe();
                            })
                            .doOnError(throwable -> throwable.toString())
                            .subscribe();
                }
            }
        });

        // Inflate the layout for this fragment
        return v;
    }
}