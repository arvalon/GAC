package com.example.student.gac;

import android.util.Log;
import androidx.lifecycle.Observer;
import java.util.List;

import static com.example.student.gac.MainActivity.TAG;

class UserObserver implements Observer<List<User>> {

    @Override
    public void onChanged(List<User> users) {
        Log.d(TAG,"Количество пользователей: "+users.size());
    }
}
