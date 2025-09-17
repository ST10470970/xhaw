package com.example.myapplication
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class CalculateFeesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate_fees)

        val etName = findViewById<EditText>(R.id.etName)
        val etPhone = findViewById<EditText>(R.id.etPhone)
        val etEmail = findViewById<EditText>(R.id.etEmail)
        val cbFirstAid = findViewById<CheckBox>(R.id.cbFirstAid)
        val cbSewing = findViewById<CheckBox>(R.id.cbSewing)
        val cbLandscaping = findViewById<CheckBox>(R.id.cbLandscaping)
        val cbLifeSkills = findViewById<CheckBox>(R.id.cbLifeSkills)
        val cbChildMinding = findViewById<CheckBox>(R.id.cbChildMinding)
        val cbCooking = findViewById<CheckBox>(R.id.cbCooking)
        val cbGardenMaintenance = findViewById<CheckBox>(R.id.cbGardenMaintenance)
        val btnCalculate = findViewById<Button>(R.id.btnCalculate)
        val tvTotalFees = findViewById<TextView>(R.id.tvTotalFees)
        val btnBackCalc = findViewById<Button>(R.id.btnBackCalc)

        val courseFees = mapOf(
            "First Aid" to 1500.0,
            "Sewing" to 1500.0,
            "Landscaping" to 1500.0,
            "Life Skills" to 1500.0,
            "Child Minding" to 750.0,
            "Cooking" to 750.0,
            "Garden Maintenance" to 750.0
        )

        btnCalculate.setOnClickListener {
            val selectedCourses = listOf(
                Pair("First Aid", cbFirstAid.isChecked),
                Pair("Sewing", cbSewing.isChecked),
                Pair("Landscaping", cbLandscaping.isChecked),
                Pair("Life Skills", cbLifeSkills.isChecked),
                Pair("Child Minding", cbChildMinding.isChecked),
                Pair("Cooking", cbCooking.isChecked),
                Pair("Garden Maintenance", cbGardenMaintenance.isChecked)
            ).filter { it.second }.map { it.first }

            if (selectedCourses.isEmpty()) {
                Toast.makeText(this, "Please select at least one course", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val totalBase = selectedCourses.sumOf { courseFees[it] ?: 0.0 }
            val discount = when (selectedCourses.size) {
                2 -> 0.05
                3 -> 0.10
                in 4..Int.MAX_VALUE -> 0.15
                else -> 0.0
            }
            val discountedTotal = totalBase * (1 - discount)
            val vat = discountedTotal * 0.15
            val totalWithVat = discountedTotal + vat

            tvTotalFees.text = "Total Fees (incl. 15% VAT): R${"%.2f".format(totalWithVat)}"
        }

        btnBackCalc.setOnClickListener {
            finish()
        }
    }
}