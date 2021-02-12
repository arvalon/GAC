package com.example.student.gac;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

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

    public LiveData<List<User>> getAll() {
        UserDao dao = MyApplication.getDatabase().getUserDao();
        return dao.getAll();
    }

    public int getUserCount(){
        return MyApplication.getDatabase().getUserDao().getAll().getValue().size();
    }

    public void addUser(User user) {
        UserDao dao = MyApplication.getDatabase().getUserDao();
        new Thread(() -> dao.addUser(user)).start();
    }

    public User getUserByID(String inn){
        return MyApplication.getDatabase().getUserDao().getUser(inn);
    }
}
