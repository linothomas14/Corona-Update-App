package com.example.corona_update_app.network

import com.example.corona_update_app.model.ResponseServer
import retrofit2.Call
import retrofit2.http.GET

interface CovidService {

    @GET("public/api/prov.json")
    fun getDataCovid():Call<ResponseServer>

}
