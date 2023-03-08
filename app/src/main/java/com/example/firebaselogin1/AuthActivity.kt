package com.example.firebaselogin1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth

class AuthActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        // Obtain the FirebaseAnalytics instance.
        //firebaseAnalytics = Firebase.analytics

        val analytics=FirebaseAnalytics.getInstance(this)
        val bundle=Bundle()
        bundle.putString("message","Integracon de firebase completa")
        analytics.logEvent("InitScreen",bundle)


        onMach()

    }



    fun onMach() {

        val email=findViewById<EditText>(R.id.emailEditText)
        val pasword=findViewById<EditText>(R.id.editTextTextPassword)
        val singButton:Button=findViewById(R.id.SingUpButton)

        singButton.setOnClickListener{

            if(email.text.isNotEmpty()&&pasword.text.isNotEmpty()){

                FirebaseAuth.getInstance().createUserWithEmailAndPassword(
                    email.text.toString(),
                    pasword.text.toString()).addOnCompleteListener{

                        if (it.isSuccessful){}else{
                            showAlert()
                        }
                }
            }
        }
    }

    private fun showAlert() {
        TODO("Not yet implemented")

        
    }


}



