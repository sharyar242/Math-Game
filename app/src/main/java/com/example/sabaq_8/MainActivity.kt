package com.example.sabaq_8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Math.random
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    companion object{
        const val LEVEL_COUNT =0
        const val RIGHT_ANSWERS_COUNT = "rightAnswerCount"
    }

    private val random= Random
    private var res = 0
    private var currentLevelCount =1
    private var right = 0
    private var wrong = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getRightAnswer()
    }


    fun variantClick(button: View){
         val selectedVariant = (button as Button ).text.toString().toInt()
        if (selectedVariant==res)
            right++
        else wrong++
        if (currentLevelCount== LEVEL_COUNT){
            val intent = Intent(this,second::class.java)
            intent.putExtra(RIGHT_ANSWERS_COUNT,right)
             startActivity(intent)
            finish()
        }else{
            getRightAnswer()
        }
    }


    private fun getRightAnswer() {
        var firstNumber= random.nextInt(10 , 100)
        val secondNumber=random.nextInt(10,100)
        var temp = random.nextInt(0,4)
        when(temp){
            0 ->{
                tvoperator.text="$firstNumber+$secondNumber"
                res = firstNumber+secondNumber
            }
            1 ->{
                tvoperator.text="$firstNumber-$secondNumber"
                res = firstNumber-secondNumber
            }
            2 ->{
                tvoperator.text="$firstNumber*$secondNumber"
                res = firstNumber*secondNumber
            }
            3 ->{
                res = random.nextInt(0,10)
                firstNumber=res * secondNumber
                tvoperator.text= "$firstNumber/$secondNumber"
                res = firstNumber/secondNumber
            }
        }
        val correctAnswersPosition = random.nextInt(0,4)
        generateWrongAnswer(btn1)
        generateWrongAnswer(btn2)
        generateWrongAnswer(btn3)
        generateWrongAnswer(btn4)
        when(correctAnswersPosition){
            0-> btn1.text=res.toString()
            1-> btn2.text=res.toString()
            2-> btn3.text=res.toString()
            3-> btn4.text=res.toString()
        }
    }

    private fun generateWrongAnswer(button: Button){
        when(random.nextBoolean()){
            true->
                button.text = (res+ random.nextInt(0,10)+1).toString()
            false-> button.text = (res - random.nextInt(0, 10) + 1).toString()
        }
    }




}