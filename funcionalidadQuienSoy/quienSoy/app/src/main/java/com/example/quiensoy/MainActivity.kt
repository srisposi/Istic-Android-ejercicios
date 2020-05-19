package com.example.quiensoy

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class quienSoy : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intentoDos=Intent(this, login ::class.java)
        startActivity(intentoDos)

        btnQuienSoy.setOnClickListener{
            val unIntento = Intent(this, quienSoy ::class.java)
            startActivity(unIntento)


        }
    }
}
