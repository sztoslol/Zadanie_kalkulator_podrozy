package com.example.jakieszadanko

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Przypisanie funkcjonalnych elementow UI do zmiennych
        var button_odjazd = findViewById<Button>(R.id.button_data_wyjazdu)
        var button_powrot = findViewById<Button>(R.id.button_data_powrotu)
        var kalendar_view = findViewById<CalendarView>(R.id.calendarView_main)
        var text_wynik = findViewById<TextView>(R.id.textView_wynik)
    }
}