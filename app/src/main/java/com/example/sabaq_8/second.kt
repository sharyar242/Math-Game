package com.example.sabaq_8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_second.*
import kotlin.random.Random.Default.Companion

class second : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var rightAnswerCount =intent.getIntExtra(MainActivity.RIGHT_ANSWERS_COUNT,0)
        tvresultR.text = "$rightAnswerCount/${MainActivity.LEVEL_COUNT}"


        restart.setOnClickListener {
            val intent = Intent (this,MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }
        gotomain.setOnClickListener {
            val intent = Intent(this,MainActivity2::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }
    }
}