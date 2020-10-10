package com.example.a02databinding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;

import android.os.Bundle;

import com.example.a02databinding.lifecycle.LocationListener;

public class LifecycleActivity extends AppCompatActivity {


    private Lifecycle lifecycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);

        lifecycle = getLifecycle();
        LocationListener listener =new LocationListener(this,getLifecycle());
        lifecycle.addObserver(listener);
    }
}