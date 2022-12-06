package com.app.printollo

import android.R.attr.*
import android.os.AsyncTask
import android.util.Log
import android.view.View
import android.view.animation.AlphaAnimation
import android.widget.FrameLayout
import java.util.concurrent.TimeUnit


class Progress (view: View) {
    var inAnimation: AlphaAnimation? = null
    var outAnimation: AlphaAnimation? = null

    var progressBarHolder: FrameLayout? = null

    init {
        progressBarHolder = view.findViewById(R.id.progressBarHolder)
    }

    fun onPreExecute() {
        inAnimation = AlphaAnimation(0f, 1f)
        inAnimation!!.setDuration(200)
        progressBarHolder!!.setAnimation(inAnimation)
        progressBarHolder!!.setVisibility(View.VISIBLE)
    }

    fun onPostExecute() {
        outAnimation = AlphaAnimation(1f, 0f)
        outAnimation!!.setDuration(200)
        progressBarHolder!!.setAnimation(outAnimation)
        progressBarHolder!!.setVisibility(View.GONE)
    }
}