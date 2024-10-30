package org.thefproject.fedu
import android.os.Bundle;
import android.webkit.WebView;
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class faqmathth10 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_faqmathth10)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

      val webView = findViewById<WebView>(R.id.webview);

        webView.getSettings().setJavaScriptEnabled(true); // Если вам нужен JavaScript

        webView.loadUrl("file:///android_asset/edumain.html");

    }

}