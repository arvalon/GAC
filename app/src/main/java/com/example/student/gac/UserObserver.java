package com.example.student.gac;

import android.util.Log;
import androidx.lifecycle.Observer;
import java.util.List;

import static com.example.student.gac.MainActivity.TAG;

class UserObserver implements Observer<List<User>> {

    @Override
    public void onChanged(List<User> users) {
        Log.d(TAG,"UserObserver, Количество пользователей: "+users.size());

        for (int i = 0; i < users.size(); i++){
            Log.d(TAG, users.get(i).getFirstName()+" "+users.get(i).getLastName());
        }
    }
}
