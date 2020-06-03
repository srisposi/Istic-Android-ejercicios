package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ayuda_pagina_principal.*

class ayudaPaginaPrincipal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
   //     setContentView(R.layout.activity_ayuda_pagina_principal)

        btnVolverPaginaInicio.setOnClickListener {
            val actividadInicio:Intent= Intent(this, MainActivity::class.java)
            startActivity(actividadInicio)
        }
    }
}
