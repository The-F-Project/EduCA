package org.thefproject.fedu

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class reshebniklist : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_reshebniklist)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val profile = findViewById<View>(R.id.profile)
        profile.setOnClickListener {
            val g = Intent(this, home::class.java)
            startActivity(g)
        }
        val predmet = findViewById<View>(R.id.prdmet)
        predmet.setOnClickListener {
            val g = Intent(this, bookslist::class.java)
            startActivity(g)
        }
        val gdz = findViewById<View>(R.id.reshebnik)
        gdz.setOnClickListener {
            val g = Intent(this, reshebniklist::class.java)
            startActivity(g)
        }
        val clas10th = findViewById<View>(R.id.button3)

        clas10th.setOnClickListener {
            val g = Intent(this, reshebnik10th::class.java)
            startActivity(g)
        }
        val clas9th = findViewById<View>(R.id.button2)

        clas9th.setOnClickListener {
            val g = Intent(this, reshebnik9th::class.java)
            startActivity(g)
        }

        val clas8th = findViewById<View>(R.id.button)

        clas8th.setOnClickListener {
            val g = Intent(this, reshebnik8th::class.java)
            startActivity(g)
        }
    }
}