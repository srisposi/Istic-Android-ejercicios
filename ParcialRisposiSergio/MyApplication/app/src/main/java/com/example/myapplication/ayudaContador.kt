package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_ayuda_contador.*

class ayudaContador : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contador)

        btnVolverContador.setOnClickListener {
            var volverContador:Intent=Intent(this,contador::class.java)
            startActivity(volverContador)
        }
    }
}
