package com.example.menuprincipal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_como_jugar.*
import kotlinx.android.synthetic.main.activity_screen_ayuda.*

class ComoJugar : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_como_jugar)


        val btnVolverAyudaJugar=findViewById<Button>(R.id.btnVolverAyudaJugar)
        btnVolverAyudaJugar.setOnClickListener {
            try {
                val volverAyudaJugar = Intent (this, AdivinarNumero::class.java)
                startActivity(volverAyudaJugar)

            }catch (e: Throwable){
                Toast.makeText(this, "Se produjo un error en la ayuda, Pruebe de nuevo" + e.message, Toast.LENGTH_SHORT).show()
            }

        }



    }
}
