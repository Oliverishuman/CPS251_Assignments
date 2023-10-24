package com.olmcmillen.lifecycleawareness

import android.nfc.Tag
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import java.text.SimpleDateFormat
import java.time.LocalTime

class MainObserver: DefaultLifecycleObserver {

    var ts = LocalTime.now()

    private val TAG = " was fired on " + ts
    var mv = MainViewModel

    override fun onCreate(owner: LifecycleOwner) {
        mv.setText("\nonCreate" + TAG)
    }

    override fun onResume(owner: LifecycleOwner) {
        mv.setText("onResume" + TAG + "\n*************")
    }

    override fun onPause(owner: LifecycleOwner) {
        mv.setText("onPause" + TAG + "\n*************")
    }

    override fun onStart(owner: LifecycleOwner) {
        mv.setText("onStart" + TAG)
    }

    override fun onStop(owner: LifecycleOwner) {
        mv.setText("onStop" + TAG)
    }

    override fun onDestroy(owner: LifecycleOwner) {
        mv.setText("onDestroy" + TAG + "\n*************")
    }
}