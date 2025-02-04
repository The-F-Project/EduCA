package org.thefproject.fedu

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class contact : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_contact)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val email = findViewById<View>(R.id.email)
        val back = findViewById<View>(R.id.back)
        val git = findViewById<View>(R.id.git)
        val tg = findViewById<View>(R.id.telegram)


        email.setOnClickListener{
            Toast.makeText(this, "nkgtoffical@gmail.com", Toast.LENGTH_SHORT).show()
        }
        git.setOnClickListener{
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/FaliedDedd")); startActivity(browserIntent);

        }
        tg.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/therockchane")); startActivity(browserIntent);

        }

        back.setOnClickListener {
            val g = Intent(this,  tabout::class.java)
            startActivity(g)
        }
    }
}