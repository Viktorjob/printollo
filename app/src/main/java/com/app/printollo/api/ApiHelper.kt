package com.app.printollo.api

import com.app.printollo.models.RequestModel
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiHelper {
    fun login(model: RequestModel){
        val client = OkHttpClient.Builder().build()
        println("ora 2"+ model.toString())
/*
        val retrofit = Retrofit.Builder()
            .baseUrl("https://dummy.restapiexample.com/") //
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        fun<T> buildService(service: Class<T>): T{
            return retrofit.create(service)
        }*/
    }

}