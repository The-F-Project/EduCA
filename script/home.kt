package org.thefproject.fedu

import android.content.Intent
import android.content.SharedPreferences
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.webkit.WebView
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.preference.PreferenceManager
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException
import java.time.LocalDateTime

import java.time.format.DateTimeFormatter
import java.util.Calendar

class home : AppCompatActivity() {
    private lateinit var spinner: Spinner

    private lateinit var selection: TextView
    private  var countries = arrayOf("Беларусь, Россия, Казахстан, Украина")
    private lateinit var sharedPreferences: SharedPreferences
    private var downloadId: Long = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContentView(R.layout.activity_home)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }
        val timeOfDayTextView: TextView = findViewById(R.id.textViewTime)

        val timeOfDay = getTimeOfDay()

        timeOfDayTextView.text = timeOfDay


            val osVersion = android.os.Build.VERSION.SDK_INT
        println("Версия Android: $osVersion")
        val osVersionName = android.os.Build.VERSION.RELEASE
        println("Сборка: $osVersionName")
val dop = findViewById<Button>(R.id.about5)

        dop.setOnClickListener{
            val g = Intent(this, platformlist::class.java)
            startActivity(g)
            checkForUpdates()
        }


        val textView = findViewById<TextView>(R.id.textViewTime)


        val currentDateTime = LocalDateTime.now()

        val formatter = DateTimeFormatter.ofPattern("HH:mm")

        val formattedTime = currentDateTime.format(formatter)

        textView.text = "Сейчас: $formattedTime"

        val predmets = findViewById<View>(R.id.prdmet)
        predmets.setOnClickListener {
            val g = Intent(this, bookslist::class.java)
            startActivity(g)
            checkForUpdates()
        }

        val reshebnik10 = findViewById<View>(R.id.reshebnik)
        reshebnik10.setOnClickListener {

            val g = Intent(this, reshebniklist::class.java)
            startActivity(g)
            checkForUpdates()
        }

        val about = findViewById<View>(R.id.about)
        about.setOnClickListener {
            val g = Intent(this, tabout::class.java)
            startActivity(g)
            checkForUpdates()
        }

        val don = findViewById<View>(R.id.about3)
        don.setOnClickListener {
            val g = Intent(this, donate::class.java)
            startActivity(g)
            checkForUpdates()
        }

        val faq = findViewById<View>(R.id.about4)
        faq.setOnClickListener {
            val g = Intent(this, faqmathth10::class.java)
            startActivity(g)
            checkForUpdates()
        }



        val calendar = findViewById<View>(R.id.button18)
        calendar.setOnClickListener {
            val g = Intent(this,workcalendar::class.java)
            startActivity(g)
            checkForUpdates()
        }

        val eldzennik = findViewById<View>(R.id.button22)
        eldzennik.setOnClickListener {
            if (!isInternetAvailable()) {
                val g = Intent(this, InternetError::class.java)
                startActivity(g)
            } else {
                val g = Intent(this, ElectricalDnevnik::class.java)
                startActivity(g)
                checkForUpdates()
            }
        }

        val gpt = findViewById<View>(R.id.button20)
        gpt.setOnClickListener {


            if (!isInternetAvailable()) {
                val g = Intent(this, InternetError::class.java)
                startActivity(g)
            } else {
               val g = Intent(this, AI::class.java)
                startActivity(g)
                checkForUpdates()
            }
        }

        val settings = findViewById<View>(R.id.button19)
        settings.setOnClickListener {

            val g = Intent(this, setting::class.java)
            startActivity(g)
        }
    }

    private fun isInternetAvailable(): Boolean {
        val connectivityManager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }




    fun checkForUpdates() {

        val client = OkHttpClient()

        val url = "https://raw.githubusercontent.com/The-F-Project/EduCA/refs/heads/dev-branch/versionapp.json"








        val request = Request.Builder()

            .url(url)

            .build()


        client.newCall(request).enqueue(object : okhttp3.Callback {

            override fun onFailure(call: okhttp3.Call, e: IOException) {

                runOnUiThread {



                }

            }


            override fun onResponse(call: okhttp3.Call, response: Response) {

                if (response.isSuccessful) {

                    response.body?.string()?.let { jsonString ->

                        val jsonObject = JSONObject(jsonString)

                        val latestVersion = jsonObject.getString("version")

                        val downloadUrl = jsonObject.getString("url")


                        val currentVersion = BuildConfig.VERSION_NAME

                        if (latestVersion > currentVersion) {

                            runOnUiThread {

                                val s = Intent(applicationContext, Unsupportver::class.java)

                                startActivity(s)

                            }


                        }

                    }

                } else {

                    runOnUiThread {


                    }

                }

            }

        })

    }

    fun getTimeOfDay(): String {

        val calendar = Calendar.getInstance()

        val hour = calendar.get(Calendar.HOUR_OF_DAY)


        return when {

            hour in 5..11 -> "Доброе утро!"

            hour in 12..16 -> "Добрый день!"

            hour in 17..23 -> "Добрый вечер!"
            else -> "Доброй ночи!"

        }


    }
    }

