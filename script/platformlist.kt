package org.thefproject.fedu

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class platformlist : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_platformlist)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val k10 = findViewById<View>(R.id.button3)
        val k9 = findViewById<View>(R.id.button2)
        val k8 = findViewById<View>(R.id.button)


        k10.setOnClickListener {

            val intent = Intent(this, dop10classlist::class.java)
            startActivity(intent)

        }

        k9.setOnClickListener {

            val intent = Intent(this, dop9classlist::class.java)
            startActivity(intent)
        }

        k8.setOnClickListener {
            val intent = Intent(this, dop8classlist::class.java)
            startActivity(intent)

        }
    }
}