package mx.edu.utng.mnuapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_viaje.*

class ViajeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viaje)

        btnRetorno.setOnClickListener{
            finish() //Finaliza la actividead actual
        }

        btnCalculaViaje.setOnClickListener{
            var dinGas:Double = etxGasolinaLitros.text.toString().toDouble()
            var kmRecor:Double = etxTotalKilometros.text.toString().toDouble()
            var gasxL:Double = etxPrecioPorLt.text.toString().toDouble()
            var minV:Double = etxDuracionMin.text.toString().toDouble()

            //Calculo del consumo
            var totLit = (dinGas/gasxL)
            var cconUno = (kmRecor/totLit)
            var conUnoA = (1/cconUno) //Consumo 1 km litro
            var conUnoB = (conUnoA*gasxL) //Consumo 1 km peso

            var conDosA = (conUnoA*100) //Consumo 100 km litro
            var conDosB = (conDosA*gasxL) //Consumo 100 km peso

            //Calculo de la velocidad media
            var minReal: Double = (minV.toDouble()/60)
            var tiempo: Double = (minReal.toDouble())
            var velocidad: Double = (kmRecor.toDouble()/tiempo)

            txvResultadoViaje.text="Gasto en pesos por cada km: ${conUnoB.toString()},  " +
           "Gasto en litros por cada km: ${conUnoA.toString()},  " +
                    "Gasto en pesos por cada 100km: ${conDosA.toString()},  " +
                    "Gasto enpesos por cada 100km: ${conDosB.toString()},  "+
                    "Velocidad Media: ${velocidad.toString()},  "
        }
    }
}
