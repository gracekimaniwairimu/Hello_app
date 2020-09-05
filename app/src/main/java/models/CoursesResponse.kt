
package models

import Activities.Courses
import com.google.gson.annotations.SerializedName

data class CoursesResponse (
    @SerializedName("courses") var courses: List<Courses>
)




