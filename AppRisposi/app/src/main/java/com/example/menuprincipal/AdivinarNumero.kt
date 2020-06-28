package com.example.menuprincipal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_adivinar_numero.*
import kotlinx.android.synthetic.main.activity_adivinar_numero.btnAyuda
import kotlinx.android.synthetic.main.activity_contador.*

class AdivinarNumero : AppCompatActivity() {
    //Generamos un número random
    val numeroSecreto = (Math.random() * 100).toInt()

    val validaNum = 100

    var vidas: Int = 5
    var intentos: Int = 0
    var numAyuda: Int = 3
    var ayuda: Int = 1
    var numeroMultiplicado: Int = 0
    //=============================================================
    private lateinit var database: DatabaseReference// ...
    private lateinit var postReference: DatabaseReference
    private lateinit var postKey: String
    private var postListener: ValueEventListener? = null
    //=============================================================
    fun ttoas(mensaje: String) {//Funcion para mensaje toast

        var toast = Toast.makeText(this@AdivinarNumero, "$mensaje", Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.show()
    }

    fun pista(NumeroPista: Int) {
        if (numeroSecreto.toString() > txtIngNum.text.toString()) {
            this.ttoas("Es un número mayor")
        }
        if (numeroSecreto.toString() < txtIngNum.text.toString()) {
            this.ttoas("Es un número menor")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adivinar_numero)

//TextView Donde se muestra la información
        /*
            txtVidas.text = "Vidas restantes: $vidas"
            txtIntentos.text = "Numero de intentos: $intentos"
            txtAyuda.text = "Ayudas disponibles: $numAyuda"

//Para guardar los datos viejo
            val botonDatosAdivina = findViewById<ImageView>(R.id.btnGuardarDatosAdivina) //Declaracion para boton ingresar
            botonDatosAdivina.isEnabled = false //Declaro el boton guardar arriba y lo inicio deshabilitado
        */

        btnAyuda.setOnClickListener {
            //Boton de ayuda
            when (ayuda) {
                1 ->
                    if (numeroSecreto <= 50) {
                        this.ttoas("Numero Menor a 51")
                    } else {
                        this.ttoas("Numero mayor a 50")
                    }

                2 ->
                    if (numeroSecreto % 2 == 0) {
                        this.ttoas("El numero es Par")
                    } else {
                        this.ttoas("El numero es Impar")
                    }
                3 ->
                    if (numeroSecreto % 3 == 0) {
                        this.ttoas("(El Número es divisible por 3)")
                    }
                else -> {
                    this.ttoas("(El Número No es divisible por 3)")
                }

            }

            ayuda = ayuda + 1
            if (numAyuda > 0) {
                numAyuda = numAyuda - 1
                // txtAyuda.text = "Ayudas disponibles: " + numAyuda
            }

        }


        btnTerminar.setOnClickListener {
            //Boton Terminar
            //val toast = Toast.makeText(this@NumeroSecreto,"El numero era: $numeroSecreto",Toast.LENGTH_SHORT)
            //toast.setGravity(Gravity.CENTER,0,0)
            //toast.show()

            this.ttoas("El numero era: $numeroSecreto")

            btnAdivinar.isEnabled = false
            btnAyuda.isEnabled = false
            txtIngNum.isEnabled = false
            txtResFinal.text = "GRACIAS POR PARTICIPAR"
            txtResFinal.visibility = View.VISIBLE


            // txtResFinal.setTextColor(txtResFinal.getContext().getResources().getColor(R.color.colorPrimary))
        }


        btnAdivinar.setOnClickListener {
            val NumInicial = txtIngNum.text.toString()
            if (NumInicial == "") {
                this.ttoas("Debe ingresar un Número")
            } else {
                val numero = txtIngNum.text.toString().toInt()
                if (numero <= 100) {
                    if (vidas > 1) {
                        if (numeroSecreto.toString() == txtIngNum.text.toString()) {
                            if (ayuda < 3) {
                                this.ttoas("Ganaste a la primera")
                                txtResFinal.text = "FELICITACIONES!!"
                                //botonDatosAdivina.isEnabled = true
                            } else {
                                this.ttoas("Ganaste a la segunda")
                                txtResFinal.text = "MUY BIEN"
                                //botonDatosAdivina.isEnabled = true
                            }
                            vidas = vidas - 1
                            intentos = intentos + 1
                            //txtVidas.text = "Vidas restantes: " + vidas
                            //txtIntentos.text = "Numero de intentos: " + intentos
                            btnAdivinar.isEnabled = false
                            btnAyuda.isEnabled = false
                            btnTerminar.isEnabled = false
                            txtIngNum.isEnabled = false
                            txtResFinal.visibility = View.VISIBLE
                        } else {
                            pista(txtIngNum.text.toString().toInt())
                            //Toast.makeText(this, "No es el numero ", Toast.LENGTH_LONG).show()
                            vidas = vidas - 1
                            intentos = intentos + 1
                            //txtVidas.text = "Vidas restantes: " + vidas
                            //txtIntentos.text = "Numero de intentos: " + intentos
                        }
                    } else {
                        this.ttoas("PERDISTE")
                        vidas = vidas - 1
                        intentos = intentos + 1
                        //txtVidas.text = "Vidas restantes: " + vidas
                        //txtIntentos.text = "Numero de intentos: " + intentos
                        btnAdivinar.isEnabled = false
                        btnTerminar.isEnabled = false
                        btnAyuda.isEnabled = false
                        txtIngNum.isEnabled = false
                        txtResFinal.text = "PRUEBA DE NUEVO!!!"
                        txtResFinal.visibility = View.VISIBLE
                    }
                } else {
                    this.ttoas("El nuemero debe ser Menor A 100")
                }
            }

        }

        btnComoJugar.setOnClickListener {
            val comoJugartIntent = Intent(this, ComoJugar::class.java)
            startActivity(comoJugartIntent)
        }

/*Como haciamos antes el Guardar
            botonDatosAdivina.setOnClickListener {
                try {
                    val datosAdivina = intentos.toString()
                    val guardarDatosAdivinaIntent = Intent(this, DatosAdivina::class.java)
                    guardarDatosAdivinaIntent.putExtra("datosAdivina", "$datosAdivina")
                    startActivity(guardarDatosAdivinaIntent)
                } catch (e: IOException) {
                    this.ttoas("Error intente nuevamente")
                }

            }
*/
//====================================================================================================================
        //Recibimos las variables de Registro
        val intent = intent
        val name2 = intent.getStringExtra("Name")
        val password2 = intent.getStringExtra("Password")


        if (name2 == null && password2 == null) {
            ttoas("Bienvenido Si quiere guardar sus datos registrese")
        } else {
            ttoas("Bienvenido a Adivina el Número")
        }


        val btnGuardarDatos = findViewById<Button>(R.id.btnGuardarDatos)

        btnGuardarDatos.setOnClickListener {
            if (name2 == null && password2 == null) {
                ttoas("No se pueden guardar sus puntos porque no esta registrado")

            } else {

                // [START initialize_database_ref]
                database = FirebaseDatabase.getInstance().reference
                // [END initialize_database_ref]
                val key = database.child("mensajes").push().key

                if (key == null) {
                    // Log.w("error", "Couldn't get push key for posts")
                    Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()

                }

                val destino = name2
                val uid = password2
                val usuario = this.txtIngNum.getText().toString()
                //val mensaje= this.txtMensaje.getText().toString()

                val post = Post(uid, destino, password2)
                val postValues = post.toMap()

                val childUpdates = HashMap<String, Any>()
                childUpdates["/mensajes/$destino/$usuario/$key"] = postValues
                childUpdates["/mensajes_usuario/$uid/$destino/$usuario/$key"] = postValues


                database.updateChildren(childUpdates)

                ttoas("Sus cuenta: " + usuario + " ha sido guardada, Gracias!")
            }
        }


//======================================================================================================================
        val btnVolverJugar =
            findViewById<Button>(R.id.btnVolverJugar) //Declaracion para boton ingresar
        btnVolverJugar.setOnClickListener {
            val VolverJugarIntent = Intent(this, MainActivity::class.java)
            startActivity(VolverJugarIntent)
            finish()
        }

        val Reinicio = findViewById<Button>(R.id.btnReinicio) //Declaracion para boton ingresar
        btnReinicio.setOnClickListener {
            val pIntent = Intent(this, AdivinarNumero::class.java)
            startActivity(pIntent)
            finish()

        }


//===========================================================

        // [START post_class]
        @IgnoreExtraProperties
        data class Post(
            var uid: String? = "",
            var usuario: String? = "",
            var destino: String? = "",
            var mensaje: String? = "",
            var starCount: Int = 0,
            var stars: MutableMap<String, Boolean> = HashMap()
        ) {

            // [START post_to_map]
            @Exclude
            fun toMap(): Map<String, Any?> {
                return mapOf(
                    "uid" to uid,
                    "usuario" to usuario,
                    "destino" to destino,
                    "mensaje" to mensaje

                )
            }
            // [END post_to_map]
        }
//[END post_class]
    }
}
//===============================================================