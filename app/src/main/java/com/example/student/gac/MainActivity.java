package com.example.student.gac;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;

public class MainActivity extends AppCompatActivity {

    static final String TAG = "gac.log";

    DefaultLifecycleObserver lifecycleObserver = new DefaultLifecycleObserver() {

        @Override
        public void onCreate(@NonNull LifecycleOwner owner) {
            Log.d(TAG, "DefaultLifecycleObserver onCreate");
        }

        @Override
        public void onStart(@NonNull LifecycleOwner owner) {
            Log.d(TAG, "DefaultLifecycleObserver onStart");
        }

        @Override
        public void onResume(@NonNull LifecycleOwner owner) {
            Log.d(TAG, "DefaultLifecycleObserver onResume");
        }

        @Override
        public void onPause(@NonNull LifecycleOwner owner) {
            Log.d(TAG, "DefaultLifecycleObserver onPause");
        }

        @Override
        public void onStop(@NonNull LifecycleOwner owner) {
            Log.d(TAG, "DefaultLifecycleObserver onStop");
        }

        @Override
        public void onDestroy(@NonNull LifecycleOwner owner) {
            Log.d(TAG, "DefaultLifecycleObserver onDestroy");
        }
    };

    LifecycleEventObserver eventObserver = new LifecycleEventObserver() {

        @Override
        public void onStateChanged(@NonNull LifecycleOwner source, @NonNull Lifecycle.Event event) {
            Log.d(TAG, "LifecycleEventObserver event: " + event.getTargetState().toString());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getLifecycle().addObserver(lifecycleObserver);

        getLifecycle().addObserver(eventObserver);

        Foo foo = new Foo();
        foo.helloWorld();
    }

    @Override
    protected void onDestroy() {

        super.onDestroy();

        getLifecycle().removeObserver(lifecycleObserver);
        getLifecycle().removeObserver(eventObserver);

    }
}
