package org.thefproject.fedu

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class reshebnik10english : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_reshebnik10english)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val main = findViewById<View>(R.id.profile)
        main.setOnClickListener {
            val g = Intent(this, home::class.java)
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

        val webView = findViewById<WebView>(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true)
        webView.settings.domStorageEnabled = true
        webView.settings.loadWithOverviewMode = true
        webView.settings.useWideViewPort = true

        webView.loadUrl("https://resheba.top/gdz/10-klass/anglijskij-jazyk");
        webView.webViewClient = object : WebViewClient() {

            override fun onPageFinished(view: WebView?, url: String?) {
                view?.postDelayed({
                    view.loadUrl(
                        "javascript:(function() { " +
                                "var ads = document.querySelectorAll('iframe, .ad, .ads, [id^=ad], [class^=ad], [data-ad-client], [data-ad-slot], window.yaContextCb.push ');" +
                                "ads.forEach(function(ad) { ad.style.display = 'none'; });" +
                                "})()"
                    )
                }, 10) // Задержка в 1 секунду
            }

            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
                // Список URL-адресов для блокировки
                val adUrls = listOf(
                    "ads.example.com", "track.example.com", "yandex.ru",
                    "googlesyndication.com", "google-analytics.com",
                    "adroll.com", "criteo.com", "taboola.com", "outbrain.com",
                    "vk.com", "facebook.com", "twitter.com", "linkedin.com"
                )


                return adUrls.any { url?.contains(it) == true }
            }
        }

    }
    }
