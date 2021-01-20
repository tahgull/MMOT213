package com.example.picturebook

import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth = FirebaseAuth.getInstance()


        val currentUser = auth.currentUser


        if (currentUser!= null){
            val intent  = Intent(applicationContext,SavePhoto::class.java)
            startActivity(intent)
            finish()

        }
    }

    fun signInClick(view: View){

        progressBar.max = 3
        val currentProgress = 6
        ObjectAnimator.ofInt(progressBar,"progress",currentProgress)
            .setDuration(2000)
            .start()

        auth.signInWithEmailAndPassword(userEmailText.text.toString(), passwordText.text.toString()).addOnCompleteListener { task ->



            if (task.isSuccessful){

                //Giriş işlemi
                Toast.makeText(applicationContext,"Hoşgeldin: ${auth.currentUser?.email.toString()}",Toast.LENGTH_LONG).show()
                val intent  = Intent(applicationContext,SavePhoto::class.java)
                startActivity(intent)
                finish()

            }
        }.addOnFailureListener { exception ->
            Toast.makeText(applicationContext,exception.localizedMessage.toString(),Toast.LENGTH_LONG).show()
        }

    }
    fun signUpClick(view: View){

        val email = userEmailText.text.toString()
        val password = passwordText.text.toString()

        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener {task ->
            if (task.isSuccessful){
                val intent = Intent(applicationContext,SavePhoto::class.java)
                startActivity(intent)
                finish()
            }
        }.addOnFailureListener { exception ->
            if(exception!=null){
                Toast.makeText(applicationContext,exception.localizedMessage.toString(),Toast.LENGTH_LONG).show()
            }
        }


    }

}