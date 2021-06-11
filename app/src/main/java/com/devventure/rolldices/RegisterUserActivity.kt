package com.devventure.rolldices

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class RegisterUserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_user)

        val editTextRegisterUser = findViewById<EditText>(R.id.editTextRegisterUser)
        val registerUserButton = findViewById<Button>(R.id.buttonRegisterUser)

        val editTextValidatorMessage = getString(R.string.name_text_edit_validator_message)

        registerUserButton.setOnClickListener {
            val playerName: String = editTextRegisterUser.text.toString()
            
            if(playerName.isNotEmpty()) {
                val mainActivityIntent = Intent(this, MainActivity::class.java)
                mainActivityIntent.putExtra("playerName", playerName)
                startActivity(mainActivityIntent)
            }else{
                Toast.makeText(applicationContext, editTextValidatorMessage, Toast.LENGTH_SHORT).show()
            }

        }

    }
}