package com.hugobelman.listviewpersonalizado

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.title="Tutorial Kotlin"

        val tema1 = Producto("Manejo de ListView",R.drawable.ls,"Un ListView es un componente de vista de lista que nos servirá para mostrar datos, tal como puede ser una lista de contactos, lista de productos, etc.",R.drawable.cls)
        val tema2 = Producto("Manejo de Activities",R.drawable.a1,"Una Activity es un componente de la aplicación que contiene una pantalla con la que los usuarios pueden interactuar para realizar una acción, como marcar" +
                " un número telefónico, tomar una foto, enviar un correo electrónico o ver un mapa.",R.drawable.a2)
        val tema3 = Producto("SheredPreferences",R.drawable.s1,"Almacenamiento interno con SharedPreferences:\n" +
                "Android ofrece diferentes opciones para que guardes los datos de tu aplicación. La solución que elijas dependerá de tus necesidades específicas\n" +
                "SharedPreferences: Si tu aplicación no necesita almacenar muchos datos ni requiere una estructura, sirve para almacenar datos privados de primitivas en pares clave.\n",R.drawable.s2 )
        val tema4 = Producto("Controles de Audio",R.drawable.au1,"Para implementar audio a tu App existen diferentes formas.\n" +
                "La clase MediaPlayer se puede usar para controlar la reproducción de archivos de audio/vídeo y transmisiones.\n",R.drawable.au2)
        val tema5 = Producto("SQLite",R.drawable.sq1,"Es un motor de base de datos SQL transaccional de código abierto, ligero, autónomo, de configuración simple y sin servidor\n" +
                "Así mismo, por ser de dominio público es gratuito tanto para fines privados como para comerciales\n" +
                "SQLite cumple con las características ACID (atomicidad, consistencia, aislamiento y durabilidad), forma parte integral de las aplicaciones basadas en el cliente, SQLite utiliza una sintaxis SQL dinámica y realiza múltiples tareas para hacer lecturas y escrituras al mismo tiempo, ambas (lectura y escritura) se efectúan directamente en los archivos de disco ordinarios.\n",R.drawable.ejemp2 )


        val listaProductos = listOf(tema1, tema2,tema3,tema4,tema5)

        val adapter = ProductosAdapter(this, listaProductos)

        lista.adapter = adapter

        lista.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, ProductoActivity::class.java)
            intent.putExtra("producto", listaProductos[position])
            startActivity(intent)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle item selection
        var mensaje: String=""
        when (item.itemId) {
            R.id.itmAcerca -> {
                mensaje="Tutorial de Kotlin.\n"+
                "Elaborado por Brandon Aldahir León Alvarado.\n"+"GDS0142"
            }
            R.id.itmObjetivo -> {
                mensaje= "El objetivo de este tutorial es conocer sobre algunos temas relacionados con Kotlin y el uso de las ListView"
            }
            R.id.itmSalir -> {
                System.exit(0)
            }

        }
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
        return  super.onOptionsItemSelected(item)
    }
}
