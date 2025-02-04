package org.thefproject.fedu

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.FileInputStream


class shcoolproject : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_shcoolproject)
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
        val profile = findViewById<View>(R.id.profile)
        profile.setOnClickListener {
            val g = Intent(this, home::class.java)
            startActivity(g)
        }

        val hemia = findViewById<View>(R.id.button15)


        val start = findViewById<View>(R.id.button15)
        val video = findViewById<View>(R.id.button17)

        start.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/The-F-Project/game/releases/download/q2/v2.pdf")); startActivity(browserIntent);

        }
video.setOnClickListener {

    val browserIntent = Intent(
        Intent.ACTION_VIEW,
        Uri.parse("https://github.com/The-F-Project/game/releases/download/q3/Nouveau.projet.mp4")
    ); startActivity(browserIntent);
}
    }
}