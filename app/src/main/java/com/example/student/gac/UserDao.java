package com.example.student.gac;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface UserDao {

    @Query("select * from users")
    LiveData<List<User>> getAll();

    @Query("select * from users where inn = :inn")
    User getUser(String inn);

    @Update
    void update(User user);

    @Delete
    void delete(User user);

    @Insert(onConflict = REPLACE)
    void addAll(List<User> users);

    @Insert(onConflict = REPLACE)
    void  addUser(User user);

}
