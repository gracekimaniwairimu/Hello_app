package com.example.hello

import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
@POST("login")
fun loginStudent(@Body requestBody: RequestBody) {

    @GET("courses")
    fun getCourses(@Header("Authorization") accessToken: String): Call<CoursesResponse> {

    }
}





