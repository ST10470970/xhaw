package com.example.myapplication
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class SixMonthCoursesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_six_month_courses)

        val courses = listOf("First Aid", "Sewing", "Landscaping", "Life Skills")
        val tvCourses = listOf(
            findViewById<TextView>(R.id.tvCourse1),
            findViewById<TextView>(R.id.tvCourse2),
            findViewById<TextView>(R.id.tvCourse3),
            findViewById<TextView>(R.id.tvCourse4)
        )

        courses.forEachIndexed { index, course ->
            tvCourses[index].text = course
            tvCourses[index].setOnClickListener {
                val intent = Intent(this, CourseDetailActivity::class.java)
                intent.putExtra("courseName", course)
                startActivity(intent)
            }
        }

        findViewById<Button>(R.id.btnBack).setOnClickListener {
            finish()
        }
    }
}