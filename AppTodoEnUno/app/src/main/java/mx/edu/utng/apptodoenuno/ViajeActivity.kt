package mx.edu.utng.apptodoenuno

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_viaje.*

class ViajeActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viaje)

        var mensaje: String = ""

        //var preciolitros = gasV/gas
        //txvResultado.text="Litros Gastados ${preciolitros.toString()} litros"
        btnCalcular.setOnClickListener() {
            if (rdb100km.isChecked) {
                //Se calcula consumo de Gas por litro y pesos por cada 100 km
                var km: Double = etxKm.text.toString().toDouble()
                var gas: Double = etxGas.text.toString().toDouble()
                var gasV: Double = etxGasViaje.text.toString().toDouble()
                var horas: Double = etxHoras.text.toString().toDouble()
                var minutos: Double = etxMinutos.text.toString().toDouble()


                var preciolitros = gasV / gas
                var preciolitros100 = (100 * preciolitros) / km
                var litrosprecio = preciolitros100 * gas
                var minHor = minutos / 60
                var horaT = horas + minHor
                var velocidad = km / horaT
                txvResultado.text = "Consumo de litros: ${preciolitros.toString()}\n" +
                        "Dinero gastado: ${litrosprecio.toString()} \n" +
                        "Velocidad Media: ${velocidad.toString()}"
            } else if (rdb1km.isChecked) {
                //Se calcula consumo de Gas por litro y pesos por cada km
                var km: Double = etxKm.text.toString().toDouble()
                var gas: Double = etxGas.text.toString().toDouble()
                var gasV: Double = etxGasViaje.text.toString().toDouble()
                var horas: Double = etxHoras.text.toString().toDouble()
                var minutos: Double = etxMinutos.text.toString().toDouble()


                var preciolitros = gasV / gas
                var preciolitros1 = preciolitros / km
                var litrosprecio = preciolitros1 * gas
                var minHor = minutos / 60
                var horaT = horas + minHor
                var velocidad = km / horaT
                txvResultado.text = "Consumo de litros: ${preciolitros.toString()} \n" +
                        "Dinero gastado: ${litrosprecio.toString()} \n" +
                        "Velocidad Media: ${velocidad.toString()}"
            } else {
                mensaje = "No se realizo ningun calulo"
            }
            Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
        }
    }
}