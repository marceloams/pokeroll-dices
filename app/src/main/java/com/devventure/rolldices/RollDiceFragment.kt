package com.devventure.rolldices

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import com.devventure.rolldices.databinding.FragmentRollDiceBinding

class RollDiceFragment : Fragment() {

    private var binding: FragmentRollDiceBinding? = null

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRollDiceBinding.inflate(inflater, container, false)

        val playerName: String = this.arguments?.get("playerName").toString()

//        val playerName: String = Intent().getStringExtra("playerName").toString()

        val dice1 = binding?.dice1
        val dice2 = binding?.dice2
        val rollButton = binding?.rollButton
        val shareButton = binding?.shareButton
        val welcomeMessage = binding?.welcomeMessage

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

        welcomeMessage?.text = getString(R.string.welcome_message, playerName)

        rollButton?.setOnClickListener {
            dice1?.setImageResource(dicesImages.random())
            dice2?.setImageResource(dicesImages.random())
        }

        shareButton?.setOnClickListener {
            val shareResultIntent = Intent(Intent.ACTION_SEND)
            shareResultIntent.putExtra(Intent.EXTRA_TEXT, shareMessage)
            shareResultIntent.setPackage("com.whatsapp")
            shareResultIntent.type = "text/plain"

            activity?.packageManager?.run {
                if(shareResultIntent.resolveActivity(this) != null)
                    startActivity(shareResultIntent)
                else
                    Toast.makeText(context, shareErrorMessage, Toast.LENGTH_LONG).show()
            }

        }

        return binding?.root;
    }
}