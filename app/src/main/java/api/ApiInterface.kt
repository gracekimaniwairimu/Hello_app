package api


import Activities.RegistrationActivity
import models.CoursesResponse
import models.LoginResponse
import models.RegistrationResponse
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.*
interface ApiInterface {
    @POST("register")
    fun registerStudent(@Body requestBody: RequestBody): Call<RegistrationResponse>
    @POST("login")
    fun loginStudent(@Body requestBody: RequestBody): Call<LoginResponse>


    @GET("courses")
    fun getCourses(@Header("Authorization") accessToken: String): Call<CoursesResponse>

    @POST("register-course")
    fun registerCourse(
        @Body requestBody: RequestBody,
        @Header("Authorization") accessToken: String
    ): Call<RegistrationActivity>

    abstract fun RegistrationActivity(requestBody: MultipartBody, s: String): Any

}



