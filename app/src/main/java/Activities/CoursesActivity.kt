package Activities


import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.hello.ApiClient
import com.example.hello.ApiInterface
import com.example.hello.CoursesRecyclerViewAdapter
import com.example.hello.R
import data
import database.HelloDatabase
import models.CoursesResponse
import okhttp3.Call
import okhttp3.Callback
import okhttp3.Response

class Courses(val course_id: Int, val course_name: String, val course_code: Int, val instructor:String, val description:String)
//data class Courses(val course_id: Int, val course_name: String, val course_code: Int, val instructor:String, val description:String)

class CoursesActivity : AppCompatActivity() {
    lateinit var database: HelloDatabase
}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_courses)
         database= Room.databaseBuilder(baseContext, HelloDatabase::class.java, name: "hello-db").build()
        rvCourses.LayoutManager = LinearLayoutManager(baseContext)
        val coursesRecyclerViewAdapter =
            CoursesRecyclerViewAdapter(
                coursesList = listOf(
                    fetchCourses()

                            Courses (20, "Design", 57, "Jane", "Creativity"
                ),
                Courses(
                    90,
                    "Kotlin",
                    49,
                    "Arie",
                    "Android Development"
                ),
                Courses(65, "Python", 35, "James", "Databases"),
                Courses(
                    84,
                    "Html/Css",
                    82,
                    "Jeff",
                    "Web Development"
                ),
                Courses(27, "Javascript", 28, "Lean", "React"),
                Courses(70, "Navigating", 58, "Grey", "Navigation"),
                Courses(56, "C++", 40, "Roy", "Electricals"),
                Courses(
                    39,
                    "Product Design",
                    76,
                    "Barre",
                    "Drafting"
                ),
                Courses(
                    69,
                    "Entreprenuership",
                    25,
                    "Kelly Murungi",
                    "Finance"
                ),
                Courses(
                    50,
                    "Hardware Electronics",
                    33,
                    "Barre Yasin",
                    "Arduino"
                )
    }
    fun fetchCourses() {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(baseContext)
        val accessToken = sharedPreferences.getString("ACCESS_TOKEN_KEY", "")

        val apiClient =
            ApiClient.buildService(ApiInterface::class.java)
        val coursesCall = apiClient.getCourses("Bearer " + accessToken).also {
            it.enqueue(object : Callback<CoursesResponse> {
                override fun onFailure(call: Call<CoursesResponse>, t: Throwable) {
                    Toast.makeText(baseContext, t.message, Toast.LENGTH_LONG).show()
                }

                ))
                rvCourses.adapter=CoursesRecyclerViewAdapter
                override fun onResponse(
                    call: android.telecom.Call<CoursesResponse>,
                    response: Response<CoursesResponse>
                ) {
                    if (response.isSuccessful) {
                        var courseList = response.body()?.courses as List<Course>
                        Thread {
                            corseList.forEach { course ->
                                database.courseDao().insertCourse(course)
                            }
                        } .start()
                        var coursesAdapter =CoursesAdapter(courseList)
                        rvCourses.layoutManager = LinearLayoutManager(baseContext)
                        rvCourses.adapter = coursesAdapter
                    } else {
                        Toast.makeText(baseContext, response.errorBody().toString(), Toast.LENGTH_LONG)
                            .show()
                    }
                }
            })
            fun fetchCoursesFromDatabase(){
                    Thread{
                    var course=database.coursesDao().getALLCourses()
                        runOnUiThread{
                            displayCourses(courses)
                    }.start()

                    }
        }
        fun displayCourses(courses: List<Course>){
            var coursesAdapter=CoursesAdapter(courses)
            rvCourses.layoutManager=linearLayoutManager(baseContext)
            rvCourses.adapter=coursesAdapter
        }
    }



