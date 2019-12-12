package com.example.bioapp

import android.animation.ValueAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.LinearInterpolator
import com.hugobelman.bioapp.Producto
import com.hugobelman.bioapp.ProductoActivity
import com.hugobelman.bioapp.ProductosAdapter
import kotlinx.android.synthetic.main.activity_main_creditos.*
import kotlinx.android.synthetic.main.activity_main_creditos.lalala1
import kotlinx.android.synthetic.main.activity_main_curiosos.*

class MainCuriosos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_curiosos)
        supportActionBar!!.title="Datos Curiosos"


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

        val tema1 = Producto(
            "Historia",
            R.drawable.b1,
            "El concepto biotecnología tiene casi 100 años. Karl Ereky, ingeniero agrícola húngaro, lo utilizó por primera vez en 1919 para referirse a la fusión entre biología y tecnología. Esta ciencia describe la utilización de organismos vivos o sus derivados para crear o modificar productos o procesos."
        )
        val tema2 = Producto(
            "1000 veces mayor",
            R.drawable.b2,
            "Los fármacos biotecnológicos, como las vacunas, tienen una estructura molecular compleja y pueden llegar a tener un tamaño 1.000 veces mayor que la estructura de los medicamentos de origen químico, como la aspirina."
        )
        val tema3 = Producto(
            "Hamster Chino",
            R.drawable.b3,
            "Las células de ovario del hámster chino fabrican proteínas muy parecidas a las producidas por el cuerpo humano. Por eso, se usan en el campo de la biotecnología para desarrollar fármacos biológicos.\n"
        )
        val tema4 = Producto(
            "Producción de celular",
            R.drawable.b4,
            "Las células vivas, modificadas genéticamente, proliferan gracias a diferentes sustancias que se añaden al medio de cultivo con el objetivo de producir más cantidad de la proteína o fármaco final.\n"
        )
        val tema5 = Producto(
            "Por vía intravenosa o subcutanea",
            R.drawable.b5,
            "Los fármacos biológicos no pueden administrarse en forma de pastilla. Al ser moléculas proteicas, su paso por el estómago y el resto del tracto digestivo las destruiría, ya que los ácidos gástricos favorecen la digestión de las proteínas que ingerimos a diario. Por eso se prescriben por vía intravenosa o inyección subcutánea.\n"
        )

        val listaProductos = listOf(tema1, tema2,tema3,tema4,tema5)

        val adapter = ProductosAdapter(this, listaProductos)

        lista.adapter = adapter

        lista.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, ProductoActivity::class.java)
            intent.putExtra("producto", listaProductos[position])
            startActivity(intent)
        }
    }





}
