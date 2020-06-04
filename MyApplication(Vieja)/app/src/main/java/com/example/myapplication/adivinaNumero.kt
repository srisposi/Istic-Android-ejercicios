package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_adivina_numero.*

class adivinaNumero : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val numeroSecreto = (Math.random() *20 ).toInt()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adivina_numero)
        btnVerificar.setOnClickListener {


        if(numeroIngresado.text.toString() <= 0.toString())
            run {
                Toast.makeText(this, "Por favor Ingrese número positivo", Toast.LENGTH_LONG).show()
            } else
            run {
                if (numeroSecreto.toString() == numeroIngresado.text.toString()) {
                    Toast.makeText(this, "Acertaste", Toast.LENGTH_LONG).show()
                    lblNumeroSecreto.text = numeroSecreto.toString()
                } else
                {
                    if (numeroSecreto.toString() > numeroIngresado.text.toString())
                        run {
                            Toast.makeText(this, "El número es mayor, intente nuevamente", Toast.LENGTH_LONG).show()
                        } else {
                        Toast.makeText(this, "El número es menor, intente nuevamente", Toast.LENGTH_LONG).show()
                    }

                }
            }
        }
        //Botón para regresar a la página ppal.
        btnVolver3.setOnClickListener{
            var volerInicio: Intent = Intent(this,MainActivity::class.java)
            startActivity(volerInicio)

        }
    }
}
