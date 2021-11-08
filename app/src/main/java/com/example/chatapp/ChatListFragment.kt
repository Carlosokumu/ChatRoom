package com.example.chatapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
        binding.adapter= ChatAdapter()
        return binding.root
    }
}