package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.inputmethod.InputBinding
import androidx.lifecycle.lifecycleScope
import com.example.myapplication.addactivity.AddActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.launch
import uz.data.debts_apk.data.MyDatabase

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        floataction_button.setOnClickListener {
            var intent = Intent(this,AddActivity::class.java)
            startActivity(intent)
        }
        
    }

    override fun onResume() {
        super.onResume()
        lifecycleScope.launch {
            val userList = MyDatabase(this@MainActivity).getDao().getAllUsers()
            Log.d("error","onResume : ${userList.size}")
        }

    }

}