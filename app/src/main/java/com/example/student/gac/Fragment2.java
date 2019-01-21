package com.example.student.gac;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class Fragment2 extends Fragment {
    private MyViewModel model;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment2, container);
        model = ViewModelProviders.of(getActivity()).get(MyViewModel.class);

        model.getAll().observe(this, l -> {
            Toast.makeText(getActivity(), "Hello!", Toast.LENGTH_SHORT).show();
        });

        return view;
    }
}
