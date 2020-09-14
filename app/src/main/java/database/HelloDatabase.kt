package database

import Activities.Course
import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = arrayOf(Course::class), version = 1)
abstract class HelloDatabase: RoomDatabase() {
    abstract fun courseDao(): CourseDao
}