package com.example.firebaseloginsignup

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class ResetPasswordActivity : AppCompatActivity() {

    private lateinit var btnreset : Button
    private lateinit var etemail : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        btnreset = findViewById(R.id.btnResetPassword)
        etemail = findViewById(R.id.etEmail)

        btnreset.setOnClickListener{
            val email = etemail.text.toString().trim()

            if (email.isEmpty()){
                etemail.error = "Create Email!"
                etemail.requestFocus()
                return@setOnClickListener
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                etemail.error = "Email Not Valid!"
                etemail.requestFocus()
                return@setOnClickListener
            }
           FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnCompleteListener {
               if (it.isSuccessful){
                   Toast.makeText(this,"Check Email for Password", Toast.LENGTH_SHORT).show()
                   Intent(this@ResetPasswordActivity, LoginActivity::class.java).also {
                       it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                       startActivity(it)
                   }
               }else{
                   Toast.makeText(this, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
               }
           }
        }

    }
}


