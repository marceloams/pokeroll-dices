package com.devventure.rolldices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playerName: String = intent.getStringExtra("playerName").toString()

        val dice1 = findViewById<ImageView>(R.id.dice1)
        val dice2 = findViewById<ImageView>(R.id.dice2)
        val rollButton = findViewById<Button>(R.id.rollButton)
        val shareButton = findViewById<FloatingActionButton>(R.id.shareButton)
        val welcomeMessage = findViewById<TextView>(R.id.welcomeMessage)

        val shareMessage = getString(R.string.share_message)
        val shareErrorMessage = getString(R.string.share_button_error_message)

        val dicesImages: List<Int> = listOf(
            R.drawable.dice_1,
            R.drawable.dice_2,
            R.drawable.dice_3,
            R.drawable.dice_4,
            R.drawable.dice_5,
            R.drawable.dice_6
        )

        welcomeMessage.text = getString(R.string.welcome_message, playerName)

        rollButton.setOnClickListener {
            dice1.setImageResource(dicesImages.random())
            dice2.setImageResource(dicesImages.random())
        }

        shareButton.setOnClickListener {
            val shareResultIntent = Intent(Intent.ACTION_SEND)
            shareResultIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
            shareResultIntent.setPackage("com.whatsapp")
            shareResultIntent.type = "text/plain"

            if(shareResultIntent.resolveActivity(packageManager) != null)
                startActivity(shareResultIntent)
            else
                Toast.makeText(this, shareErrorMessage, Toast.LENGTH_LONG).show()

        }

        Log.i("LIFE CYCLE", "ON CREATE")
    }

    override fun onStart() {
        super.onStart()
        Log.i("LIFE CYCLE", "ON CREATE")
    }

    override fun onResume() {
        super.onResume()
        Log.i("LIFE CYCLE", "ON CREATE")
    }

    override fun onPause() {
        super.onPause()
            Log.i("LIFE CYCLE", "ON PAUSE")
    }

    override fun onStop() {
        super.onStop()
        Log.i("LIFE CYCLE", "ON STOP")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("LIFE CYCLE", "ON DESTROY")
    }
}