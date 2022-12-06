package com.example.jakieszadanko

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.DateUtils
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.view.get
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.Period
import java.time.format.DateTimeFormatter
import java.util.Date

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Przypisanie funkcjonalnych elementow UI do zmiennych
        var button_odjazd = findViewById<Button>(R.id.button_data_wyjazdu)
        var button_powrot = findViewById<Button>(R.id.button_data_powrotu)
        var kalendarz = findViewById<CalendarView>(R.id.calendarView_main)
        var text_wynik = findViewById<TextView>(R.id.textView_wynik)

        var kalendarz_zaznaczone = kalendarz.date // zaznaczona data
        kalendarz.minDate = System.currentTimeMillis() // ustalenie minimalnej daty
        kalendarz.maxDate = System.currentTimeMillis() + (kalendarz.maxDate - System.currentTimeMillis())// ustalanie maxymalnej daty
    }
}