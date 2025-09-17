package com.example.myapplication
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnSixMonthCourses = findViewById<Button>(R.id.btnSixMonthCourses)
        val btnSixWeekCourses = findViewById<Button>(R.id.btnSixWeekCourses)
        val btnCalculateFees = findViewById<Button>(R.id.btnCalculateFees)
        val btnContact = findViewById<Button>(R.id.btnContact)

        if (btnSixMonthCourses == null || btnSixWeekCourses == null || btnCalculateFees == null || btnContact == null) {
            // Log or handle the error (for debugging)
            return
        }

        btnSixMonthCourses.setOnClickListener {
            startActivity(Intent(this, SixMonthCoursesActivity::class.java))
        }
        btnSixWeekCourses.setOnClickListener {
            startActivity(Intent(this, SixMonthCoursesActivity::class.java)) // Update to SixWeekCoursesActivity if implemented
        }
        btnCalculateFees.setOnClickListener {
            startActivity(Intent(this, CalculateFeesActivity::class.java))
        }
        btnContact.setOnClickListener {
            startActivity(Intent(this, ContactActivity::class.java))
        }
    }
}