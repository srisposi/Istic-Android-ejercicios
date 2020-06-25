package com.example.menuprincipal

import android.content.Intent
//import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class ScreenAyudaContador : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_ayuda_contador)

        val btnOk = findViewById<TextView>(R.id.btnOk) //Declaracion para boton ingresar
        btnOk.setOnClickListener {
            try {
                val ayudaIntent2 = Intent(this, Contador::class.java)
                startActivity(ayudaIntent2)
            }catch (e:Throwable){
                Toast.makeText(this, "Se produjo un error en la ayuda, Pruebe de nuevo" + e.message, Toast.LENGTH_SHORT).show()
            }
        }


    }

}
