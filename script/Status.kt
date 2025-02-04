package org.thefproject.fedu

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.gson.Gson
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.thefproject.fedu.ReleaseAvable.UpdateInfo

class Status : AppCompatActivity() {

    private val client = OkHttpClient()

    private val gson = Gson()
    data class UpdateInfo(val message: String, val version: String, val Currect: String)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_status)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_release_avable)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets



        }

        val url = "https://raw.githubusercontent.com/The-F-Project/EduCA/refs/heads/dev-branch/status.json"







        CoroutineScope(Dispatchers.IO).launch {

            val jsonString = fetchJson(url)


            if (jsonString != null) {

                try {

                    val updateInfo = gson.fromJson(jsonString, UpdateInfo::class.java)


                    withContext(Dispatchers.Main) {

                        val textView: TextView = findViewById(R.id.textView32)

                        textView.text = updateInfo.message


                        val textView2: TextView = findViewById(R.id.textView34)

                        textView2.text = updateInfo.version

                    }

                } catch (e: Exception) {

                    Log.e("ReleaseAvable", "Ошибка парсинга JSON: ${e.message}")

                    withContext(Dispatchers.Main) {

                        val textView: TextView = findViewById(R.id.textView32)

                        textView.text = "Ошибка парсинга данных"

                    }

                }

            } else {

                Log.e("ReleaseAvable", "Ошибка загрузки данных: jsonString равен null")

                withContext(Dispatchers.Main) {

                    val textView: TextView = findViewById(R.id.textView32)

                    textView.text = "Ошибка загрузки данных"

                }

            }

        }




    }


    private fun fetchJson(url: String): String? {

        val request = Request.Builder().url(url).build()

        return client.newCall(request).execute().use { response: Response ->

            if (response.isSuccessful) {

                response.body?.string()

            } else {

                null

            }

        }


    }
}