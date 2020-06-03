package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_contador.*
import kotlinx.android.synthetic.main.activity_quien_soy.*
import kotlinx.android.synthetic.main.activity_registro.*

class quienSoy : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quien_soy)

/*        this.lblNombreQuienSoy.text="SERGIO DANIEL"
        this.lblApellidoQuienSoy.text="RISPOSI"
        this.lblLeg.text= "232321"
        this.lblGitHubQuienSoy.text="https://github.com/srisposi/Istic-Android-ejercicios"
*/

        btnAyudaQuienSoy.setOnClickListener {
            var voy:Intent = Intent(this,ayudaQuienSoy::class.java)
            startActivity(voy)
        }

        btnQuienSoyYo.setOnClickListener {
            var vuelvo:Intent = Intent(this, registro::class.java)
            startActivity(vuelvo)

        }
    }
}
