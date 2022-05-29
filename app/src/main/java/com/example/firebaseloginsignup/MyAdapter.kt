package com.example.firebaseloginsignup

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter (private val userList : ArrayList<User>):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val user: TextView = itemView.findViewById(R.id.tvuser)
        val nama : TextView = itemView.findViewById(R.id.tvnamabarang)
        val kode : TextView = itemView.findViewById(R.id.tvkodebarang)
        val jenis : TextView = itemView.findViewById(R.id.tvjenisbarang)
        val jumlah : TextView = itemView.findViewById(R.id.tvjumlahbarang)
        val tanggal : TextView = itemView.findViewById(R.id.tvtanggal)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.user_item,
        parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val curretitem = userList[position]
        holder.user.text = curretitem.userName
        holder.nama.text = curretitem.nama
        holder.kode.text = curretitem.kode
        holder.jenis.text = curretitem.jenis
        holder.jumlah.text = curretitem.jumlah
        holder.tanggal.text = curretitem.tanggal

    }

    override fun getItemCount(): Int {
        return userList.size
    }
}