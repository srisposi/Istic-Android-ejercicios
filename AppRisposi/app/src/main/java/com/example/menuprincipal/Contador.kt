package com.example.menuprincipal

import android.annotation.SuppressLint
import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
//import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_contador.*

class Contador : AppCompatActivity() {

    //=============================================================
    private lateinit var database: DatabaseReference// ...
    private lateinit var postReference: DatabaseReference
    private lateinit var postKey: String
    private var postListener: ValueEventListener? = null
    //=============================================================

    var contador: Int = 0


    fun ttoas(mensaje: String) {//Funcion para mensaje toast

        var toast = Toast.makeText(this@Contador, "$mensaje", Toast.LENGTH_SHORT)
        toast.setGravity(Gravity.CENTER, 0, 0)
        toast.show()
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contador)

        //Recibimos las variables de Registro
        val intent = intent
        val name2 = intent.getStringExtra("Name")
        val password2 = intent.getStringExtra("Password")


        //=============================================================
        val lblContador = findViewById<TextView>(R.id.lblContador)
        //val txtId=findViewById<TextView>(R.id.txtId)
        //val txtUsuario=findViewById<TextView>(R.id.txtUsuario)
        //val txtDestino=findViewById<TextView>(R.id.txtDestino)
        //==============================================================


        if (name2==null && password2==null)
        {
            lblContador.text= "Bienvenido Si quiere guardar sus datos registrese"

        }else
        {
            lblContador.text= "Bienvenido al contador " + name2 + " " + password2
        }




        /*
    public override fun onStart() {
        super.onStart()

        // Add value event listener to the post
        // [START post_value_event_listener]
        val postListener = object : ValueEventListener {
            @SuppressLint("WrongConstant")
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                // Get Post object and use the values to update the UI
                val post = dataSnapshot.getValue(Post::class.java)
                // [START_EXCLUDE]
                post?.let {
                    Toast.makeText(this@MainActivity,"llego",1)

                }
                // [END_EXCLUDE]
            }

            @SuppressLint("WrongConstant")
            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message

                Toast.makeText(this@MainActivity,"error",1)
                // [END_EXCLUDE]
            }
        }
        postReference.addValueEventListener(postListener)
        // [END post_value_event_listener]

        // Keep copy of post listener so we can remove it when app stops
        this.postListener = postListener

        // Listen for comments

        */
        //====================================================================


        val botonSumar = findViewById<Button>(R.id.btnSube) //Declaracion para boton ingresar
        btnSube.setOnClickListener {
            contador = contador + 1
            lblContador.text = contador.toString()
        }

        val btnBaja = findViewById<Button>(R.id.btnBaja) //Declaracion para boton ingresar
        btnBaja.setOnClickListener {
            contador = contador - 1
            lblContador.text = contador.toString()
        }

        val botonReset = findViewById<Button>(R.id.btnReiniciar) //Declaracion para boton ingresar
        btnReiniciar.setOnClickListener {
            contador = 0
            lblContador.text = ""
        }

        val btnAyuda = findViewById<TextView>(R.id.btnAyuda) //Declaracion para boton ingresar
        btnAyuda.setOnClickListener {
            val ayudaIntent = Intent(this, ScreenAyudaContador::class.java)
            startActivity(ayudaIntent)
        }

        /* Botón Guardar ahora lo hacemos en Firebase
        val botonDatosCont = findViewById<ImageView>(R.id.btnGuardarDatosContador) //Declaracion para boton ingresar
        botonDatosCont.setOnClickListener {
            if (lblContador.text == "" || lblContador.text.toString().toInt() == 0)
            {
                this.ttoas("Contador Vacio ó igual a 0")
            }else {
                val datoContado = lblContador.text
                val guardarDatosContIntent = Intent(this, DatosContador::class.java)
                guardarDatosContIntent.putExtra("datoContado", "$datoContado")
                startActivity(guardarDatosContIntent)
            }
        }
*/
        val botonVolverMenu = findViewById<Button>(R.id.btnVolver) //Declaracion para boton ingresar
        btnVolver.setOnClickListener {
            val irMenuIntent = Intent(this, MainActivity::class.java)
            startActivity(irMenuIntent)
            finish()
        }



        //================================================================
        val btnGuardar = findViewById<Button>(R.id.btnGuardar)

        btnGuardar.setOnClickListener {
        if (name2==null && password2==null)
        {
            ttoas("No se pueden guardar sus puntos porque no esta registrado")

        }else {

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
                val usuario = this.lblContador.getText().toString()
                //val mensaje= this.txtMensaje.getText().toString()

                val post = Post(uid, destino, password2)
                val postValues = post.toMap()

                val childUpdates = HashMap<String, Any>()
                childUpdates["/mensajes/$destino/$usuario/$key"] = postValues
                childUpdates["/mensajes_usuario/$uid/$destino/$usuario/$key"] = postValues

                database.updateChildren(childUpdates)
            }
        }















    }
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

//===============================================================