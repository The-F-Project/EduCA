package org.thefproject.fedu

import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONObject
import java.io.File
import java.io.IOException

import java.time.LocalDateTime




class setting : AppCompatActivity() {
    private lateinit var cacheSizeTextView: TextView
    private lateinit var branchSwitch: Switch
    private var downloadId: Long = 0



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContentView(R.layout.activity_setting)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->

            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())

            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)

            insets

        }
        val osVersion = android.os.Build.VERSION.SDK_INT
        println("Версия Android: $osVersion")
        val osVersionName = android.os.Build.VERSION.RELEASE
        println("Сборка: $osVersionName")

        val checkUpdatesButton = findViewById<View>(R.id.upd)
        checkUpdatesButton.setOnClickListener {

            val g = Intent(this, updater::class.java)
            startActivity(g)

        }

        val currentDateTime = LocalDateTime.now()
        println("Текущая дата и время: $currentDateTime")



        val sdkVersion = android.os.Build.VERSION.SDK_INT
        val Pacname = "PAC-NAME $packageName"
        val versionName = BuildConfig.VERSION_NAME
        val versionCode = BuildConfig.VERSION_CODE
        val sdkVersionText = "Версия SDK: $sdkVersion"
        cacheSizeTextView = findViewById(R.id.cacheSizeTextView)


        val clearCacheButton: Button = findViewById(R.id.clearCacheButton)
val report = findViewById<View>(R.id.reportt)



        report.setOnClickListener {
            val g = Intent(this, skproject::class.java)
            startActivity(g)

        }

        clearCacheButton.setOnClickListener {

            clearCache()

        }


        createTempFile()

        updateCacheSize()

    }


    private fun clearCache() {

        try {

            val cacheDir = cacheDir

            if (cacheDir.isDirectory) {

                deleteDir(cacheDir)

            }

            Toast.makeText(this, "Кэш очищен", Toast.LENGTH_SHORT).show()

            updateCacheSize()

        } catch (e: Exception) {

            Toast.makeText(this, "Ошибка: ${e.message}", Toast.LENGTH_SHORT).show()

        }

    }


    private fun updateCacheSize() {

        cacheSizeTextView.text = "Используемая память: ${getCacheSize()} МБ"

    }


    private fun getCacheSize(): Long {

        return getDirSize(cacheDir) / (1024 * 1024)

    }


    private fun getDirSize(dir: File): Long {

        var size: Long = 0

        if (dir.isDirectory) {

            val files = dir.listFiles()

            if (files != null) {

                for (file in files) {

                    size += if (file.isDirectory) {

                        getDirSize(file) // Рекурсивно добавляем размер подкаталогов

                    } else {

                        file.length() // Добавляем размер файла

                    }

                }

            }

        }

        return size

    }


    private fun deleteDir(dir: File): Boolean {

        if (dir.isDirectory) {

            val children = dir.list()

            if (children != null) {

                for (child in children) {

                    deleteDir(File(dir, child))

                }

            }

        }

        return dir.delete()

    }


    private fun createTempFile() {

        val tempFile = File(cacheDir, "tempFile.txt")

        tempFile.writeText("This is a temporary file.")

    }


}


