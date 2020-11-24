package com.example.corona_update_app

import android.content.Context
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.corona_update_app.adapter.CovidAdapter
import com.example.corona_update_app.model.Covid
import com.example.corona_update_app.model.ResponseServer
import com.example.corona_update_app.network.ConfigNetwork
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_covid.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (isConnect()){
            ConfigNetwork.getRetrofit().getDataCovid().enqueue(object :Callback<ResponseServer>{
                override fun onResponse(call: Call<ResponseServer>, response: Response<ResponseServer>) {
                    Log.d("success",response.message())
                    progress.visibility = View.GONE
                    if(response.isSuccessful){
                        val data = response.body()?.list_data
                        showData(data)
                    }
                }

                override fun onFailure(call: Call<ResponseServer>, t: Throwable) {
                    Log.d("error",t.message)
                    progress.visibility = View.GONE
                }
            })
        } else{
            progress.visibility = View.GONE
            Toast.makeText(this,"Tidak ada jaringan internet",Toast.LENGTH_LONG).show()
        }
    }



    private fun showData(data: ArrayList<Covid>?) {
        listCovid.adapter = CovidAdapter(data)
    }

    fun isConnect():Boolean{
        val connect:ConnectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return connect.activeNetworkInfo != null && connect.activeNetworkInfo.isConnected
    }
}
