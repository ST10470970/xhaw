package com.example.myapplication
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R

class ContactActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_contact)

        findViewById<Button>(R.id.btnBackContact).setOnClickListener {
            finish()
        }
    }
}