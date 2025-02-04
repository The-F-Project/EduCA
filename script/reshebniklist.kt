package org.thefproject.fedu

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class reshebniklist : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_reshebniklist)


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        initButtons()
    }

    private fun initButtons() {
        val openAppButton = findViewById<Button>(R.id.button3)
        openAppButton.setOnClickListener {
            listInstalledApps()
            openOtherApp("org.thefproject.taco")
        }

        val class9 = findViewById<View>(R.id.button2)
        val class8 = findViewById<View>(R.id.button)

        class8.setOnClickListener {
            Toast.makeText(this, "Временно не доступно", Toast.LENGTH_SHORT).show()
        }

        class9.setOnClickListener {
            Toast.makeText(this, "Временно не доступно", Toast.LENGTH_SHORT).show()
        }

        val predmets = findViewById<View>(R.id.prdmet)
        predmets.setOnClickListener {
            val intent = Intent(this, bookslist::class.java)
            startActivity(intent)
        }

        val reshebnik10 = findViewById<View>(R.id.reshebnik)
        reshebnik10.setOnClickListener {
            val intent = Intent(this, reshebniklist::class.java)
            startActivity(intent)
        }

        val profile = findViewById<View>(R.id.profile)
        profile.setOnClickListener {
            val intent = Intent(this, home::class.java)
            startActivity(intent)
        }
    }

    private fun openOtherApp(packageName: String) {
        Log.d("OpenOtherApp", "Trying to open app with package name: $packageName")

        val intent = packageManager.getLaunchIntentForPackage(packageName)

        if (intent != null) {
            startActivity(intent)
            Log.d("OpenOtherApp", "Launching app: $packageName")
        } else {
            Log.d("OpenOtherApp", "App not found, showing error message")
            Toast.makeText(this, "Приложение не установлено", Toast.LENGTH_SHORT).show()

            val i = Intent(this, NoInstallApp::class.java)
            startActivity(i)
        }
    }

    private fun listInstalledApps() {
        val packages = packageManager.getInstalledPackages(0)

        for (packageInfo in packages) {
            Log.d("InstalledApp", "App: ${packageInfo.packageName}")
        }
    }
}