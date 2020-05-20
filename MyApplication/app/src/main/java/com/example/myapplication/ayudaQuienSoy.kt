package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_ayuda_quien_soy.*

class ayudaQuienSoy : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quien_soy)
        var btnVolverQuienSoy = findViewById<Button>(R.id.btnVolver6)

        btnVolverQuienSoy.setOnClickListener {

            var actividadAyudaQuienSoy:Intent=Intent(this,quienSoy::class.java)
            startActivity(actividadAyudaQuienSoy)
        }
    }
}
