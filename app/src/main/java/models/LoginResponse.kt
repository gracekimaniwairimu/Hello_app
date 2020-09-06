package models

import Activities.Student
import com.google.gson.annotations.SerializedName

data class LoginResponse (
@SerializedName("message") var message: String,
@SerializedName("student") var student: Student
) {
    val accessToken: String?
}

