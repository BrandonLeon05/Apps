package com.example.bioapp

import android.animation.ValueAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.LinearInterpolator
import kotlinx.android.synthetic.main.activity_main_creditos.*

class MainCreditos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_creditos)

        val animador = ValueAnimator.ofFloat( 0.0f,1.0f)
        animador.repeatCount= ValueAnimator.INFINITE
        animador.interpolator = LinearInterpolator()
        animador.duration= 10000L
        animador.addUpdateListener { animation ->
            val progreso = animador.animatedValue as Float
            val anchura = lalala1.width
            val transicionX = anchura * progreso
            lalala1.translationX = transicionX
            lalala2.translationX = transicionX - anchura
        }
        animador.start()
    }
}
