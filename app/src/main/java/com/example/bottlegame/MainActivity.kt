package com.example.bottlegame

import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import java.util.*


class MainActivity : AppCompatActivity() {
    private var bot: ImageView? = null
    private val rand = Random()
    private var Aci = 0
    private var spn = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bot = findViewById(R.id.bottle)
    }


    fun spinBottle(v: View?) {

        if (!spn) {


            val num = rand.nextInt(1800)


            val pX = (bot!!.width / 2).toFloat()
            val pY = (bot!!.height / 2).toFloat()


            val rot: Animation = RotateAnimation(Aci.toFloat(), num.toFloat(), pX, pY)


            rot.duration = 2500


            rot.fillAfter = true
            rot.setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(animation: Animation) {
                    spn = true
                }

                override fun onAnimationEnd(animation: Animation) {
                    spn = false
                }

                override fun onAnimationRepeat(animation: Animation) {}
            })


            Aci = num


            bot!!.startAnimation(rot)
        }
    }
}
