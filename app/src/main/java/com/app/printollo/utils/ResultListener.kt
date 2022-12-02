package com.app.printollo.utils

interface ResultListener<S> {
    fun onSuccess(successModel: S)
    fun onFail(any: String?)
    fun onError(e: Throwable?)
}