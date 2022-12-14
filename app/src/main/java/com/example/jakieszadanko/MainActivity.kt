package com.example.jakieszadanko

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.TextView
import androidx.annotation.RequiresApi
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.ZoneId
import java.util.Date
import kotlin.math.absoluteValue

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
        var label_odjazd = findViewById<TextView>(R.id.textView_zaznaczona_data_odjazd)
        var label_powrot = findViewById<TextView>(R.id.textView_zaznaczona_data_przyjazd)

        kalendarz.minDate = System.currentTimeMillis() // ustalenie minimalnej daty
        kalendarz.maxDate = LocalDate.now().plusYears(2).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli()// ustalanie maxymalnej daty

        // Inicjajcja zmiennych przechowujących date odjazdu i przyjazdu
        var data_odjazdu = mutableListOf<Int>(0,0,0)
        var data_powrot = mutableListOf<Int>(0,0,0)
        var temp_date = mutableListOf<Int>(MilliToDate(kalendarz.date)[0],MilliToDate(kalendarz.date)[1],MilliToDate(kalendarz.date)[2])

        // Pobieranie daty za każdą zmianą
        kalendarz.setOnDateChangeListener { _, i, i2, i3 ->
            temp_date[0] = i
            temp_date[1] = i2+1
            temp_date[2] = i3
        }

        // Pobieranie od użytkownika zaznaczonych pól odjazu i przyjzadu
        button_odjazd.setOnClickListener {
            data_odjazdu[0] = temp_date[0]
            data_odjazdu[1] = temp_date[1]
            data_odjazdu[2] = temp_date[2]
            label_odjazd.text = data_odjazdu[0].toString()+"-"+data_odjazdu[1].toString()+"-"+data_odjazdu[2].toString()

            if (data_odjazdu[0] != 0 && data_powrot[0] != 0)
                if((data_odjazdu[2] > data_powrot[2]  && data_odjazdu[1] == data_powrot[1]) || (data_odjazdu[1] < data_powrot[1]))
                    text_wynik.text = "Nie możesz wyjechać później niż wrócisz!"
                else
                    text_wynik.text = "Twoja podroż potrwa "+ CalcDays(data_odjazdu, data_powrot).absoluteValue.toString() + " dni"
        }

        button_powrot.setOnClickListener {
            data_powrot[0] = temp_date[0]
            data_powrot[1] = temp_date[1]
            data_powrot[2] = temp_date[2]
            label_powrot.text = data_powrot[0].toString()+"-"+data_powrot[1].toString()+"-"+data_powrot[2].toString()

            // Jeśli obie daty nie są puste program wyświetli czas podróży w dniach
            if (data_odjazdu[0] != 0 && data_powrot[0] != 0)
                if((data_odjazdu[2] > data_powrot[2]  && data_odjazdu[1] == data_powrot[1]) || (data_odjazdu[1] < data_powrot[1]))
                    text_wynik.text = "Nie możesz wyjechać później niż wrócisz!"
                else
                    text_wynik.text = "Twoja podroż potrwa "+ CalcDays(data_odjazdu, data_powrot).absoluteValue.toString() + " dni"
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onResume() {
        super.onResume()
        findViewById<CalendarView>(R.id.calendarView_main).minDate = System.currentTimeMillis()
        findViewById<CalendarView>(R.id.calendarView_main).maxDate = LocalDate.now().plusYears(2).atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli()
    }
}

// Funkcja obliczająca różnice między datami
fun CalcDays(Date1 : List<Int>, Date2 : List<Int>):Int
{
    var temp1 = (Date1[0] * 360) + (Date1[1] * 30) + Date1[2]
    var temp2 = (Date2[0] * 360) + (Date2[1] * 30) + Date2[2]
    return temp1 - temp2
}

// Funkcja konwertuje milisekundy do daty
fun MilliToDate(milli : Long) : List<Int>
{
    val date = Date(milli)
    val formatter = SimpleDateFormat("yyyy/MM/dd")
    val formattedDate = formatter.format(date)
    val ans = formattedDate.split("/").map { it.toInt() }
    return ans;
}