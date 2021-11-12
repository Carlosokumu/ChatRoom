package com.example.chatapp

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils.replace
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.chatapp.databinding.FragmentChatlistBinding

class ChatListFragment:BindingFragment<FragmentChatlistBinding>(){


    override val layoutResId: Int
        get() = R.layout.fragment_chatlist
    override val color: Int
        get() = R.color.white

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding.adapter= ChatAdapter(action = {
            val intent=Intent(requireContext(),ActivityChatRoom::class.java)
            intent.putExtra("userName","carlos")
            intent.putExtra("roomName","carlos")
           startActivity(intent)
        })
        return binding.root
    }
}