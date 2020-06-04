package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import android.widget.Button
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        //Thread.sleep(2000)//Detengo la aplicación para poder ver el Splash Screen
        setTheme(R.style.AppTheme)//Nos trae el Splash Screen
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnRegistro2.setOnClickListener {
            //Con este botón voy a la página de Registro
            val btnRegistro = findViewById<Button>(R.id.btnRegistro2)
            val dosActividad: Intent = Intent(this, registro::class.java)
            startActivity(dosActividad)
        }

        btnLoguear.setOnClickListener {
            //Con este botón voy a la página de Loguin
            val bntLoguear = findViewById<Button>(R.id.btnLoguear) //Creamos una instancia para evitar conflictos. Para guardar el espacio en memoria
            val unActividad: Intent = Intent(this, Activityloguear::class.java)
            startActivity(unActividad)
        }



        btnAyuda.setOnClickListener {
            //Con este botón voy a la página de Ayuda
            val tresActividad: Intent = Intent(this, ayudaPaginaPrincipal::class.java)
            startActivity(tresActividad)
        }

        btnContador.setOnClickListener {
            //Con este botón voy a la página de Contar
            val cuatroActividad: Intent = Intent(this, contador::class.java)
            startActivity(cuatroActividad)
        }

        btnJugar.setOnClickListener {
            //Con este botón voy a jugar adivina el número
            val cincoActividad: Intent = Intent(this, adivinaNumero::class.java)
            startActivity(cincoActividad)
        }
    }

}