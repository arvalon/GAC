package com.example.student.gac;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import static androidx.room.OnConflictStrategy.REPLACE;

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
