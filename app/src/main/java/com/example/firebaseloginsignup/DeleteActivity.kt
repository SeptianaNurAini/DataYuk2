package com.example.firebaseloginsignup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.firebaseloginsignup.databinding.ActivityDeleteBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DeleteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDeleteBinding
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityDeleteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnDelete.setOnClickListener{
            var userName = binding.etusername.text.toString()
            if (userName.isNotEmpty())
                deleteData(userName)
            else
                Toast.makeText(this, "Please Enter UserName", Toast.LENGTH_SHORT).show()
        }
    }

    private fun deleteData(userName: String) {
        database  = FirebaseDatabase.getInstance().getReference("penjualan")
        database.child(userName).removeValue().addOnSuccessListener {

            binding.etusername.text.clear()
            Toast.makeText(this, "Successfuly Deleted",Toast.LENGTH_SHORT).show()
        }.addOnFailureListener {
            Toast.makeText(this,"Failed",Toast.LENGTH_SHORT).show()
        }
    }

}