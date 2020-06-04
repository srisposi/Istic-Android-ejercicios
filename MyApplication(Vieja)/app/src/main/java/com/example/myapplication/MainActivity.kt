package com.example.myapplication

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        //Thread.sleep(2000)//Detengo la aplicación para poder ver el Splash Screen
        setTheme(R.style.AppTheme)//Nos trae el Splash Screen
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       btnLoguear.setOnClickListener {     //Con este botón voy a la página de Loguin
            val unActividad:Intent = Intent (this,Activityloguear::class.java)
            startActivity(unActividad)
        }

        btnRegistro2.setOnClickListener {     //Con este botón voy a la página de Registro
            val dosActividad:Intent = Intent (this,registro::class.java)
            startActivity(dosActividad)
        }

        btnAyuda.setOnClickListener {     //Con este botón voy a la página de Ayuda
            val tresActividad:Intent = Intent (this,ayudaPaginaPrincipal::class.java)
            startActivity(tresActividad)
        }

        btnContador.setOnClickListener {     //Con este botón voy a la página de Contar
            val cuatroActividad:Intent = Intent (this,contador::class.java)
            startActivity(cuatroActividad)
        }

        btnJugar.setOnClickListener{    //Con este botón voy a jugar adivina el número
            val cincoActividad:Intent = Intent(this,adivinaNumero::class.java)
            startActivity(cincoActividad)
        }
    }


}

private fun registroUsuario()
{

    try {
        val archivo = OutputStreamWriter(openFileOutput("registro.txt", Activity.MODE_APPEND))
        archivo.write(txtNombre.text.toString()+"=>"+ txtNombre.text.toString()+"\n")
        archivo.flush()
        archivo.close()
    } catch (e: IOException) {

    }
}
private fun loginUsuario()
{
    if (fileList().contains("registro.txt")) {
        try {
            val archivo = InputStreamReader(openFileInput("registro.txt"))
            val br = BufferedReader(archivo)
            var linea = br.readLine()
            while (linea != null) {
                //pepito=>1234 esto tiene linea
                val arrayDatos=linea.split("=>")
                if(arrayDatos[0]=="pepito" && arrayDatos[1]=="1234")
                {
                    break
                }
                linea = br.readLine()
            }


            br.close()
            archivo.close()

        } catch (e: IOException) {
        }
    }

}