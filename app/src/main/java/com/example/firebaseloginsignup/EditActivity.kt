package com.example.firebaseloginsignup

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.example.firebaseloginsignup.databinding.ActivityEditBinding
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class EditActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditBinding
    private lateinit var database : DatabaseReference
    private lateinit var etUser: EditText
    private lateinit var etNama: EditText
    private lateinit var etJenis:EditText
    private lateinit var etKode: EditText
    private lateinit var etJumlah: EditText
    private lateinit var etTanggal: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnUpdate.setOnClickListener{
            val userName= binding.etUser.text.toString()
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


            UpdateData(userName, nama,jenis,kode, jumlah, tanggal)

        }
    }

    private fun UpdateData(userName:String, nama: String, jenis: String, kode: String, jumlah: String, tanggal: String) {
        database= FirebaseDatabase.getInstance().getReference("penjualan")
        val user = mapOf<String,String>(
            "nama" to nama,
            "jenis" to jenis,
            "kode" to kode,
            "jumlah" to jumlah,
            "tanggal" to tanggal
        )
        database.child(userName).updateChildren(user).addOnSuccessListener {
            binding.etUser.text.clear()
            binding.etNama.text.clear()
            binding.etJenis.text.clear()
            binding.etJumlah.text.clear()
            binding.etKode.text.clear()
            binding.etTanggal.text.clear()
            Toast.makeText(this,"Successfuly Updated",Toast.LENGTH_SHORT).show()

        }.addOnFailureListener{
            Toast.makeText(this,"Failed to update",Toast.LENGTH_SHORT).show()
        }

    }
}