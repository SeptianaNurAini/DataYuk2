package com.example.firebaseloginsignup

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.firebaseloginsignup.databinding.ActivityInputBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


class InputActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityInputBinding
    private lateinit var database: DatabaseReference
    private lateinit var etUser: EditText
    private lateinit var etNama: EditText
    private lateinit var etJenis:EditText
    private lateinit var etKode: EditText
    private lateinit var etJumlah: EditText
    private lateinit var etTanggal: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInputBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnSave.setOnClickListener{

            val userName = binding.etUser.text.toString()
            val nama = binding.etNama.text.toString()
            val jenis = binding.etJenis.text.toString()
            val kode = binding.etKode.text.toString()
            val jumlah = binding.etJumlah.text.toString()
            val tanggal = binding.etTanggal.text.toString()

            if (userName.isEmpty()){
                etUser.error="create username"
                return@setOnClickListener
            }
            if (nama.isEmpty()){
                etNama.error="create nama"
                return@setOnClickListener
            }
            if (jenis.isEmpty()){
                etJenis.error="create jenis"
                return@setOnClickListener
            }
            if (kode.isEmpty()){
                etKode.error="create kode"
                return@setOnClickListener
            }
            if (jumlah.isEmpty()){
                etJumlah.error="create jumlah"
                return@setOnClickListener
            }
            if (tanggal.isEmpty()){
                etTanggal.error="create tanggal"
                return@setOnClickListener
            }

            database=FirebaseDatabase.getInstance().getReference("penjualan")
            val User = User(userName, nama, kode, jenis, jumlah, tanggal)

            database.child(userName).setValue(User).addOnSuccessListener {
                binding.etUser.text.clear()
                binding.etNama.text.clear()
                binding.etJenis.text.clear()
                binding.etJumlah.text.clear()
                binding.etKode.text.clear()
                binding.etTanggal.text.clear()


            Toast.makeText(this,"Successfuly Saved",Toast.LENGTH_SHORT).show()
            }.addOnFailureListener{
                Toast.makeText(this, "Failed",Toast.LENGTH_SHORT).show()
            }
        }

    }

    override fun onClick(v: View) {
        TODO("Not yet implemented")
    }
}