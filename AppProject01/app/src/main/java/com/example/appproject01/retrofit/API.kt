package com.example.appproject01.retrofit

import retrofit2.Response
import retrofit2.http.GET

interface API {
    @GET("/")
    suspend fun JSON(): Response<DTO>
}