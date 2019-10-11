package mx.edu.utng.apptodoenuno


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

        btnViaje.setOnClickListener {
            startActivity(Intent(this, ViajeActivity::class.java))
        }

        btnSalir.setOnClickListener {
            Toast.makeText(this,"Gracias por utilizar la aplicación",Toast.LENGTH_LONG).show()
            System.exit(0)
        }

        btnJuego.setOnClickListener{
            startActivity(Intent(this, Juego::class.java))
        }

        btnPrestamo.setOnClickListener {
            startActivity(Intent(this, Prestamo::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        //Se crea objeto para cargar menú
        val inflater: MenuInflater = menuInflater
        //Indicar el xml en donde está el menu
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        var mensaje: String=""
        //Estructura similar a switch..case
        when (item.itemId){
            R.id.itmViaje -> {
                mensaje="Has seleccionado la calculadora de viaje"
                startActivity(Intent(this, ViajeActivity::class.java))
            }
            R.id.itmPrestamo -> {
                mensaje= "Has seleccionado Prestamo"
                startActivity(Intent(this, Prestamo::class.java))
            }
            R.id.itmJuego -> {
                mensaje= "Has seleccionado Juego"
                startActivity(Intent(this, Juego::class.java))

            }
            R.id.itmSalir -> {
                System.exit(0)
            }
        }
        Toast.makeText(this, mensaje, Toast.LENGTH_LONG).show()
        return super.onOptionsItemSelected(item)
    }
}
