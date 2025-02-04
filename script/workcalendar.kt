package org.thefproject.fedu

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


data class DateEvent(
    val title: String,
    val start_date: String,
    val end_date: String,
    val description: String
)


interface ApiService {
    @GET("The-F-Project/EduCA/dev-branch/calendar.json")
    suspend fun getDateEvents(): List<DateEvent>
}


object RetrofitInstance {
    private const val BASE_URL = "https://raw.githubusercontent.com/"

    val apiService: ApiService by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}


class workcalendar : AppCompatActivity() {
    private lateinit var calendarView: CalendarView
    private val events = mutableListOf<DateEvent>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        fetchEvents()
        setContentView(R.layout.activity_workcalendar)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        calendarView = findViewById(R.id.calendarView)




        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val selectedDate = Calendar.getInstance().apply {
                set(year, month, dayOfMonth)
            }.timeInMillis
            showEventsForDate(selectedDate)
        }
    }

    private fun fetchEvents() {
        lifecycleScope.launch {
            try {
                val dateEvents = RetrofitInstance.apiService.getDateEvents()
                events.clear()
                events.addAll(dateEvents)
                Toast.makeText(this@workcalendar, "Events loaded: ${events.size}", Toast.LENGTH_SHORT).show()
            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(this@workcalendar, "Error fetching data: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showEventsForDate(date: Long) {
        val dateEvents = events.filter { event ->
            val startDate = parseDate(event.start_date)
            val endDate = parseDate(event.end_date)
            date in startDate..endDate
        }
        val textView = findViewById<TextView>(R.id.textView5)
        if (dateEvents.isNotEmpty()) {
            val eventTitles = dateEvents.joinToString(", ") { it.title }

            textView.text = "В эту дату доступны события: $eventTitles"
        } else {
            textView.text = "В эту дату событий нет"
        }
    }

    private fun parseDate(dateString: String): Long {
        val format = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
        return format.parse(dateString)?.time ?: 0L
    }
}