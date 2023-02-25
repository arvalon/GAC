package com.example.student.gac;

import androidx.lifecycle.ViewModelProvider;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/** тут вводятся новые записи */
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

        model = new ViewModelProvider(this).get(MyViewModel.class);

        model.getText().observe(getViewLifecycleOwner(), text::setText);

        return view;
    }

    @Override
    public void onClick(View view) {
        User user = new User(inn.getText().toString(), "", last.getText().toString(), "");
        model.addUser(user);
    }
}

