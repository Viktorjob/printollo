package com.app.printollo.api

import android.content.Context
import com.app.printollo.consts.SessionManager
import com.app.printollo.models.RequestModel
import com.app.printollo.models.ResponseModel
import com.app.printollo.models.UserModel
import com.app.printollo.utils.ResultListener
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiHelper(context: Context) {

    private val sessionManager = SessionManager(context)
    fun login(model: RequestModel, resultListener: ResultListener<String>){
        val client = OkHttpClient.Builder().build()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://mfpmonitoring-api.devitmcode.pl") //
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        val service: ApiInterface = retrofit.create(ApiInterface::class.java)
        val repos: Call<ResponseModel> = service.getToken(model)
        repos.enqueue( object : Callback<ResponseModel> {
            override fun onResponse(call: Call<ResponseModel>?, response: Response<ResponseModel>?) {
                println("ora 12121212");
                println(response?.body().toString());
                println("ora 141414141");
                if(response?.body()?.accessToken != null){
                    println(response.body().toString());
                    resultListener.onSuccess(response.body()!!.accessToken)
                    sessionManager.saveAuthToken(response.body()!!.accessToken)
                }else{
                    resultListener.onFail("error")
                }

            }

            override fun onFailure(call: Call<ResponseModel>?, t: Throwable?) {
                println("ora 21212121");

                println(t.toString())
            }
        })
    }
    fun  getUser(resultListener: ResultListener<ArrayList<UserModel>>){
        var token = sessionManager.fetchAuthToken() ?: ""
        val client = OkHttpClient
            .Builder()
            .addInterceptor(
                AutorizationToken("Bearer", token))
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl("http://mfpmonitoring-api.devitmcode.pl")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()

        val service: ApiInterface = retrofit.create(ApiInterface::class.java)

println("ora 68557868657")
        val repos: Call<ArrayList<UserModel>> = service.getUser()
        repos.enqueue( object : Callback<ArrayList<UserModel>> {
            override fun onResponse(call: Call<ArrayList<UserModel>>?,
                                    response: Response<ArrayList<UserModel>>?){
                if(response?.body() != null){
                    println(response.body().toString());
                    resultListener.onSuccess(response.body()!!)
                }
            }

            override fun onFailure(call: Call<ArrayList<UserModel>>?, t: Throwable?) {
                println(t.toString())
            }
        })
    }
}