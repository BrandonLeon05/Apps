package com.example.bioapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val lista = arrayOf("Juego de preguntas", "Consulta en internet", "Datos curiosos", "Créditos")
        val pri = Intent(this, MainJuego::class.java)
        val seg = Intent(this, MainConsulta::class.java)
        val ter = Intent(this, MainCuriosos::class.java)
        val cuar = Intent(this, MainCreditos::class.java)
        var pag = arrayOf(pri, seg,ter,cuar)

        var adaptador1 = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista)
        list1.adapter = adaptador1

        list1.setOnItemClickListener {adapterView, view, i, l ->
            startActivity(pag[i])

        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_principal, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var msg: String = ""
        when(item.itemId){

            R.id.itmJuego->{
                msg="Juego seleccionado"
                startActivity(Intent(this, MainJuego::class.java))
            }
            R.id.itmCons->{
                msg="Consultas"
                startActivity(Intent(this, MainConsulta::class.java))
            }
            R.id.itmCurio->{
                msg="Datos curiosos"
                startActivity(Intent(this, MainCuriosos::class.java))
            }
            R.id.itmCred->{
                msg="creditos"
                startActivity(Intent(this, MainCreditos::class.java))
            }
            R.id.itmSalir->{
                System.exit(0)
            }
        }
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
        return super.onOptionsItemSelected(item)
    }


}
