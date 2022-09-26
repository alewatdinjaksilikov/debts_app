package com.example.myapplication.addactivity

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.MainActivity
import kotlinx.android.synthetic.main.activity_add.*
import kotlinx.android.synthetic.main.item_design.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import uz.data.debts_apk.data.MyDatabase
import uz.data.debts_apk.model.User
import java.util.*

class AddActivity() : AppCompatActivity() {

   // private lateinit var appdb: MyDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        btn_save.setOnClickListener {
           // writeData()
            addUsers()
        }

        calendar.setOnClickListener {
            GetData(given_date)
        }
        calendar1.setOnClickListener {
            GetData(get_day)
        }

    }

    private fun addUsers() {
        val name = from_to.text.toString()
        val summa1 = summa.text.toString()
        val givendate = given_date.text.toString()
        val getday = get_day.text.toString()

        if (name.isNotEmpty()&&summa1.isNotEmpty()&&givendate.isNotEmpty()&&getday.isNotEmpty()){
            lifecycleScope.launch {
                val user = User(0,name,Integer.parseInt(summa1),givendate,getday)
                MyDatabase(this@AddActivity).getDao().addUser(user)
                finish()
            }
            from_to.text.clear()
            summa.text.clear()
            given_date.text.clear()
            get_day.text.clear()
            Toast.makeText(this,"Successfully...", Toast.LENGTH_LONG).show()
        }
        else{
            Toast.makeText(this,"Failed,please write data!", Toast.LENGTH_LONG).show()
        }



    }

    fun GetData(string: EditText){
        var y:Int
        var m:Int
        var d:Int

        val c= Calendar.getInstance()
        d=c.get(Calendar.DATE)
        m=c.get(Calendar.MONDAY)
        y=c.get(Calendar.YEAR)

        val datePicker = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener{
                    view,year,month,dayOfMonth ->
                string.setText(dayOfMonth.toString()+"-"+month.toString()+"-"+year.toString())
            },y,m,d)
        datePicker.show()
    }

   /* fun writeData(){
        val name = from_to.text.toString()
        val summa1 = summa.text.toString()
        val givendate = given_date.text.toString()
        val getday = get_day.text.toString()


        if (name.isNotEmpty()&&summa1.isNotEmpty()&&givendate.isNotEmpty()&&getday.isNotEmpty()){
            val user = User(
                0,name, Integer.parseInt(summa1),givendate,getday
            )
            GlobalScope.launch(Dispatchers.IO) {
                appdb.getDao().addUser(user)
            }

            from_to.text.clear()
            summa.text.clear()
            given_date.text.clear()
            get_day.text.clear()

            Toast.makeText(mainActivity,"Successfully...", Toast.LENGTH_LONG).show()
        }
        else{
            Toast.makeText(mainActivity,"Failed,please write data!", Toast.LENGTH_LONG).show()
        }
    } */
}