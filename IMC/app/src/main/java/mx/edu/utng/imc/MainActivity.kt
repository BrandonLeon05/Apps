package mx.edu.utng.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Manejo del evento del Click al boton btnCalcular (vista)
        btnCalcular.setOnClickListener(){
            var peso: Double = etxPeso.text.toString().toDouble()
            var est: Double = etxEstatura.text.toString().toDouble()
            var imc: Double = peso/(est*est)
            txvImc.text= "IMC = ${imc.toString()}"
        }
    }
}
