package org.thefproject.fedu

import android.content.Intent
import android.os.Build.VERSION
import android.os.Build.VERSION_CODES
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.time.LocalDateTime
import org.thefproject.fedu.BuildConfig


class pagenotfound : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_pagenotfound)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val osVersion = android.os.Build.VERSION.SDK_INT
        println("Версия Android: $osVersion")
        val osVersionName = android.os.Build.VERSION.RELEASE
        println("Сборка: $osVersionName")


        Toast.makeText(this, "oooops", Toast.LENGTH_SHORT).show()
        val currentDateTime = LocalDateTime.now()
        println("Текущая дата и время: $currentDateTime")

        val textView: TextView = findViewById(R.id.textView11)

        val sdkVersion = android.os.Build.VERSION.SDK_INT
        val Pacname = "PAC-NAME $packageName"
        val versionName = BuildConfig.VERSION_NAME
        val versionCode = BuildConfig.VERSION_CODE
        val sdkVersionText = "Версия SDK: $sdkVersion"

        textView.text =
            "OS VERSION: $osVersion ANDROID BUILD-ID $osVersionName DATA-TIME $currentDateTime SDK-VERSION $sdkVersionText : CLIENT VERSION $versionName BUILD NUMBER $versionCode"



        val back = findViewById<View>(R.id.button6)

        back.setOnClickListener {
            val g = Intent(this, home::class.java)
            startActivity(g)
        }

    }

}