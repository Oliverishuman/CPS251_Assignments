package com.olmcmillen.lifecycleawareness

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class MainObserver: DefaultLifecycleObserver {

    private var ts = LocalTime.now()
    private val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS")
    private var formatTS = ts.format(formatter)

    private val wasFiredOn = " was fired on $formatTS"
    private var mv = MainViewModel

    override fun onCreate(owner: LifecycleOwner) {
        mv.setText("\nonCreate$wasFiredOn")
    }

    override fun onResume(owner: LifecycleOwner) {
        mv.setText("onResume$wasFiredOn\n*************")
    }

    override fun onPause(owner: LifecycleOwner) {
        mv.setText("onPause$wasFiredOn\n*************")
    }

    override fun onStart(owner: LifecycleOwner) {
        mv.setText("onStart$wasFiredOn")
    }

    override fun onStop(owner: LifecycleOwner) {
        mv.setText("onStop$wasFiredOn")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        mv.setText("onDestroy$wasFiredOn\n*************")
    }
}