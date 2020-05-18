package com.example.holamundo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        val numeroSecreto = (Math.random()*100).toInt()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btnVerificar.setOnClickListener(){
            lblAyuda.text=numeroSecreto.toString()
        }
        if (numeroSecreto.toString()==txtNombre.text.toString())
        {
            Toast.makeText(this,"Sos un genio",Toast.LENGTH_LONG).show()
        }else
        {
            Toast.makeText(this,"No es el número",Toast.LENGTH_LONG).show()
        }


    }
}