package com.devventure.rolldices

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.widget.TextViewCompat
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dice1 = findViewById<TextView>(R.id.textViewDice1)
        val dice2 = findViewById<TextView>(R.id.textViewDice2)

        val rollButton = findViewById<Button>(R.id.button)

        rollButton.setOnClickListener {
            dice1.text = roll().toString()
            dice2.text = roll().toString()
        }
    }

    private fun roll(): Int{
        return (1..6).random()
    }
}