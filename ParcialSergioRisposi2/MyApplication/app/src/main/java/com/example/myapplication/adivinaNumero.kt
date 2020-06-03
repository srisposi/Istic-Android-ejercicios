package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_adivina_numero.*
import kotlinx.android.synthetic.main.activity_adivina_numero.txtMultilinea
import kotlinx.android.synthetic.main.activity_contador.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class adivinaNumero : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val numeroSecreto = (Math.random() *20 ).toInt()
        val txtMultilinea=findViewById<TextView>(R.id.txtMultilinea)
        val btnGuardar=findViewById<Button>(R.id.btnGuardar)
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


        btnGuardar.setOnClickListener {
            GuardarDatos()
        }


    }
    fun GuardarDatos() {
        try {
            val archivo = OutputStreamWriter(openFileOutput("datos.txt", Activity.MODE_APPEND))
            archivo.write(txtContador.text.toString() + "\n")
            archivo.flush()
            archivo.close()
        } catch (e: IOException) {

        }
        Toast.makeText(this, "Guardando...", Toast.LENGTH_SHORT).show()
        CargarListado()
    }


    private fun CargarListado()
    {
        if (fileList().contains("datos.txt")) {
            try {
                val archivo = InputStreamReader(openFileInput("datos.txt"))
                val br = BufferedReader(archivo)
                var linea = br.readLine()
                val listado = StringBuilder()//solo para mostrarlo
                while (linea != null) {
                    listado.append(linea + " \n ")
                    linea = br.readLine()
                }
                br.close()
                archivo.close()
                this.txtMultilinea.setText(listado)
            } catch (e: IOException) {
            }
        }
    }
}
