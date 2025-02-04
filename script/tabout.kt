package org.thefproject.fedu

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Build.VERSION
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.thefproject.fedu.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import java.io.FileOutputStream
import java.io.IOException
import java.io.InputStream
import android.os.Build
import android.provider.Settings
import android.widget.Toast
import androidx.core.content.FileProvider
import com.google.android.material.snackbar.Snackbar
import java.io.File


class tabout : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_tabout)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        fun requestInstallPermission(context: Context) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

                if (!context.packageManager.canRequestPackageInstalls()) {

                    val intent = Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES)

                    intent.data = Uri.parse("package:${context.packageName}")

                    context.startActivity(intent)

                }

            }

        }

        val back = findViewById<View>(R.id.button5)

        data class UpdateInfo(

            val version: String,

            val url: String

        )
        back.setOnClickListener {
            val g = Intent(this, home::class.java)
            startActivity(g)
        }
        //   val versionName = BuildConfig.VERSION_NAME
        // val versionCode = BuildConfig.VERSION_CODE
        //  println("Версия приложения: $versionName ($versionCode)")

        val textView: TextView = findViewById(R.id.textView8)

        val versionName = BuildConfig.VERSION_NAME
        val versionCode = BuildConfig.VERSION_CODE


        textView.text =
            "Версия $versionName"


        val buttonlic = findViewById<View>(R.id.licence)

        buttonlic.setOnClickListener {
            val g = Intent(this, licence::class.java)
            startActivity(g)

        }

        val contacts = findViewById<View>(R.id.button7)

        contacts.setOnClickListener {
            val g = Intent(this, contact::class.java)
            startActivity(g)
        }

    }

    }







