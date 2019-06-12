package com.example.calculatorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    enum class Type
    {
        Plus, Minus, Multiply, Divide, None
    }

    var type = Type.None
    var c:Char = ' '
    var s:String = ""
    var t:String = ""
    var n:Int = 0

    fun num() {
        if(s!="0")
        {
            s += n.toString()
            textView.text = s
        }
        else
        {
            s=n.toString()
        }
    }
    fun action()
    {
        if(s.isNotEmpty())
        {
            if(t.isEmpty())
            {
                t=s
                s=""
                textView.text = ""
                textView2.text = t+ " "+c
            }
            else
            {
                if(type==Type.Plus)
                {
                    t=(t.toInt() + s.toInt()).toString()
                    clear()
                    textView2.text=t+" "+c
                }
                else if(type==Type.Minus)
                {
                    t=(t.toInt() - s.toInt()).toString()
                    clear()
                    textView2.text=t+" "+c
                }
                else if(type==Type.Multiply)
                {
                    t=(t.toInt() * s.toInt()).toString()
                    clear()
                    textView2.text=t+" "+c
                }
                else if(type==Type.Divide)
                {
                    t=(t.toInt() / s.toInt()).toString()
                    clear()
                    textView2.text=t+" "+c
                }
                else if(type==Type.None)
                {
                    clear()
                    t=""
                    textView2.text=""
                    n=0
                }
                type=Type.None
            }
        }
    }
    fun clear()
    {
        s=""
        textView.text = ""
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button1.setOnClickListener{
            n=1
            num()
        }
        button2.setOnClickListener{
            n=2
            num()
        }
        button3.setOnClickListener{
            n=3
            num()
        }
        button4.setOnClickListener{
            n=4
            num()
        }
        button5.setOnClickListener{
            n=5
            num()
        }
        button6.setOnClickListener{
            n=6
            num()
        }
        button7.setOnClickListener{
            n=7
            num()
        }
        button8.setOnClickListener{
            n=8
            num()
        }
        button9.setOnClickListener{
            n=9
            num()
        }
        button10.setOnClickListener{
            n=0
            num()
        }
        plusBtn.setOnClickListener{
            type = Type.Plus
            c = '+'
            action()
        }
        minusBtn.setOnClickListener{
            type = Type.Minus
            c = '-'
            action()
        }
        multiplyBtn.setOnClickListener {
            type = Type.Multiply
            c = 'X'
            action()
        }
        divideBtn.setOnClickListener {
            type = Type.Divide
            c = '/'
            action()
        }
        equalsBtn.setOnClickListener {
            c=' '
            action()
        }
        clearBtn.setOnClickListener {
            clear()
            textView2.text=""
            n=0
            t=""
        }
        backBtn.setOnClickListener {
            s=s.dropLast(1)
            textView.text = textView.text.dropLast(1)
        }
    }
}
