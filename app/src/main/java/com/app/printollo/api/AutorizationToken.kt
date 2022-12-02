package com.app.printollo.api

import okhttp3.Interceptor

class AutorizationToken(private val tokenType: String, private val acceessToken: String):
    Interceptor {

    override fun intercept(chain: Interceptor.Chain): okhttp3.Response {
        var request = chain.request()
        request = request.newBuilder().header("Authorization", "$tokenType $acceessToken").build()

        return chain.proceed(request)
    }
}