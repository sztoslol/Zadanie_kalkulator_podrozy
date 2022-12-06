package com.example.jakieszadanko

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Przypisanie funkcjonalnych elementow UI do zmiennych
        var button_odjazd = findViewById<Button>(R.id.button_odjazd)
        var button_powrot = findViewById<Button>(R.id.button_powrot)
        var kalendarz = findViewById<CalendarView>(R.id.calendarView_main)
        var text_wynik = findViewById<TextView>(R.id.textView_wynik)

        kalendarz.minDate = System.currentTimeMillis() // ustalenie minimalnej daty
        kalendarz.maxDate = System.currentTimeMillis() + (kalendarz.maxDate - System.currentTimeMillis())// ustalanie maxymalnej daty

        // Inicjajcja zmiennych przechowujących date odjazdu i przyjazdu
        var data_odjazdu = 0L
        var data_przyjazdu = 0L

        // pobieranie od uzytkowanika zaznaczonych pol odjazu i przyjzadu
        button_odjazd.setOnClickListener {
            data_odjazdu = kalendarz.date
        }

        button_powrot.setOnClickListener {
            data_przyjazdu = kalendarz.date

            if (data_odjazdu != null)
                text_wynik.text = (CalcDays(data_przyjazdu) - CalcDays(data_odjazdu)).toString()
        }
    }
}

fun CalcDays(time : Long):Int
{
    return  (time/86400000).toInt();
}