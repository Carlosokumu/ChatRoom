package com.example.chatapp

import android.os.Bundle
import com.example.chatapp.databinding.FragmentChatlistBinding

class ChatListFragment:BindingFragment<FragmentChatlistBinding>(){


    override val layoutResId: Int
        get() = R.layout.fragment_chatlist
    override val color: Int
        get() = R.color.white

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.adapter=ChatAdapter()
    }
}