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

        val upd = findViewById<View>(R.id.button4)
        fun requestInstallPermission(context: Context) {

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

                if (!context.packageManager.canRequestPackageInstalls()) {

                    val intent = Intent(Settings.ACTION_MANAGE_UNKNOWN_APP_SOURCES)

                    intent.data = Uri.parse("package:${context.packageName}")

                    context.startActivity(intent)

                }

            }

        }
        upd.setOnClickListener {
//https://github.com/FaliedDedd/edu/releases
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/FaliedDedd/edu/releases")); startActivity(browserIntent);

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


        val contacts = findViewById<View>(R.id.button7)

        contacts.setOnClickListener {
            val g = Intent(this, contact::class.java)
            startActivity(g)
        }

        fun installUpdate(context: Context, file: File) {

            val intent = Intent(Intent.ACTION_VIEW)

            intent.setDataAndType(FileProvider.getUriForFile(context, "${context.packageName}.provider", file), "application/vnd.android.package-archive")

            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)

            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)

            context.startActivity(intent)

        }

        fun downloadUpdate(url: String, destination: File, onComplete: (Boolean) -> Unit) {

            val client = OkHttpClient()

            val request = Request.Builder().url(url).build()


            client.newCall(request).enqueue(object : okhttp3.Callback {

                override fun onFailure(call: okhttp3.Call, e: IOException) {

                    onComplete(false)

                }


                override fun onResponse(call: okhttp3.Call, response: Response) {

                    response.use {

                        if (!response.isSuccessful) {

                            onComplete(false)

                            return

                        }


                        response.body?.let { body ->

                            val inputStream: InputStream = body.byteStream()

                            val outputStream = FileOutputStream(destination)


                            try {

                                inputStream.copyTo(outputStream)

                                onComplete(true)

                            } catch (e: IOException) {

                                onComplete(false)

                            } finally {

                                outputStream.close()

                                inputStream.close()

                            }

                        } ?: onComplete(false)

                    }

                }

            })

        }




         fun showWelcomeSnackbar() {

            val rootView = findViewById<View>(android.R.id.content)

            Snackbar.make(rootView, "Рекомендуем проверить обновление", Snackbar.LENGTH_LONG)

                .setAction("ОК") {  }

                .show()

        }

    }


}