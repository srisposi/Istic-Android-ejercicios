package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_contador.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStreamWriter

class contador : AppCompatActivity() {

    var contadorA =0
    val txtMultilinea=findViewById<TextView>(R.id.txtMultilinea)
    val btnGuardar=findViewById<Button>(R.id.btnGuardar)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contador)

        btnSumar.setOnClickListener {
            this.contadorA++
            txtContador.text = this.contadorA.toString()
        }


        btnReset.setOnClickListener {
            contadorA = 0
            txtContador.text = ""
        }

        btnAyuda.setOnClickListener {
            val ayudaIntent = Intent(this, ayudaContador::class.java)
            startActivity(ayudaIntent)
        }

        btnVolver4.setOnClickListener {
            val volver4: Intent = Intent(this, MainActivity::class.java)
            startActivity(volver4)
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
