package com.app.printollo.api

import com.app.printollo.models.RequestModel
import com.app.printollo.models.ResponseModel
import com.app.printollo.models.UserModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface ApiInterface {

    @POST("/api/MobileAppAuth/GetToken")
    fun getToken(@Body requestModel: RequestModel) : Call<ResponseModel>

    @GET("/api/User/Get")
    fun getUser() : Call<ArrayList<UserModel>>
}