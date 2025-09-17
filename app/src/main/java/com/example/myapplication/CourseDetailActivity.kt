package com.example.myapplication
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class CourseDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_detail)

        val courseName = intent.getStringExtra("courseName") ?: "Unknown"
        val tvCourseTitle = findViewById<TextView>(R.id.tvCourseTitle)
        val tvCourseFees = findViewById<TextView>(R.id.tvCourseFees)
        val tvCoursePurpose = findViewById<TextView>(R.id.tvCoursePurpose)
        val tvCourseContent = findViewById<TextView>(R.id.tvCourseContent)
        val btnBackDetail = findViewById<Button>(R.id.btnBackDetail)

        // Map of all courses with their details
        val courseDetails = mapOf(
            "First Aid" to Triple("R1500", "To provide first aid awareness and basic life support",
                "Wounds and bleeding, Burns and fractures, Emergency scene management, Cardio-Pulmonary Resuscitation (CPR), Respiratory distress (e.g., choking, blocked airway)"),
            "Sewing" to Triple("R1500", "To provide alterations and new garment tailoring services",
                "Types of stitches, Threading a sewing machine, Sewing buttons, zips, hems and seams, Alterations, Designing and sewing new garments"),
            "Landscaping" to Triple("R1500", "To provide landscaping services for new and established gardens",
                "Indigenous and exotic plants and trees, Fixed structures (fountains, statues, benches, tables, built-in braai), Balancing of plants and trees in a garden, Aesthetics of plant shapes and colours, Garden layout"),
            "Life Skills" to Triple("R1500", "To provide skills to navigate basic life necessities",
                "Opening a bank account, Basic labour law (know your rights), Basic reading and writing literacy, Basic numeric literacy"),
            "Child Minding" to Triple("R750", "To provide basic child and baby care",
                "Birth to six-month old baby needs, Seven-month to one year old needs, Toddler needs, Educational toys"),
            "Cooking" to Triple("R750", "To prepare and cook nutritious family meals",
                "Nutritional requirements for a healthy body, Types of protein, carbohydrates and vegetables, Planning meals, Tasty and nutritious recipes, Preparation and cooking of meals"),
            "Garden Maintenance" to Triple("R750", "To provide basic knowledge of watering, pruning and planting in a domestic garden",
                "Water restrictions and the watering requirements of indigenous and exotic plants, Pruning and propagation of plants, Planting techniques for different plant types")
        )

        // Retrieve and display course details
        val (fees, purpose, content) = courseDetails[courseName] ?: Triple("N/A", "N/A", "N/A")
        if (fees == "N/A") {
            tvCourseTitle.text = "Course Not Found"
            tvCourseFees.text = ""
            tvCoursePurpose.text = ""
            tvCourseContent.text = ""
        } else {
            tvCourseTitle.text = courseName
            tvCourseFees.text = "Fees: $fees"
            tvCoursePurpose.text = "Purpose: $purpose"
            tvCourseContent.text = "Content: $content"
        }

        // Back button functionality
        btnBackDetail.setOnClickListener {
            finish()
        }
    }
}