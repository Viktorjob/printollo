package com.app.printollo.api

import android.widget.Toast
import com.app.printollo.models.RequestModel
import com.app.printollo.models.ResponseModel
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

class StorageHelper {
    fun login(login: String, password: String){
        println("ora 1")
        val requestModel = RequestModel(login, password)

        ApiHelper().login(requestModel)
    }
}