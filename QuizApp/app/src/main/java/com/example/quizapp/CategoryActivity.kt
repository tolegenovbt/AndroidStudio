package com.example.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.quizapp.models.Category
import com.example.quizapp.models.Question
import kotlinx.android.synthetic.main.activity_category.*
import android.content.Intent

class CategoryActivity : AppCompatActivity() {

    fun listMaker(s1:String, s2:String, s3:String, s4:String ): ArrayList<String>
    {
        var list: ArrayList<String> = ArrayList()
        list.add(s1)
        list.add(s2)
        list.add(s3)
        list.add(s4)
        return list
    }
    fun listMakerQ(q1:Question, q2:Question, q3:Question, q4:Question ): ArrayList<Question>

    {
        var list: ArrayList<Question> = ArrayList()
        list.add(q1)
        list.add(q2)
        list.add(q3)
        list.add(q4)
        return list
    }
    fun questionMaker(body:String, answers:ArrayList<String>, rightAnswersIndex:Int):Question
    {
        var question:Question=Question(body, answers, rightAnswersIndex)
        return question
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)
        var userName = intent.getStringExtra("userName") as String
        Log.d("USER_DATA", userName)
        welcomeText.text = userName.toUpperCase()+", PLEASE CHOOSE A CATEGORY"

        var math: Category= Category(userName,"Math", listMakerQ(
            questionMaker("2+2*2", listMaker("2", "4", "6", "8"), 2),
            questionMaker("3+3*3", listMaker("9", "12", "18", "27"), 1),
            questionMaker("sin60", listMaker("1/2", "sqrt(3)/2", "1/3", "1"), 1),
            questionMaker("3/0", listMaker("0", "3", "1", "ERROR"), 3)
        ))
        var sport: Category=Category(userName,"Sport", listMakerQ(
            questionMaker("Champion of Premier Ligue of Spain is", listMaker("Atletico M", "Real M", "Valencia", "Barcelona"), 3),
            questionMaker("How many players from one team in basketball can be on a court at the same time", listMaker("5","6","4", "7"), 0),
            questionMaker("How many rings on the emblem of the Olympic games", listMaker("3", "4", "5", "6"), 2),
            questionMaker("When Qazaqstan has riched its best result in the Olympic Games", listMaker("2016", "2008", "2002","2012"), 3)
        ))
        var celebreties:Category= Category(userName,"Celebrities", listMakerQ(
            questionMaker("Kim Kardashian's husband is", listMaker("Snoop Dog", "Jay-Z", "Kanye West","Drake"),2),
            questionMaker("The most popular football player on Instagram is", listMaker(" Lionel Messi","Cristiano Ronaldo", "David Beckham", "Neymar JR" ), 3),
            questionMaker("The mad Queen in Game of Thrones is", listMaker("Daenerys Targarien", "Cersei Lannister", "Melisandra", "Sansa Stark"), 0),
            questionMaker("First actor who got role of Spider-man", listMaker("Kit Harington","Tobey Maguire", "Tom Holland", "Andrew Garfield"), 1)
        ))
//        var n:Int=0
        MathCategoryBtn.setOnClickListener {
            var intent2 = Intent(this, GameActivity::class.java)
                .putExtra("category", math)
                .putExtra("correctCount", "0")
                .putExtra("count" , "0")
            startActivity(intent2)
        }
        sportCategoryBtn.setOnClickListener {
            var intent2 = Intent(this, GameActivity::class.java)
                .putExtra("category", sport)
                .putExtra("correctCount", "0")
                .putExtra("count" , "0")
            startActivity(intent2)
        }
        celebritiesCategoryBtn.setOnClickListener {
            var intent2 = Intent(this, GameActivity::class.java)
                .putExtra("category", celebreties)
                .putExtra("correctCount", "0")
                .putExtra("count" , "0")
            startActivity(intent2)
        }
    }
}
