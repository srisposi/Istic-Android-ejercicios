package com.example.adivinanumero

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val numeroSecreto = (Math.random() *20 ).toInt()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnVerificar.setOnClickListener {

            if(numeroIngresado.text.toString() <= 0.toString() )
            {
                Toast.makeText(this, "Por favor Ingrese número positivo", Toast.LENGTH_LONG).show()
            } else
            {
                if (numeroSecreto.toString() == numeroIngresado.text.toString())
                {
                    Toast.makeText(this, "Acertaste a la primera", Toast.LENGTH_LONG).show()
                    lblNumeroSecreto.text = numeroSecreto.toString()
                } else
                {
                    if (numeroSecreto.toString() > numeroIngresado.text.toString())
                    {
                        Toast.makeText(this,"El número es mayor, intente nuevamente",Toast.LENGTH_LONG).show()
                    } else
                    {
                        Toast.makeText(this,"El número es menor, intente nuevamente",Toast.LENGTH_LONG).show()
                    }

                }
            }

        }

   }


}
