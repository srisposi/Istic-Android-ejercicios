package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class contador : AppCompatActivity() {

    var contador:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contador)
/*
        btnSumar.setOnClickListener {
            contador = contador +1
            lblContador.text = contador.toString()
        }


        btnReserContador.setOnClickListener {
            contador = 0
            lblContador.text = ""
        }

        lblayuda.setOnClickListener {
            val ayudaIntent= Intent(this, ComoJugarContador::class.java)
            startActivity(ayudaIntent)
        }
*/
    }
}