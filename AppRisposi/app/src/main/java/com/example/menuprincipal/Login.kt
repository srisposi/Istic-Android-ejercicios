package com.example.menuprincipal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class Login : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        try {
            //Botón para volver
            val btnVolverLogin = findViewById<Button>(R.id.btnVolverLogin)
            btnVolverLogin.setOnClickListener {
                val volverLogin = Intent(this, MainActivity::class.java)
                startActivity(volverLogin)
            }
        }catch (e: Throwable) {
            Toast.makeText(this,"Se produjo un error, Pruebe de nuevo" + e.message, Toast.LENGTH_SHORT).show()
        }


        try {
            val btnLoginLogin=findViewById<Button>(R.id.btnLoginLogin)
            btnLoginLogin.setOnClickListener {
                val LoginLogin = Intent(this, QuienSoy::class.java)
                startActivity(LoginLogin)
            }
        }catch (e:Throwable){
            Toast.makeText(this, "Se produjo un error, Pruebe de nuevo" + e.message,Toast.LENGTH_SHORT).show()
        }
        



    }
}
