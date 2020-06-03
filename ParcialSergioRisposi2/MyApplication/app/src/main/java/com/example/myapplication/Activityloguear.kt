package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.myapplication.R.layout.activity_loguear
import com.example.myapplication.R.layout.activity_main
import kotlinx.android.synthetic.main.activity_loguear.*
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader

class Activityloguear : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_loguear)

        btnLoguear2.setOnClickListener{
            val volver:Intent = Intent(this,MainActivity::class.java)
            Toast.makeText(this,"LOGUIN CORRECTO", Toast.LENGTH_LONG).show()
            startActivity(volver)
        }

    }




    private fun loginArchivo() {
        if (fileList().contains("registro.txt")) {
            try {
                val archivo = InputStreamReader(openFileInput("registro.txt"))
                val br = BufferedReader(archivo)
                var linea = br.readLine()
                while (linea != null) {
                    //pepito=>1234 esto tiene linea
                    val arrayDatos = linea.split("=>")
                    if (arrayDatos[0] == lblLegajo.text.toString() && arrayDatos[1] == lblPassword.text.toString()) {
                        break
                    }
                    linea = br.readLine()
                }


                br.close()
                archivo.close()

            } catch (e: IOException) {
                Toast.makeText(this,"ERROR EN EL LOGUEO", Toast.LENGTH_LONG).show()
            }
        }

    }

}
