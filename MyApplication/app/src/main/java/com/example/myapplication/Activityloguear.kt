package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_loguear.*

class Activityloguear : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLoguear2.setOnClickListener{
            val volver:Intent = Intent(this,MainActivity::class.java)
            startActivity(volver)
        }

    }
}
