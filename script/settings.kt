package org.thefproject.fedu

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Context
import android.widget.Button
import android.widget.TextView
import java.io.File

class settings : AppCompatActivity() {
    private lateinit var clearCacheButton: Button

    private lateinit var cacheSizeText: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_settings)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        clearCacheButton = findViewById(R.id.clear_cache_button)

        cacheSizeText = findViewById(R.id.cache_size_text)


        // Выводим размер кэша при запуске

        updateCacheSize()


        clearCacheButton.setOnClickListener {

            clearCache()

            updateCacheSize()

        }

    }


    private fun clearCache() {

        val cacheDir = cacheDir

        if (cacheDir.isDirectory) {

            deleteDir(cacheDir)

        }

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


    private fun updateCacheSize() {

        val cacheDir = cacheDir

        val size = getDirSize(cacheDir)

        cacheSizeText.text = "Размер кэша: $size байт"

    }


    private fun getDirSize(dir: File): Long {

        var size: Long = 0

        if (dir.isDirectory) {

            val children = dir.listFiles()

            if (children != null) {

                for (child in children) {

                    size += getDirSize(child)

                }

            }

        } else {

            size += dir.length()

        }

        return size

    }
}