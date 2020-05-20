
package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_quien_soy.*
import kotlinx.android.synthetic.main.activity_registro.*
import kotlinx.android.synthetic.main.activity_registro.lblLegajoQuienSoy

class registro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        //var actividad = Intent(this,registro::class.java)
        //startActivity(actividad)

        btnRegistro.setOnClickListener{
            val volver2:Intent = Intent(this,MainActivity::class.java)
            Toast.makeText(this,"REGISTRO CORRECTO",Toast.LENGTH_LONG).show()
            startActivity(volver2)
        }

        btnQuienSoy.setOnClickListener {
            lblNombreQuienSoy.text.toString()="SERGIO DANIEL"
            lblApellidoQuienSoy.text.toString()="RISPOSI"
            lblLegajoQuienSoy.text.toString()="32411"
            lblGitHubQuienSoy.text.toString()="https://github.com/srisposi/Istic-Android-ejercicios"
            val actividadQuienSoy:Intent = Intent(this,quienSoy::class.java)
            startActivity(actividadQuienSoy)
        }

    }
}
