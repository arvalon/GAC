package com.example.student.gac;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.annotation.NonNull;

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

    public User(@NonNull String inn, String firstName, String lastName, String dob) {
        this.inn = inn;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
    }

    @NonNull
    public String getInn() {
        return inn;
    }

    public void setInn(@NonNull String inn) {
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
