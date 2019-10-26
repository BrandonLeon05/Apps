package com.hugobelman.listviewpersonalizado

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_producto.*

class ProductoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto)
        btnRegresar.setOnClickListener {
            finish()
        }

        val producto = intent.getSerializableExtra("producto") as Producto

        nombre_producto.text = producto.titulo
        detalles_producto.text = producto.descripcion
        imagen.setImageResource(producto.imaTema)
        imgCodigo.setImageResource(producto.imaDes)

        supportActionBar!!.title="Tutorial Kotlin"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }
}
