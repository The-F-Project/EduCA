package org.thefproject.fedu

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class about : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_about)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val updt = findViewById<View>(R.id.button4)

        updt.setOnClickListener {
//https://github.com/FaliedDedd/edu/releases
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/FaliedDedd/edu/releases")); startActivity(browserIntent);

        }
val back = findViewById<View>(R.id.button5)
        back.setOnClickListener {
            val g = Intent(this, profile::class.java)
            startActivity(g)
        }
    }
}