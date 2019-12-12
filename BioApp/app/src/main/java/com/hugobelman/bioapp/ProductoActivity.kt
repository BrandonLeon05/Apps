package com.hugobelman.bioapp


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.bioapp.R
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


        supportActionBar!!.title="Datos Curiosos"
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
    }
}
