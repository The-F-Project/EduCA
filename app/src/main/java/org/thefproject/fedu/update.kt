package org.thefproject.fedu

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Response
import retrofit2.http.GET

data class UpdateInfo(
    val version: String,
    val apk_url: String
)

// Объявите интерфейс UpdateApi на верхнем уровне файла
interface UpdateApi {
    @GET("yourusername/yourrepo/latest_version.json")
    fun getLatestVersion(): Call<UpdateInfo>
}

// Объявите класс Updater после интерфейса
class Updater(private val context: Context) {

    fun checkForUpdates(currentVersion: String) {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://raw.githubusercontent.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val updateApi = retrofit.create(UpdateApi::class.java)

        updateApi.getLatestVersion().enqueue(object : Callback<UpdateInfo> {
            override fun onResponse(call: Call<UpdateInfo>, response: Response<UpdateInfo>) {
                if (response.isSuccessful && response.body() != null) {
                    val updateInfo = response.body()!!
                    if (updateInfo.version != currentVersion) {
                        // Обнаружено обновление

                    }
                }
            }

            override fun onFailure(call: Call<UpdateInfo>, t: Throwable) {
                // Обработка ошибок
            }
        })
    }



    private fun downloadApk(apkUrl: String) {
        val request = DownloadManager.Request(Uri.parse(apkUrl))
        request.setTitle("Downloading Update")
        request.setDescription("Please wait...")
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, "yourapp.apk")

        val downloadManager = context.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        downloadManager.enqueue(request)
    }

    private fun installApk() {

    }
}