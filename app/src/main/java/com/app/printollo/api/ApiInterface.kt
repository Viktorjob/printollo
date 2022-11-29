package com.app.printollo.api

import com.app.printollo.models.RequestModel
import com.app.printollo.models.ResponseModel
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {

    @POST("api/v1/create")
    fun login(@Body requestModel: RequestModel) : Call<ResponseModel>
}