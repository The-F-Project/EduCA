package org.thefproject.fedu

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.net.Uri
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream

class book_algebra_10th : AppCompatActivity() {
    private lateinit var webView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_book_algebra10th)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        webView = findViewById(R.id.webView)

        webView.webViewClient = WebViewClient()




        val pdfFilePath = copyPdfFromAssets("algebra.pdf")

        val pdfUri = Uri.fromFile(File(pdfFilePath))


        // Загружаем PDF-файл в WebView через Google Docs Viewer

        webView.loadUrl("https://docs.google.com/gview?embedded=true&url=$pdfUri")

    }


    // Копируем PDF-файл из assets во временную папку

    private fun copyPdfFromAssets(fileName: String): String {

        val file = File(cacheDir, fileName)

        if (!file.exists()) {

            try {

                val inputStream: InputStream = assets.open(fileName)

                val outputStream = FileOutputStream(file)

                val buffer = ByteArray(1024)

                var length: Int


                while (inputStream.read(buffer).also { length = it } > 0) {

                    outputStream.write(buffer, 0, length)

                }


                outputStream.close()

                inputStream.close()

            } catch (e: IOException) {

                e.printStackTrace()

            }

        }

        return file.absolutePath

    }


    override fun onBackPressed() {

        if (webView.canGoBack()) {

            webView.goBack()

        } else {

            super.onBackPressed()

        }

    }
}
