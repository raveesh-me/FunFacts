package com.example.raveesh.funfacts

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Window
import android.widget.RelativeLayout
import android.widget.TextView
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick


class MainActivity : AppCompatActivity() {

    lateinit var relativeLayout:RelativeLayout
    lateinit var factTextView: TextView
    var color = ColorWheel.getColor()
    lateinit var fact:String



    @SuppressLint("ResourceType", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val window: Window = this.window
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = color
        }


        relativeLayout = relativeLayout {
            padding = dip(30)
            backgroundColor = color

            textView {
                text = "Did You Know?"
                textColor = Color.parseColor("#DDFFFFFF")
                textSize = 30f
            }.lparams {
                topMargin = dip(10)
                width = wrapContent
                height = wrapContent
                alignParentStart()
                alignParentTop()
            }

            factTextView = textView {
                text = "This app shows facts when you click the button!"
                textSize = 25f
                textColor = Color.WHITE
            }.lparams {
                above(2)
                width = wrapContent
                height = wrapContent
            }

            button("Show More!") {
                id = 2
                textSize = 15f
                backgroundColor = Color.WHITE
                onClick {
                    color = ColorWheel.getColor()
                    fact = FactBook.getFact()
                    textColor = color
                    clicked(color, fact) }
            }.lparams {
                width = matchParent
                alignParentBottom()
                bottomMargin = dip(30)
                topMargin = dip(25)
            }
        }
    }

    private fun clicked(color:Int, text:String) {
        factTextView.text = text
        relativeLayout.backgroundColor = color
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = color
        }


    }


}