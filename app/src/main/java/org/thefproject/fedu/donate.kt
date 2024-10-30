package org.thefproject.fedu

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class donate : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_donate)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val gt = findViewById<View>(R.id.button13)
        val back = findViewById<View>(R.id.button14)

        gt.setOnClickListener{

            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/therockchane")); startActivity(browserIntent);

        }

        back.setOnClickListener {
            val g = Intent(this,home::class.java)
            startActivity(g)
        }
    }
}