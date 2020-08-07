package layout

class class_row_items {
    package com.example.helo
    import androidx.appcompat.app.AppCompatActivity
    import android.os.Bundle
    class row_courses_item : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_row_courses_item)
            data class Courses(
                var id: "int"
            var name: String,
            var code: "int",
            var instructor: String,
            var description: String
            )
        }
}