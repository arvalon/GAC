package com.example.student.gac;


import android.app.Application;
import android.arch.persistence.room.Room;

public class MyApplication extends Application {

    public static MyApplication instance;

    private static MyDatabase database;

    public static MyDatabase getDatabase()
    {
        if (database == null)
            database = Room.databaseBuilder(
                    instance,
                    MyDatabase.class,
                    "database"
            ).build();
        return database;
    }

    public static MyApplication getInstance()
    {
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
