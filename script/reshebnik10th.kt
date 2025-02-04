package org.thefproject.fedu

import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class reshebnik10th : AppCompatActivity() {


    fun isInternetAvailable(): Boolean {
        val connectivityManager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
        val networkInfo = connectivityManager.activeNetworkInfo
        return networkInfo != null && networkInfo.isConnected
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_reshebnik10th)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }



        val rus = findViewById<View>(R.id.button21)


        rus.setOnClickListener {


            val d = Intent(this,reshebnik10russian::class.java)
            startActivity(d)

        }

        val geo = findViewById<View>(R.id.button23)
        geo.setOnClickListener {

            val d = Intent(this,reshebnik10thgeography::class.java)
            startActivity(d)

        }



        val history = findViewById<View>(R.id.buttonh)



        history.setOnClickListener {


            val g = Intent(this, reshebnik10thhistory::class.java)
            startActivity(g)



        }




        val al = findViewById<View>(R.id.button2)




        al.setOnClickListener {

            val intent = Intent(this, webreshebnik10::class.java)
            startActivity(intent)



        }

        val predmets = findViewById<View>(R.id.prdmet)
        predmets.setOnClickListener {
            val g = Intent(this, bookslist::class.java)
            startActivity(g)
        }
        val reshebnik10 = findViewById<View>(R.id.reshebnik)

        reshebnik10.setOnClickListener {
            val g = Intent(this, reshebniklist::class.java)
            startActivity(g)
        }


        val geometria = findViewById<View>(R.id.button8)
        val english = findViewById<View>(R.id.button9)
        val physic = findViewById<View>(R.id.button10)
        val hemia = findViewById<View>(R.id.button12)

        val main = findViewById<View>(R.id.profile)
        main.setOnClickListener {
            val g = Intent(this, home::class.java)
            startActivity(g)

            fun isInternetAvailable(): Boolean {
                val connectivityManager = getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager
                val networkInfo = connectivityManager.activeNetworkInfo
                return networkInfo != null && networkInfo.isConnected
            }



        }
        geometria.setOnClickListener {

            if (!isInternetAvailable()) {
                val g = Intent(this, InternetError::class.java)
                startActivity(g)
            } else {
                val g = Intent(this, rshebnik10thgeometria::class.java)
                startActivity(g)
            }

        }
        english.setOnClickListener {

            if (!isInternetAvailable()) {
                val g = Intent(this, InternetError::class.java)
                startActivity(g)
            } else {
                val g = Intent(this, reshebnik10english::class.java)
                startActivity(g)
            }


        }

        physic.setOnClickListener {

            val g = Intent(this, reshebnik10thphysic::class.java)
            startActivity(g)
            if (!isInternetAvailable()) {
                val g = Intent(this, InternetError::class.java)
                startActivity(g)
            } else {
                val aa = Intent(this, webreshebnik10::class.java)
                startActivity(aa)
            }

        }

        hemia.setOnClickListener {


            if (!isInternetAvailable()) {
                val g = Intent(this, InternetError::class.java)
                startActivity(g)
            } else {
                val g = Intent(this, reshebnik10himia::class.java)
                startActivity(g)

            }








                }
            }

        }



