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

class rshebnik10thgeometria : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_rshebnik10thgeometria)
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

        val webView = findViewById<WebView>(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.settings.domStorageEnabled = true
        webView.settings.loadWithOverviewMode = true
        webView.settings.useWideViewPort = true


        webView.loadUrl("https://resheba.top/geometrija-10-klass");

        fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {

            // Блокировка URL-адресов рекламы

            val adUrls = listOf("ads.example.com", "track.example.com" , "yandex.ru")

            return adUrls.any { url?.contains(it) == true }

        }



        webView.webViewClient = object : WebViewClient() {

            override fun onPageFinished(view: WebView?, url: String?) {



                view?.postDelayed({

                    view.loadUrl(

                        "javascript:(function() { " +

                                "var ads = document.querySelectorAll('iframe, .ad, .ads, [id^=ad], [class^=ad]');" +

                                "ads.forEach(function(ad) { ad.style.display = 'none'; });" +

                                "})()"

                    )

                }, 1000) // Задержка в 1 секунду

            }


            override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {

                return if (url != null && (url.contains("ad") || url.contains("advert") ||

                            url.contains("advert") ||
                            url.contains("mc.yandex.ru") ||
                            url.contains("direct.yandex.ru") ||
                            url.contains("https://yandex.ru/ads/system/context.js") ||
                            url.contains("yandex.by") ||
                            url.contains("https://yandex.ru/routing/?utm_source=yandex&utm_medium=cpm&utm_campaign=yandex_routing_msk\n") ||
                            url.contains("yandex.ru") ||
                            url.contains("yastatic.net") ||
                            url.contains("ya.ru") ||
                            url.contains("metrika.yandex.ru") ||
                            url.contains("google-analytics.com") ||
                            url.contains("googlesyndication.com") ||
                            url.contains("googletagmanager.com") ||
                            url.contains("vk.com") ||
                            url.contains("facebook.com") ||
                            url.contains("twitter.com") ||
                            url.contains("linkedin.com") ||
                            url.contains("adroll.com") ||
                            url.contains("criteo.com") ||
                            url.contains("taboola.com") ||
                            url.contains("outbrain.com") ||
                            url.contains("mixpanel.com") ||
                            url.contains("hotjar.com") ||
                            url.contains("fullstory.com")))


                {

                    true

                } else {

                    false
                }

            }

        }


        webView.loadUrl("https://resheba.top/geometrija-10-klass")
    }
}