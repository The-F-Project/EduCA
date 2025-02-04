package org.thefproject.fedu

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class bookslist : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_bookslist)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val class7 = findViewById<View>(R.id.class7)
        val class8 = findViewById<View>(R.id.class8)
        val class9 = findViewById<View>(R.id.class9)
        val class10 = findViewById<View>(R.id.class10)
        val class11 = findViewById<View>(R.id.class11)




        class7.setOnClickListener {
            val g = Intent(this, book7th::class.java)
            startActivity(g)
        }



        class8.setOnClickListener {
            val g = Intent(this, book8th::class.java)
            startActivity(g)
        }



        class9.setOnClickListener {
            val g = Intent(this, book9th::class.java)
            startActivity(g)
        }



        class10.setOnClickListener {
            val g = Intent(this, books10th::class.java)
            startActivity(g)
        }



        class11.setOnClickListener {
            val g = Intent(this, book11th::class.java)
            startActivity(g)
        }


        val predmets = findViewById<View>(R.id.prdmet)
        predmets.setOnClickListener {
            val g = Intent(this, bookslist::class.java)
            startActivity(g)

        }
        val reshebnik10 = findViewById<View>(R.id.reshebnik)

        reshebnik10.setOnClickListener {
            val g = Intent(this, reshebniklist::class.java)
            startActivity(g)
        }
        val profile = findViewById<View>(R.id.profile)
        profile.setOnClickListener {
            val g = Intent(this, home::class.java)
            startActivity(g)
        }

    }
}