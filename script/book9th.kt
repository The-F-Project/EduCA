package org.thefproject.fedu

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class book9th : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_book9th)
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
        val biology = findViewById<View>(R.id.buttonBiology)
        val cherch = findViewById<View>(R.id.buttoncherch2)
        val bel = findViewById<View>(R.id.buttonbellanguage)
        val rus = findViewById<View>(R.id.buttonrussianlanguage)
        val geography = findViewById<View>(R.id.buttongeography)
        val history = findViewById<View>(R.id.buttonhistory)
        val ruslit = findViewById<View>(R.id.buttonrussianlit)
        val bellit = findViewById<View>(R.id.buttonbellit)
        val inform = findViewById<View>(R.id.buttoninform)
        val english = findViewById<View>(R.id.buttonenglish)
        val himia = findViewById<View>(R.id.buttonhimia)



        himia.setOnClickListener {



            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aversev.by/media/download/files/uchebniki.by/Himiya_Shimanovich_9kl_bel_2019.pdf")); startActivity(browserIntent);


        }
        english.setOnClickListener {

            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aversev.by/media/download/files/v_shkola/angliski_demchenko_9kl_ch1_bel_rus_2022.pdf")); startActivity(browserIntent);


        }

        inform.setOnClickListener {

            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aversev.by/media/download/files/uchebniki.by/informatika_9kl_Kotov_rus_2019.pdf")); startActivity(browserIntent);

        }

        bellit.setOnClickListener {

            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aversev.by/media/download/files/nio/bel_lit_9kl_proskolovich_2019.pdf")); startActivity(browserIntent);



        }

        ruslit.setOnClickListener {


            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aversev.by/media/download/files/nio/rus_lit_Zaharova_9kl_rus_bel_2019.pdf")); startActivity(browserIntent);



        }
        history.setOnClickListener {


            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aversev.by/media/download/files/uchebniki.by/Ist_Bel_1917_nXXI_9kl_Panov_rus_2019.pdf")); startActivity(browserIntent);



        }
        geography.setOnClickListener {

            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aversev.by/media/download/files/uchebniki.by/Geografiya_9kl_Brilevski_rus_2019.pdf")); startActivity(browserIntent);


        }
        d1.setOnClickListener {

            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aversev.by/media/download/files/uchebniki.by/Algebra_Arefieva_9kl_rus_2019.pdf")); startActivity(browserIntent);
        }
        geometria.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aversev.by/media/download/files/uchebniki.by/Geometriya_Kazakov_9kl_rus_2019.pdf")); startActivity(browserIntent);

        }
        physic.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aversev.by/media/download/files/uchebniki.by/Fizika_Isachenkova_9_rus_2019.pdf")); startActivity(browserIntent);

        }
        biology.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aversev.by/media/download/files/uchebniki.by/Biologiya_Borisov_9kl_rus_2019.pdf")); startActivity(browserIntent);

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

            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aversev.by/media/download/files/uchebniki.by/Iskusstvo_9kl_Kolbisheva_rus_2019.pdf")); startActivity(browserIntent);

        }

        bel.setOnClickListener{

            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aversev.by/media/download/files/nio/bel-mova-valochka-9kl-bel-rus-2019.pdf")); startActivity(browserIntent);

        }

        rus.setOnClickListener {


            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aversev.by/media/download/files/nio/rus_yazyk_9kl_murina_2019.pdf")); startActivity(browserIntent);

        }
    }
}