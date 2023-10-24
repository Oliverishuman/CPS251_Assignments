package com.olmcmillen.lifecycleawareness

import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner

class MainObserver: DefaultLifecycleObserver {
    private val TAG = "DemoObserver"
    var mv = MainViewModel

    override fun onCreate(owner: LifecycleOwner) {
        mv.setText("onCreate")
    }

    override fun onResume(owner: LifecycleOwner) {
        mv.setText("onResume")
    }

    override fun onPause(owner: LifecycleOwner) {
        mv.setText("onPause")
    }

    override fun onStart(owner: LifecycleOwner) {
        mv.setText("onStart")
    }

    override fun onStop(owner: LifecycleOwner) {
        mv.setText("onStop")
    }

    override fun onDestroy(owner: LifecycleOwner) {
        mv.setText("onDestroy")
    }
}