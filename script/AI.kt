package org.thefproject.fedu

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import okhttp3.*
import android.graphics.Bitmap

import com.google.mlkit.vision.common.InputImage

import com.google.mlkit.vision.text.TextRecognition

import com.google.mlkit.vision.text.TextRecognizer
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException
import java.net.InetSocketAddress
import java.net.Proxy


class AI : AppCompatActivity() {
    data class ChatRequest(val model: String, val messages: List<ChatMessage>)
    data class ChatMessage(val role: String, val content: String)

    private lateinit var webView: WebView
    private lateinit var chatbotResponseTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ai)


    }
}