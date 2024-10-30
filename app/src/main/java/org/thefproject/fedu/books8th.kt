package org.thefproject.fedu

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.webkit.WebSettings
import android.webkit.WebView

class books8th : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_books8th)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


       val webView = findViewById<WebView>(R.id.WebView)



        val webSettings: WebSettings = webView.settings

        webSettings.javaScriptEnabled = true



        val pdfFilePath = intent.getStringExtra("pdfFilePath")

        if (pdfFilePath != null) {

            // Загрузите HTML-страницу с PDF.js

            webView.loadUrl("file:///android_asset/pdfpage.html?file=$pdfFilePath")

        }

        val intent = Intent(this, books8th::class.java)

        intent.putExtra("pdfFilePath", "assets/bel_mova_7kl_valochka_rus_bel_2020.pdf") // Например, "file:///storage/emulated/0/Download/sample.pdf"

        startActivity(intent)


    }

    }
