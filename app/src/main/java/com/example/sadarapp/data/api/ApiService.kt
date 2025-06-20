package com.example.sadarapp.data.api


import com.example.sadarapp.data.model.Faskes
import retrofit2.Call
import retrofit2.http.GET


interface  ApiService {
    @GET("faskes")
    fun getParkingLogs(): Call<List<Faskes>>
}
