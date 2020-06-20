package com.example.menuprincipal

import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_contador.*

class Contador : AppCompatActivity() {

    var contador:Int=0

    fun ttoas(mensaje:String){//Funcion para mensaje toast

        var toast = Toast.makeText(this@Contador,"$mensaje", Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.CENTER,0,0)
        toast.show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contador)


        val botonSumar = findViewById<Button>(R.id.btnSube) //Declaracion para boton ingresar
        btnSube.setOnClickListener {
            contador = contador +1
            lblContador.text = contador.toString()
        }

        val btnBaja = findViewById<Button>(R.id.btnBaja) //Declaracion para boton ingresar
        btnBaja.setOnClickListener {
            contador = contador -1
            lblContador.text = contador.toString()
        }

        val botonReset = findViewById<Button>(R.id.btnReiniciar) //Declaracion para boton ingresar
        btnReiniciar.setOnClickListener {
            contador = 0
            lblContador.text = ""
        }

        val btnAyuda = findViewById<TextView>(R.id.btnAyuda) //Declaracion para boton ingresar
        btnAyuda.setOnClickListener {
            val ayudaIntent= Intent(this, ScreenAyudaContador::class.java)
            startActivity(ayudaIntent)
        }

        /* Botón Guardar ahora lo hacemos en Firebase
        val botonDatosCont = findViewById<ImageView>(R.id.btnGuardarDatosContador) //Declaracion para boton ingresar
        botonDatosCont.setOnClickListener {
            if (lblContador.text == "" || lblContador.text.toString().toInt() == 0)
            {
                this.ttoas("Contador Vacio ó igual a 0")
            }else {
                val datoContado = lblContador.text
                val guardarDatosContIntent = Intent(this, DatosContador::class.java)
                guardarDatosContIntent.putExtra("datoContado", "$datoContado")
                startActivity(guardarDatosContIntent)
            }
        }
*/
        val botonVolverMenu = findViewById<Button>(R.id.btnVolver) //Declaracion para boton ingresar
        btnVolver.setOnClickListener {
            val irMenuIntent = Intent(this, MainActivity::class.java)
            startActivity(irMenuIntent)
            finish()
        }
    }





}
