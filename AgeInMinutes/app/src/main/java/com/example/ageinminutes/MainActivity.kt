package com.example.ageinminutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.text.SimpleDateFormat
import java.util.*

const val MILLIS_PER_DAY = 86400000

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        datePickerBtn.setOnClickListener { view ->
            clickDatePicker(view)
        }
    }


    private fun clickDatePicker(view: View) {

        val myCal = Calendar.getInstance()
        val year = myCal.get(Calendar.YEAR)
        val month = myCal.get(Calendar.MONTH)
        val day = myCal.get(Calendar.DAY_OF_MONTH)

        val dpd = DatePickerDialog(this@MainActivity,
            DatePickerDialog.OnDateSetListener { view, setYear, setMonth, setDay ->

                val selectedDate = "$setDay/${setMonth + 1}/$setYear"
                tvSelectedDate.text = selectedDate

                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

                val theDate = sdf.parse(selectedDate)
                val dateInMin = theDate!!.time / 60000
                val currDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                val ageInMin = (currDate!!.time / 60000) - dateInMin

                tvAgeInMin.text = ageInMin.toString()
            },
            year,
            month,
            day)

        dpd.datePicker.maxDate = Date().time - MILLIS_PER_DAY
        dpd.show()
    }


}