package com.example.student.gac;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class Fragment1 extends Fragment implements View.OnClickListener {
    private MyViewModel model;

    TextView text;
    EditText inn;
    EditText last;
    Button add;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment1, container);

        text = view.findViewById(R.id.text);
        inn = view.findViewById(R.id.inn);
        last = view.findViewById(R.id.last);
        add = view.findViewById(R.id.add);

        add.setOnClickListener(this);

        model = ViewModelProviders.of(getActivity()).get(MyViewModel.class);

        model.getText().observe(this, text::setText);

        return view;
    }

    @Override
    public void onClick(View view) {
        User user = new User(inn.getText().toString(), "", last.getText().toString(), "");
        model.addUser(user);
    }
}

