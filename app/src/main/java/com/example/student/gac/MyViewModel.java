package com.example.student.gac;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ReportFragment;
import android.arch.lifecycle.ViewModel;

import java.util.List;


public class MyViewModel extends ViewModel {

    private MutableLiveData<String> text = new MutableLiveData<>();

    public LiveData<String> getText()
    {
        return text;
    }

    public void changeText(String t)
    {
        text.postValue(t);
    }

    public LiveData<List<User>> getAll()
    {
        UserDao dao = MyApplication.getDatabase().getUserDao();
        return dao.getAll();
    }


    public void addUser(User user) {
        UserDao dao = MyApplication.getDatabase().getUserDao();
        new Thread(() -> dao.addUser(user)).start();

    }
}
