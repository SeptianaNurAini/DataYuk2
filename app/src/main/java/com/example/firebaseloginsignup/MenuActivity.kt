package com.example.firebaseloginsignup

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView


class MenuActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val cardInputActivity: CardView = findViewById(R.id.cardInput)
        cardInputActivity.setOnClickListener(this)

        val cardListActivity: CardView = findViewById(R.id.cardList)
        cardListActivity.setOnClickListener(this)

        val cardEditActivity:CardView = findViewById(R.id.cardEdit)
        cardEditActivity.setOnClickListener(this)

        val cardDeleteActivity: CardView = findViewById(R.id.cardDelete)
        cardDeleteActivity.setOnClickListener(this)

        val cardLogoutActivity: CardView = findViewById(R.id.cardProfil)
        cardLogoutActivity.setOnClickListener(this)


    }

    override fun onClick(v: View) {

        when(v.id){
            R.id.cardInput -> {
                val inputactivity = Intent(this, InputActivity::class.java)
                startActivity(inputactivity)
            }
        }
        when(v.id){
            R.id.cardList -> {
                val listactivity = Intent(this, UserListActivity::class.java)
                startActivity(listactivity)
            }
        }
        when(v.id){
            R.id.cardEdit -> {
                val editactivity = Intent(this, EditActivity::class.java)
                startActivity(editactivity)
            }
        }
        when(v.id){
            R.id.cardProfil -> {
                val logoutactivity = Intent(this, LogoutActivity::class.java)
                startActivity(logoutactivity)
            }
        }
        when(v.id){
            R.id.cardDelete -> {
                val deleteActivity = Intent(this, DeleteActivity::class.java)
                startActivity(deleteActivity)
            }
        }
    }
}