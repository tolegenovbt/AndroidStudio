package com.example.myactivity

import android.content.Intent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var user1: User = User("putin001","123456", "Vladimir")
        var user2: User = User("barack001", "USAonCharge", "Obama")
        var user3: User = User("nurik001", "darigaonelove", "Nursultan")
        val users: Array<User> = arrayOf(user1, user2, user3)

        loginInputText.text
        passwordInputText.text
        startNewActivityBtn.setOnClickListener {
            if (loginInputText.text!!.isNotEmpty() && passwordInputText.text!!.isNotEmpty()) {
                var n: Int = 0
                for(it in users)
                {
                    n++
                    if(it.login == loginInputText.text.toString() && it.password == passwordInputText.text.toString())
                    {
                         var intent = Intent(this, TestActivity::class.java)
                        .putExtra("userName", it.name)
                        startActivity(intent)
                        break
                    }
                }
                if(n==users.size)
                    Toast.makeText(this, "Неверный логин или пароль", Toast.LENGTH_LONG).show()

            } else {
                Toast.makeText(this, "Сначала заполните поля", Toast.LENGTH_LONG).show()
            }
        }
    }
}
