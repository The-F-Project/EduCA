package org.thefproject.fedu

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class reshebnik20thenglishtype : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_reshebnik20thenglishtype)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val workbook = findViewById<View>(R.id.workbook)
        val book = findViewById<View>(R.id.studentbook)
        workbook.setOnClickListener {

            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://resheba.top/workbook-anglijskij-jazyk-10-klass")); startActivity(browserIntent);

        }

        book.setOnClickListener {
            // https://resheba.top/anglijskij-jazyk-10-klass
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://resheba.top/anglijskij-jazyk-10-klass")); startActivity(browserIntent);
        }

    }
}