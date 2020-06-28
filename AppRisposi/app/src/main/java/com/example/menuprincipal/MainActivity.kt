package com.example.menuprincipal

import android.content.Intent
//import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Thread.sleep(2000)
        setTheme(R.style.AppTheme)

        val btnAyuda=findViewById<Button>(R.id.btnAyuda)
        btnAyuda.setOnClickListener {
            val screenAyudaIntent = Intent(this, ScreenAyuda::class.java)
            startActivity(screenAyudaIntent)
        }

        val btnContador=findViewById<Button>(R.id.btnContador)
        btnContador.setOnClickListener {
            val ContadorIntent = Intent(this, Contador::class.java)
            startActivity(ContadorIntent)
        }

        val btnRegistro=findViewById<Button>(R.id.btnRegistro)
        btnRegistro.setOnClickListener {
            val regis = Intent(this, Registro::class.java)
            startActivity(regis)
        }

        val btnJugar=findViewById<Button>(R.id.btnJugar)
        btnJugar.setOnClickListener {
            val jugar=Intent(this, AdivinarNumero::class.java)
            startActivity(jugar)
        }

        val btnLogin=findViewById<Button>(R.id.btnLogin)
        btnLogin.setOnClickListener {
            val LoginIntent=Intent(this, Login::class.java)
            startActivity(LoginIntent)
        }

    }





}
