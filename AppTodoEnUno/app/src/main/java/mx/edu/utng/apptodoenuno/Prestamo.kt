package mx.edu.utng.apptodoenuno

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_prestamo.*

class Prestamo: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prestamo)

        btnCalcularPrestamo.setOnClickListener{

            fun pot(a: Double, b:Int):Double{
                var result:Double = 1.0
                for(i in 1..b)
                    result = result*a
                return result
            }

            var prestamo: Double = etxMontoPrestamo.text.toString().toDouble()
            var plazos: Int = etxPlazoMeses.text.toString().toInt()
            var porInt: Double = etxInteresAnual.text.toString().toDouble()


            var i = (porInt/plazos)
            var centroOp = (1+(i/100))
            var montoPagos = ((prestamo)*(pot(centroOp,plazos)*(i/100))/((pot(centroOp,plazos)-1)))
            var intTem = (porInt/100)
            var interesMensual = (montoPagos*intTem)
            var pagoTotal = (montoPagos*plazos)

            txvMontoPagoMen.text = "Monto mensual: ${montoPagos}"
            txvInter.text = "Interés mensual: ${interesMensual}"
            txvPagoTot.text = "Pago total: ${pagoTotal}"

        }




    }
}
