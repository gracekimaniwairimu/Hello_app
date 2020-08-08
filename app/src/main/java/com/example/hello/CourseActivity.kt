package com.example.hello

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.row_course_item.*

data class Courses(val course_id: Int, val course_name: String, val course_code: Int, val instructor:String, val description:String)
class CourseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course)class CourseActivity : AppCompatActivity() {
            override fun onCreate(savedInstanceState: Bundle?) {
                super.onCreate(savedInstanceState)
                setContentView(R.layout.activity_course)

                rvCourses.LayoutManager = LinearLayoutManager(baseContext)
                val coursesRecyclerViewAdapter = CoursesRecyclerViewAdapter(coursesList = listOf(

                    Courses(23,"JavaScript",123,"Purity","Good Listener"),
                    Courses(79,"Kotlin",124,"John ","Creative"),
                    Courses(22,"HardwareElectronics",125,"Barre","Creative"),
                    Courses(30,"Html/Css",126,"Grace","Creative"),
                    Courses(40,"DataScience",127,"Phiona","Creative"),
                    Courses(20,"Hardware Design",128,"Betty","Creactivity"),
                    Courses(1,"PD",129,"Steph","Patience"),
                    Courses(10,"UI/UX design",130,"Juliana","creative"),
                    Courses(43,"python",131,"Kimani","creative"),
                    Courses(70,"Navigating",132,"Yegon","creative")



                ))
                rvCourses.adapter=coursesRecyclerViewAdapter
            }
        }



    }
}