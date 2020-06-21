//package com.example.FirebasePrueba
/*package com.example.menuprincipal

import android.annotation.SuppressLint
//import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.database.*
//import kotlinx.android.synthetic.main.activity_main.*
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_registro.*


class Registro : AppCompatActivity() {

    private lateinit var database: DatabaseReference// ...
    private lateinit var postReference: DatabaseReference
    private lateinit var postKey: String
    private var postListener: ValueEventListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registro)
        val txtName=findViewById<TextView>(R.id.txtName)
        val txtPassword=findViewById<TextView>(R.id.txtPassword)
        //val txtUsuario=findViewById<TextView>(R.id.txtUsuario)
        //val txtDestino=findViewById<TextView>(R.id.txtDestino)

        /*postReference = FirebaseDatabase.getInstance().reference
            .child("mensajes")
	    Esta es la parte donde estoy escuchando */

        val btnRegistrar=findViewById<Button>(R.id.btnRegistrar)

        btnRegistrar.setOnClickListener {
            // [START initialize_database_ref]
            database = FirebaseDatabase.getInstance().reference
            // [END initialize_database_ref]
            val key = database.child("mensajes").push().key

            if (key == null) {
                // Log.w("error", "Couldn't get push key for posts")
                Toast.makeText(this, "error", Toast.LENGTH_SHORT).show()

            }

            val name=this.txtName.getText().toString()
            val password=this.txtPassword.getText().toString()
            //val usuario=this.txtUsuario.getText().toString()
            //val mensaje= this.txtMensaje.getText().toString()
            val post = Post(name, password)
            val postValues = post.toMap()

            val childUpdates = HashMap<String, Any>()
            childUpdates["/mensajes/$name/$key"] = postValues
            childUpdates["/mensajes_usuario/$name/$password/$key"] = postValues

            database.updateChildren(childUpdates)
        }


    }
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
                    Toast.makeText(this@Registro,"llego",1)

                }
                // [END_EXCLUDE]
            }

            @SuppressLint("WrongConstant")
            override fun onCancelled(databaseError: DatabaseError) {
                // Getting Post failed, log a message

                Toast.makeText(this@Registro,"error",1)
                // [END_EXCLUDE]
            }
        }
        postReference.addValueEventListener(postListener)
        // [END post_value_event_listener]

        // Keep copy of post listener so we can remove it when app stops
        this.postListener = postListener

        // Listen for comments

    }
}



// [START post_class]
@IgnoreExtraProperties
data class Post(
    var name: String? = "",
    var password: String? = "",
    var destino: String? = "",
    var mensaje: String? = "",
    var starCount: Int = 0,
    var stars: MutableMap<String, Boolean> = HashMap()
) {

    // [START post_to_map]
    @Exclude
    fun toMap(): Map<String, Any?> {
        return mapOf(
            "Nombre" to name,
            "Contraseña" to password
            //"destino" to destino,
            //"mensaje" to mensaje

        )
    }
    // [END post_to_map]
}
 [END post_class]
 */







