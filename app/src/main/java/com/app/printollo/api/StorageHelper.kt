package com.app.printollo.api

import android.content.Context
import android.widget.Toast
import com.app.printollo.models.RequestModel
import com.app.printollo.models.ResponseModel
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class StorageHelper() {
    fun login(login: String, password: String, context: Context){
        val requestModel = RequestModel(login, password)

        ApiHelper(context).login(requestModel, context)
    }
    fun getUser(context: Context){
        ApiHelper(context).getUser(context)
    }
}