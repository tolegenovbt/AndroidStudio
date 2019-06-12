package com.example.myactivity

import android.graphics.Color.GREEN
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_test.*

class TestActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        var userName = intent.getStringExtra("userName") as String
        Log.d("USER_DATA", userName)
        userNameText.text = userName
        button.setOnClickListener {
            button.setBackgroundColor(GREEN)
        }
    }
}
