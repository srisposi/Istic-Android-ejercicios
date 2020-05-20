package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_contador.*

class contador : AppCompatActivity() {

    var contador:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contador)

        btnSumar.setOnClickListener {
            contador = contador +1
            lblContador.text = contador.toString()
        }


        btnReset.setOnClickListener {
            contador = 0
            lblContador.text = ""
        }

        btnAyuda.setOnClickListener {
            val ayudaIntent= Intent(this, ayudaContador::class.java)
            startActivity(ayudaIntent)
        }

    }
}