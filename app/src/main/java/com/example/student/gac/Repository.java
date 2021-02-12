package com.example.student.gac;


import androidx.room.Room;
import androidx.room.RoomDatabase;

public class Repository {

    private Repository() {}

    private static Repository instance;

    public static Repository getInstance() {
        if(instance == null) {
            instance = new Repository();
        }
        return instance;
    }

    private static MyDatabase database;

    public MyDatabase getDatabase() {
        if(database == null) {
            database = Room.databaseBuilder(MyApplication.getInstance(), MyDatabase.class, "database").build();
        }

        return database;
    }
}
