package com.example.student.gac;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "users")
public class User {

    @NonNull
    @PrimaryKey
    private String inn;

    @ColumnInfo(name="first_name")
    private String firstName;

    @ColumnInfo(name="last_name")
    private String lastName;
    private String dob;

    public User(String inn, String firstName, String lastName, String dob) {
        this.inn = inn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }
}
