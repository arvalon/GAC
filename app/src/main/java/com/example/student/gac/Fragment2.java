package com.example.student.gac;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

import static com.example.student.gac.MainActivity.TAG;

public class Fragment2 extends Fragment {

    private MyViewModel model;

    private UserObserver userObserver;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment2, container);
        model = ViewModelProviders.of(getActivity()).get(MyViewModel.class);

        userObserver = new UserObserver();

        //model.getAll().observe(getViewLifecycleOwner(), users -> Log.d(TAG,"Количество пользователей: "+users.size()));
        model.getAll().observe(getViewLifecycleOwner(), new UserObserver());

        view.findViewById(R.id.button1).setOnClickListener(v -> {


            try{
                Log.d(TAG,"Количество пользователей: "+model.getUserCount());

            }catch (NullPointerException ex){
                Log.d(TAG,"Получение количества пользователей: "+ex.getMessage());
                ex.printStackTrace();
            }
        });

        view.findViewById(R.id.button2).setOnClickListener(v -> {
            try{
                User user = model.getUserByID("1");

                Log.d(TAG,"Пользователь с ID №1, lastname: "+user.getLastName());

            }catch (NullPointerException ex){
                Log.d(TAG,"Получение пользователя №1: "+ex.getMessage());
                ex.printStackTrace();
            }
        });

        return view;
    }
}
