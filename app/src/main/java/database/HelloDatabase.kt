package database

import androidx.room.Database
import androidx.room.RoomDatabase

class HelloDatabase {
    @Database(entities = arrayOf(course::class), version = 1)
    abstract class HelloDatabase: RoomDatabase() {
        abstract fun courseDao(): CourseDao
    }
}