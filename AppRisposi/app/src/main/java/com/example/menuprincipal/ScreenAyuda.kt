package com.example.menuprincipal

import android.content.Intent
//import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


import kotlinx.android.synthetic.main.activity_screen_ayuda.*

class ScreenAyuda : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_screen_ayuda)

        btnVolver.setOnClickListener {
            val volver = Intent (this, MainActivity::class.java)
            startActivity(volver)
        }
    }
}
