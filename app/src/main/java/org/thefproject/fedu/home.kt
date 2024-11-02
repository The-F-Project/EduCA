package org.thefproject.fedu

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.ScrollView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.thefproject.fedu.databinding.ActivityMainBinding

class home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        lateinit var binding: ActivityMainBinding
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
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
        val about = findViewById<View>(R.id.about)
        val upd = findViewById<View>(R.id.about2)

        about.setOnClickListener {
            val g = Intent(this, tabout::class.java)
            startActivity(g)
        }
 val don = findViewById<View>(R.id.about3)
        don.setOnClickListener {
            val g = Intent(this, donate::class.java)
            startActivity(g)
        }
val faq = findViewById<View>(R.id.about4)

        faq.setOnClickListener{
            val g = Intent(this, faqmathth10::class.java)
            startActivity(g)

        }

    }
}