package com.app.printollo.models

data class ResponseModel(
    val accessToken: String,
    val refreshToken: String,
    val expiresAt: String,
    val isUpdated: String
)