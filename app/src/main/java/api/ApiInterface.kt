package api

import models.RegistrationResponse
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

@@ -10,6 +11,7 @@ interface ApiInterface {
    @POST("register")

    fun registerStudent(@Body requestBody: RequestBody): Call<RegistrationResponse>
    abstract fun getCourses(s: String): Any
}




