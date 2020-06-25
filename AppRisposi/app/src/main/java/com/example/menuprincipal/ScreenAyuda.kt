package com.example.menuprincipal

import android.content.Intent
//import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


import kotlinx.android.synthetic.main.activity_screen_ayuda.*
import android.widget.Toast.makeText

class ScreenAyuda : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_ayuda)

        btnVolver.setOnClickListener {
            try {
                val volver = Intent (this, MainActivity::class.java)
                startActivity(volver)

            }catch (e: Throwable){
                Toast.makeText(this, "Se produjo un error en la ayuda, Pruebe de nuevo" + e.message,Toast.LENGTH_SHORT).show()
            }

        }
    }
}
