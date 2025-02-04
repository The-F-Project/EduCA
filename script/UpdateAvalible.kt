package org.thefproject.fedu


import android.os.Bundle

import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity

import com.google.gson.Gson

import okhttp3.OkHttpClient

import okhttp3.Request

import okhttp3.Response

import kotlinx.coroutines.CoroutineScope

import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.launch

import kotlinx.coroutines.withContext


data class Message(val message: String)
data class Version(val version: String)


class UpdateAvalible : AppCompatActivity() {


    private val client = OkHttpClient()

    private val gson = Gson()


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_update_avalible)


        // URL вашего JSON-файла на GitHub

        val url = "https://raw.githubusercontent.com/username/repository/branch/path/to/yourfile.json"


        // Запуск корутины для загрузки данных

        CoroutineScope(Dispatchers.IO).launch {

            val jsonString = fetchJson(url)

            val messageObject = gson.fromJson(jsonString, Message::class.java)




            withContext(Dispatchers.Main) {

                val textView: TextView = findViewById(R.id.textView32)

                textView.text = messageObject.message

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
