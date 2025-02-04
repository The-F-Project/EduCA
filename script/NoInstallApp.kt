package org.thefproject.fedu


import android.app.DownloadManager

import android.content.BroadcastReceiver

import android.content.Context

import android.content.Intent

import android.content.IntentFilter

import android.net.Uri

import android.os.Bundle

import android.util.Log

import android.view.View

import android.widget.ProgressBar

import android.widget.Switch

import android.widget.TextView

import android.widget.Toast

import androidx.activity.enableEdgeToEdge

import androidx.appcompat.app.AlertDialog

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

import org.json.JSONObject

import java.io.IOException

import java.time.LocalDateTime


class NoInstallApp : AppCompatActivity() {

    private lateinit var branchSwitch: Switch

    private var downloadId: Long = 0

    private val client = OkHttpClient()

    private val gson = Gson()
    data class UpdateInfo(

        val message: String,

        val version: String

    )

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContentView(R.layout.activity_schoolprojectstartpage)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->

            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)

            insets

        }


        val url = "https://raw.githubusercontent.com/The-F-Project/EduCA/refs/heads/dev-branch/json/taco-info"


        // Загружаем информацию об обновлениях

        CoroutineScope(Dispatchers.IO).launch {

            val jsonString = fetchJson(url)

            handleJsonResponse(jsonString)

        }


        // Инициализация кнопки для проверки обновлений

        val st1 = findViewById<View>(R.id.st1)

        st1.setOnClickListener {

            checkForUpdates()

        }


        // Вывод текущей даты и времени

        val currentDateTime = LocalDateTime.now()

        Log.d("NoInstallApp", "Текущая дата и время: $currentDateTime")


        // Инициализация переключателя ветки

        branchSwitch = findViewById(R.id.branchSwitch)

    }


    private suspend fun handleJsonResponse(jsonString: String?) {

        if (jsonString != null) {

            try {

                val updateInfo = gson.fromJson(jsonString, UpdateInfo::class.java)

                checkAppVersion(updateInfo.version) // Проверка версии приложения

                withContext(Dispatchers.Main) {

                    val textView: TextView = findViewById(R.id.textView32)

                    textView.text = updateInfo.message


                    val textView2: TextView = findViewById(R.id.textView34)

                    textView2.text = updateInfo.version

                }

            } catch (e: Exception) {

                Log.e("ReleaseAvailable", "Ошибка парсинга JSON: ${e.message}")

                showError("Ошибка парсинга данных")

            }

        } else {

            Log.e("ReleaseAvailable", "Ошибка загрузки данных: jsonString равен null")

            showError("Ошибка загрузки данных")

        }

    }

    private fun showError(message: String) {

        runOnUiThread {

            val textView: TextView = findViewById(R.id.textView32)

            textView.text = message

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


    private fun checkAppVersion(latestVersion: String) {

        val currentVersion = BuildConfig.VERSION_NAME // Получаем текущую версию приложения


        if (currentVersion != latestVersion) {

            // Если версии не совпадают, показываем диалог

            runOnUiThread {

                showUpdateDialog(currentVersion, latestVersion)

            }

        }

    }


    private fun showUpdateDialog(currentVersion: String, latestVersion: String) {

        AlertDialog.Builder(this)

            .setTitle("Обновление доступно")

            .setMessage("Ваша версия: $currentVersion\nДоступная версия: $latestVersion\nПожалуйста, обновите приложение.")

            .setPositiveButton("ОК") { dialog, _ -> dialog.dismiss() }

            .setNegativeButton("Отмена") { dialog, _ -> dialog.dismiss() }

            .show()

    }


    fun checkForUpdates() {

        val url = if (branchSwitch.isChecked) {

            "https://raw.githubusercontent.com/The-F-Project/EduCA/refs/heads/dev-branch/frameinstall.json"

        } else {

            "https://raw.githubusercontent.com/The-F-Project/EduCA/refs/heads/dev-branch/frameinstall.json"

        }


        val request = Request.Builder().url(url).build()

        client.newCall(request).enqueue(object : okhttp3.Callback {

            override fun onFailure(call: okhttp3.Call, e: IOException) {

                runOnUiThread {

                    Toast.makeText(this@NoInstallApp, "Невозможно подключиться к серверу", Toast.LENGTH_SHORT).show()

                }

            }


            override fun onResponse(call: okhttp3.Call, response: Response) {

                if (response.isSuccessful) {

                    response.body?.string()?.let { jsonString ->

                        val jsonObject = JSONObject(jsonString)

                        val downloadUrl = jsonObject.getString("url")


                        runOnUiThread {

                            Toast.makeText(this@NoInstallApp, "Начинается загрузка", Toast.LENGTH_SHORT).show()

                            downloadAPK(downloadUrl)

                        }

                    }

                } else {

                    runOnUiThread {

                        Toast.makeText(this@NoInstallApp, "Ошибка: ${response.message}", Toast.LENGTH_SHORT).show()

                    }

                }

            }

        })

    }


    fun downloadAPK(url: String) {

        val request = DownloadManager.Request(Uri.parse(url))

        request.setTitle("Загрузка Taco(для EduCA)")

        request.setDescription("Процесс загрузки")

        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)

        request.setDestinationInExternalFilesDir(this, null, "EduCA.apk")


        val downloadManager = getSystemService(DOWNLOAD_SERVICE) as DownloadManager

        downloadId = downloadManager.enqueue(request)

    }


    private val downloadReceiver = object : BroadcastReceiver() {

        override fun onReceive(context: Context?, intent: Intent?) {

            val id = intent?.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID, -1)

            if (id == downloadId) {

                Toast.makeText(this@NoInstallApp, "Загрузка завершена", Toast.LENGTH_SHORT).show()

                installAPK()

            }

        }

    }


    fun installAPK() {

        val apkFile = Uri.fromFile(getExternalFilesDir(null)?.resolve("EduCA.apk"))

        val intent = Intent(Intent.ACTION_VIEW)

        intent.setDataAndType(apkFile, "application/vnd.android.package-archive")

        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK

        startActivity(intent)

    }


    override fun onResume() {

        super.onResume()

        registerReceiver(downloadReceiver, IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE))

    }


    override fun onPause() {

        super.onPause()

        unregisterReceiver(downloadReceiver)

    }

}