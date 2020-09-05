package Activities

import androidx.annotation.NonNull
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
var courseId: String,
var courseName: String,
var courseCode: String,
var instructor: String,
var description: String = ""
@PrimaryKey @NonNull @SerializedName("course_id") var courseId: String,
@SerializedName("course_name") var courseName: String,
@SerializedName("course_code") var courseCode: String,
@SerializedName("instructor") var instructor: String,
