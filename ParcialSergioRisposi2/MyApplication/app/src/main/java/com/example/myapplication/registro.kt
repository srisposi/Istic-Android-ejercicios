
package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_quien_soy.*
import kotlinx.android.synthetic.main.activity_registro.*
import kotlinx.android.synthetic.main.activity_registro.lblLegajo
import java.io.IOException
import java.io.OutputStreamWriter

class registro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        //var actividad = Intent(this,registro::class.java)
        //startActivity(actividad)

        btnRegistro.setOnClickListener{
            registrarUsuario()
            val volver2:Intent = Intent(this,MainActivity::class.java)
            Toast.makeText(this,"REGISTRO CORRECTO",Toast.LENGTH_LONG).show()
            startActivity(volver2)
        }

        btnQuienSoy.setOnClickListener {

            val actividadQuienSoy:Intent = Intent(this,quienSoy::class.java)
            startActivity(actividadQuienSoy)
        }

    }

    override fun onStart() {//Haciendo uso del concepto de ciclo de vida vamos a cargar el listado de
        registrarUsuario()  //registro en esta función.
        super.onStart()
    }


    private fun registrarUsuario() {

        try {
            val archivo = OutputStreamWriter(openFileOutput("registro.txt", Activity.MODE_APPEND))
            archivo.write(lblLegajo.text.toString() + "=>" + lblPassword.text.toString() + "\n")
            archivo.flush()
            archivo.close()
        } catch (e: IOException) {
            Toast.makeText(this,"ERROR EN EL REGISTRO", Toast.LENGTH_LONG).show()

        }
    }
}

