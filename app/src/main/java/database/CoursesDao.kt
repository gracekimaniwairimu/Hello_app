package database

import androidx.room.Insert
import androidx.room.Query

interface CoursesDao {
    @Insert(onConflict=onConflictStrategy.REPLACE)
    fun insertCourse(course: Course)
    @Query(value)
}