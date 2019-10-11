package mx.edu.utng.mnuapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_principal.*


class PrincipalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)

        btnViaje.setOnClickListener(){
            startActivity(Intent(this,ViajeActivity::class.java))
            finish()
        }

        btnJuego.setOnClickListener(){
            startActivity(Intent(this,JuegoActivity::class.java))
            finish()
        }

        btnPrestamo.setOnClickListener(){
            startActivity(Intent(this,PrestamoActivity::class.java))
            finish()
        }

        btnSalir.setOnClickListener(){
            finish()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater:MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_principal,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var msg: String = ""
        when(item.itemId){
            R.id.itmviaje-> {
                msg="Has seleccionado la calculadora de Viaje"
                startActivity(Intent(this,ViajeActivity::class.java))
            }
            R.id.itmPrestamo-> {
                msg="Has seleccionado la aplicacion de prestamo"
                startActivity(Intent(this,PrestamoActivity::class.java))
            }
            R.id.itmJuego-> {
                msg="Juego Seleccionado"
                startActivity(Intent(this,JuegoActivity::class.java))
            }
            R.id.itmSalir-> {
                msg = "Has seleccionado salir de la app"
                System.exit(0)
            }
        }
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show()
        return super.onOptionsItemSelected(item)
    }
}

