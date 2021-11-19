package com.example.student.gac;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static final String TAG = "gac.log";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String msg = "BuildConfig.DEBUG: "+BuildConfig.DEBUG;
        Log.d(TAG,msg);
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
