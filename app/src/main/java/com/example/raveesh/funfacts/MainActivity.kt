package com.example.raveesh.funfacts

import android.annotation.TargetApi
import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.view.Window
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showFactButton.setOnClickListener {
            factTextView.text = FactBook.getFact()
            // Colors:
            val color = ColorWheel.getColor()
            relativeLayout.setBackgroundColor(color)
            showFactButton.setTextColor(color)
            val window:Window = this.window
            window.statusBarColor = color
        }
    }
}