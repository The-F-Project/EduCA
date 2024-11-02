package org.thefproject.fedu

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class reshebnik8th : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_reshebnik8th)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val main = findViewById<View>(R.id.profile)
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

        val algevra = findViewById<View>(R.id.button2)
        val geometria = findViewById<View>(R.id.button8)
        val english = findViewById<View>(R.id.button9)
        val physic = findViewById<View>(R.id.button10)
        val russian = findViewById<View>(R.id.button11)
        val hemia = findViewById<View>(R.id.button12)


        main.setOnClickListener {
            val g = Intent(this, home::class.java)
            startActivity(g)
        }
        algevra.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://resheba.top/algebra-8-klass-arefeva")); startActivity(browserIntent);

        }
        geometria.setOnClickListener {
            // https://resheba.top/geometrija-10-klass
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://resheba.top/geometrija-8-klass-kazakov")); startActivity(browserIntent);

        }
        english.setOnClickListener {
            // https://resheba.top/anglijskij-jazyk-10-klass
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://resheba.top/anglijskij-jazyk-8-klass")); startActivity(browserIntent);

        }

        physic.setOnClickListener {
            // https://resheba.top/fizika-10-klass

            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://resheba.top/fizika-8-klass")); startActivity(browserIntent);


        }

        hemia.setOnClickListener {
            // https://resheba.top/himija-10-klass

            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://resheba.top/himija-8-klass")); startActivity(browserIntent);

        }

    }
}