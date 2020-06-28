package com.example.menuprincipal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class QuienSoy : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quien_soy)


        try {
            val btnVolverPrincipio=findViewById<Button>(R.id.btnVolverPrincipio)
            btnVolverPrincipio.setOnClickListener {
                val VolverPrincipio = Intent(this, MainActivity::class.java)
                startActivity(VolverPrincipio)
            }
        }catch (e:Throwable){
            Toast.makeText(this, "Se produjo un error, Pruebe de nuevo" + e.message, Toast.LENGTH_SHORT).show()
        }
    }

}
