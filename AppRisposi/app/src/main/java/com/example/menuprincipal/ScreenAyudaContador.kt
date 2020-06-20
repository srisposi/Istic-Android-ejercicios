package com.example.menuprincipal

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView



class ScreenAyudaContador : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_ayuda_contador)

        val btnOk = findViewById<TextView>(R.id.btnOk) //Declaracion para boton ingresar
        btnOk.setOnClickListener {
            val ayudaIntent2= Intent(this, Contador::class.java)
            startActivity(ayudaIntent2)
        }


    }

}
