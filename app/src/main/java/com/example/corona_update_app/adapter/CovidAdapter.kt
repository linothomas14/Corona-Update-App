package com.example.corona_update_app.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.corona_update_app.MainActivity
import com.example.corona_update_app.R
import com.example.corona_update_app.item_covid_activity
import com.example.corona_update_app.model.Covid
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.item_covid.view.*
import java.util.ArrayList

class CovidAdapter(var data: ArrayList<Covid>?) :RecyclerView.Adapter<CovidAdapter.CovidHolder>() {
    class CovidHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val provinsi = itemView.itemProvinsi
        val kasus = itemView.kasus
        val  dirawat= itemView.dirawat
        val  sembuh= itemView.sembuh
        val  meninggal= itemView.meninggal
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CovidHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_covid,parent,false)
        val holder = CovidHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: CovidHolder, position: Int) {
        holder.provinsi.text = data?.get(position)?.key
        holder.kasus.text = "Jumlah kasus :" + data?.get(position)?.jumlah_kasus
        holder.dirawat.text = "Jumlah dirawat :" + data?.get(position)?.jumlah_dirawat
        holder.meninggal.text = "Jumlah meninggal : " + data?.get(position)?.jumlah_meninggal
        holder.sembuh.text = "Jumlah sembuh : " + data?.get(position)?.jumlah_sembuh

    }

    override fun getItemCount(): Int {
       return data?.size?: 0
    }

}




