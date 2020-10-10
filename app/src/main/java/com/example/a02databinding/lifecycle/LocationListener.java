package com.example.a02databinding.lifecycle;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import javax.security.auth.callback.Callback;

import static androidx.lifecycle.Lifecycle.State.STARTED;


public class LocationListener implements LifecycleObserver {
    private final Lifecycle lifecycle;
    private final Context context;
    private boolean enabled = false;

    public LocationListener(Context context, Lifecycle lifecycle) {
        this.lifecycle=lifecycle;
        this.context= context;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void start() {
        Toast.makeText(context,"start location listener" , Toast.LENGTH_SHORT).show();
        if (enabled) {
            // connect
        }
    }

    public void enable() {
        enabled = true;
        if (lifecycle.getCurrentState().isAtLeast(STARTED)) {
            // connect if not connected
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void stop() {
        Toast.makeText(context,"stop location listener" , Toast.LENGTH_SHORT).show();

        // disconnect if connected
    }
}
