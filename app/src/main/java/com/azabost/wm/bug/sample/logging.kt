package com.azabost.wm.bug.sample

import android.util.Log

class Logger(val tag: String) {
    fun debug(msg: String) {
        Log.d(tag, msg)
    }
    fun error(msg: String, t: Throwable) {
        Log.e(tag, msg, t)
    }
}

val Any.log get() = Logger(javaClass.name)
