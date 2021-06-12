package com.devventure.rolldices

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.devventure.rolldices.databinding.FragmentRegisterUserBinding

class RegisterUserFragment : Fragment() {
    private var binding: FragmentRegisterUserBinding? = null

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterUserBinding.inflate(inflater, container, false)

        val editTextRegisterUser = binding?.editTextRegisterUser
        val registerUserButton = binding?.buttonRegisterUser

        val editTextValidatorMessage = getString(R.string.name_text_edit_validator_message)

        registerUserButton?.setOnClickListener {
            val playerName: String = editTextRegisterUser?.text.toString()

            if(playerName.isNotEmpty()) {
                findNavController().navigate(R.id.action_registerUserFragment_to_rollDiceFragment, bundleOf("playerName" to playerName))
            }else{
                Toast.makeText(context, editTextValidatorMessage, Toast.LENGTH_SHORT).show()
            }
        }

        return binding?.root
    }



}