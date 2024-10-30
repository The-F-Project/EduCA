package org.thefproject.fedu

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class book8th : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_book8th)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        val d1 = findViewById<View>(R.id.buttond1)
        val reshebnik10 = findViewById<View>(R.id.reshebnik)
        val geometria = findViewById<View>(R.id.buttongeometria)
        val physic = findViewById<View>(R.id.buttonphysic)
        val back = findViewById<View>(R.id.back)
        val biology = findViewById<View>(R.id.buttonphysic)
        val cherch = findViewById<View>(R.id.buttoncherch2)
        val bel = findViewById<View>(R.id.buttonbellanguage)
        val rus = findViewById<View>(R.id.buttonrussianlanguage)

        d1.setOnClickListener {

            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://uchebniki.by/media/download/files/narodnaya_asveta/algebra_10kl_arefieva_bel_2019.pdf")); startActivity(browserIntent);
        }
        geometria.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://uchebniki.by/media/download/files/narodnaya_asveta/biologiya_10kl_maglish_rus_2020.pdf")); startActivity(browserIntent);

        }
        physic.setOnClickListener {
// https://uchebniki.by/media/download/files/adukatsyya_i_vyhavanne/geometriya_10kl_latotin_rus_2020.pdf
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://uchebniki.by/media/download/files/adukatsyya_i_vyhavanne/geometriya_10kl_latotin_rus_2020.pdf")); startActivity(browserIntent);

        }
        biology.setOnClickListener {
//https://uchebniki.by/media/download/files/narodnaya_asveta/biologiya_10kl_maglish_rus_2020.pdf


            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://uchebniki.by/media/download/files/narodnaya_asveta/biologiya_10kl_maglish_rus_2020.pdf")); startActivity(browserIntent);

        }
        reshebnik10.setOnClickListener {
            val g = Intent(this, reshebnik10::class.java)
            startActivity(g)
        }

        back.setOnClickListener {
            val g = Intent(this, bookslist::class.java)
            startActivity(g)
        }
        cherch.setOnClickListener {
            // https://uchebniki.by/media/download/files/narodnaya_asveta/cherchenie_10kl_bezhenar_rus_2020.pdf

            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://uchebniki.by/media/download/files/narodnaya_asveta/cherchenie_10kl_bezhenar_rus_2020.pdf")); startActivity(browserIntent);

        }

        bel.setOnClickListener{
            // https://uchebniki.by/media/download/files/nio/bel_mova_10kl_valochka_rus_bel_2020.pdf

            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://uchebniki.by/media/download/files/nio/bel_mova_10kl_valochka_rus_bel_2020.pdf")); startActivity(browserIntent);

        }

        rus.setOnClickListener {

            // https://uchebniki.by/media/download/files/nio/rus_yaz_10kl_leonovich_rus_bel_2020.pdf

            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://uchebniki.by/media/download/files/nio/rus_yaz_10kl_leonovich_rus_bel_2020.pdf")); startActivity(browserIntent);

        }

    }
}