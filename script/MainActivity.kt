package org.thefproject.fedu

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.airbnb.lottie.LottieDrawable
import androidx.appcompat.app.AlertDialog
import android.content.DialogInterface
import com.google.android.material.snackbar.Snackbar
import org.thefproject.fedu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        lateinit var binding: ActivityMainBinding
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets

        }

        val loginin = findViewById<View>(R.id.loginin)

        loginin.setOnClickListener {
            val g = Intent(this, home::class.java)
            startActivity(g)
            animateButton(loginin)

        }

        val textView: TextView = findViewById(R.id.textView10)

        val sdkVersion = android.os.Build.VERSION.SDK_INT
        val Pacname = "PAC-NAME $packageName"
        val versionName = BuildConfig.VERSION_NAME
        val versionCode = BuildConfig.VERSION_CODE
        val sdkVersionText = "Версия SDK: $sdkVersion"

        textView.text =
            " $packageName Версия: $versionName  Номер сборки: $versionCode "



        val sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE)

        val isFirstRun = sharedPreferences.getBoolean("isFirstRun", true)


        if (isFirstRun) {



            showWelcomeSnackbar()




            with(sharedPreferences.edit()) {

                putBoolean("isFirstRun", false)

                apply()

            }

        }

    }


    private fun showWelcomeSnackbar() {

        val rootView = findViewById<View>(android.R.id.content)






        val builder = AlertDialog.Builder(this)




        builder.setTitle("Спасибо за выбор EduCA!")

            .setMessage("Спасибо за выбор EduCA! Вы используете версию от 4.02.2025 года")



            .setPositiveButton("Хорошо") { dialog, which ->



                dialog.dismiss()

            }





        val dialog: AlertDialog = builder.create()

        dialog.show()

    }



}

private fun animateButton(view: View) {



    val scaleAnimation = ScaleAnimation(

        1f, 0.9f,

        1f, 0.9f,

        Animation.RELATIVE_TO_SELF, 0.5f,

        Animation.RELATIVE_TO_SELF, 0.5f

    )


    scaleAnimation.duration = 200

    scaleAnimation.repeatCount = 1

    scaleAnimation.repeatMode = Animation.REVERSE




    view.startAnimation(scaleAnimation)

}


