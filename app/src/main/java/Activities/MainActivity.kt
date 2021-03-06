package Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import api.ApiClient
import api.ApiInterface
import com.example.hello.R
import kotlinx.android.synthetic.main.activity_main.*
import models.RegistrationResponse
import okhttp3.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tvRegisterHere.setOnClickListener {
            val intent=Intent(baseContext,
                RegistrationActivity::class.java)
        }
     btnLogin.setOnClickListener {
         var userName=etUsername.text.toString()
         var password=etPassword.text.toString()
         var requestBody = MultipartBody.Builder()
             .setType(MultipartBody.FORM)
             .addFormDataPart("username", userName)
             .addFormDataPart("password", password)
             .build()

         registerUser(requestBody)
         Toast.makeText(baseContext, userName, Toast.LENGTH_SHORT).show()
     }
    }


    fun registerUser(requestBody: RequestBody) {
        var apiClient=
            ApiClient.buildService(ApiInterface::class.java)
        var registrationCall = apiClient.registerStudent(requestBody)
        registrationCall.enqueue(object : Callback<RegistrationResponse> {
            override fun onFailure(call: Call<RegistrationResponse>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(
                call: Call<RegistrationResponse>,

                response: Response<RegistrationResponse>
            ) {
                if (response.isSuccessful) {
                    Toast.makeText(baseContext, response.body()?.message, Toast.LENGTH_LONG).show()
                    startActivity(Intent(baseContext, MainActivity::class.java))
                } else {
                    Toast.makeText(baseContext, response.errorBody().toString(), Toast.LENGTH_LONG)
                        .show()
                }
            }
        })
    }

}









