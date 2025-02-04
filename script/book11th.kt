package org.thefproject.fedu

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class book11th : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_book11th)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val d1 = findViewById<View>(R.id.buttond1)
        val reshebnik10 = findViewById<View>(R.id.reshebnik)
        val geometria = findViewById<View>(R.id.buttongeometria)
        val physic = findViewById<View>(R.id.buttonphysic)  //
        val back = findViewById<View>(R.id.back)
        val biology = findViewById<View>(R.id.buttonphysic)
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



            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aversev.by/media/download/files/uchebniki.by/himia_11kl_michko_rus_2021.pdf")); startActivity(browserIntent);


        }
        english.setOnClickListener {

            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aversev.by/media/download/files/uchebniki.by/angliski_yazik_11kl_yuhnel_rus_2021.pdf")); startActivity(browserIntent);


        }

        inform.setOnClickListener {

            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aversev.by/media/download/files/uchebniki.by/informatika_11kl_kotov_rus_2021.pdf")); startActivity(browserIntent);

        }

        bellit.setOnClickListener {

            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aversev.by/media/download/files/nio/bel_lit_11kl_melnikava_bel_rus_2021.pdf")); startActivity(browserIntent);



        }

        ruslit.setOnClickListener {


            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aversev.by/media/download/files/uchebniki.by/rus_lit_11kl_senkevich_rus_bel_2021.pdf")); startActivity(browserIntent);



        }
        history.setOnClickListener {


            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aversev.by/media/download/files/uchebniki.by/vsem_ist_XIX_nXXI_11kl_koshelev_rus_2021.pdf")); startActivity(browserIntent);



        }
        geography.setOnClickListener {

            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aversev.by/media/download/files/uchebniki.by/geografija_vitchenko_11kl_rus_2021.pdf")); startActivity(browserIntent);


        }
        d1.setOnClickListener {

            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aversev.by/media/download/files/uchebniki.by/algebra_11kl_arefieva_rus_2020.pdf")); startActivity(browserIntent);
        }
        geometria.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aversev.by/media/download/files/uchebniki.by/geometriya_11kl_latotin_rus_2020.pdf")); startActivity(browserIntent);

        }
        physic.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aversev.by/media/download/files/uchebniki.by/fizika_11kl_zhilko_rus_2021.pdf")); startActivity(browserIntent);

        }
        biology.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aversev.by/media/download/files/uchebniki.by/biologiya_11k_dashkov_rus_2021.pdf")); startActivity(browserIntent);

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

            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aversev.by/media/download/files/uchebniki.by/dopriz_podgotovka_dragunov_10_11_rus_2019.pdf")); startActivity(browserIntent);

        }

        bel.setOnClickListener{

            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aversev.by/media/download/files/uchebniki.by/bel_mova_11kl_valochka_rus_bel_2021.pdf")); startActivity(browserIntent);

        }

        rus.setOnClickListener {


            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aversev.by/media/download/files/uchebniki.by/rus_yaz_11kl_dolbik_bel_rus_2021.pdf")); startActivity(browserIntent);

        }
    }
}