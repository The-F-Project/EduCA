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
        setContentView(R.layout.activity_books8th)
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



            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aversev.by/media/download/files/epadruchnik/himiya_8kl_shimanovich_rus_2024.pdf")); startActivity(browserIntent);


        }
        english.setOnClickListener {

            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aversev.by/media/download/files/v_shkola/english_el_pril_8_rus.pdf")); startActivity(browserIntent);


        }

        inform.setOnClickListener {

            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aversev.by/media/download/files/uchebniki.by/infarmatika_8kl_kotay_bel_2018.pdf")); startActivity(browserIntent);

        }

        bellit.setOnClickListener {

            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aversev.by/media/download/files/epadruchnik/bel_lit_8kl_lazaruk_2024.pdf")); startActivity(browserIntent);



        }

        ruslit.setOnClickListener {


            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aversev.by/media/download/files/nio/rus_lit_7kl_zaharova_ch1_bel_rus_2023.pdf")); startActivity(browserIntent);



        }
        history.setOnClickListener {


            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aversev.by/media/download/files/uchebniki.by/istoriya_belarusi_kXVIII_nXXv_8kl_panov_rus_2018.pdf")); startActivity(browserIntent);



        }
        geography.setOnClickListener {

            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aversev.by/media/download/files/uchebniki.by/geografiya_7kl_kolmakova_rus_2023.pdf")); startActivity(browserIntent);


        }
        d1.setOnClickListener {

            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aversev.by/media/download/files/epadruchnik/algebra_8kl_arefieva_rus_2024.pdf")); startActivity(browserIntent);
        }
        geometria.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aversev.by/media/download/files/epadruchnik/geometriya_8kl_kazakov_rus_2024.pdf")); startActivity(browserIntent);

        }
        physic.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aversev.by/media/download/files/epadruchnik/fizika_8kl_isachenkova_rus_2024.pdf")); startActivity(browserIntent);

        }
        biology.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aversev.by/media/download/files/uchebniki.by/biologiya_8kl_bedarik_rus_2023.pdf")); startActivity(browserIntent);

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

            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aversev.by/media/download/files/uchebniki.by/iskusstvo_8kl_bohan_rus_2018.pdf")); startActivity(browserIntent);

        }

        bel.setOnClickListener{

            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aversev.by/media/download/files/uchebniki.by/bel_mova_8kl_badzevich_rus_bel_2020.pdf")); startActivity(browserIntent);

        }

        rus.setOnClickListener {


            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aversev.by/media/download/files/epadruchnik/rus_jaz_murina_8kl_2024.pdf")); startActivity(browserIntent);

        }
    }
}