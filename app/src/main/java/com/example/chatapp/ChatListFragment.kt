package com.example.chatapp

import com.example.chatapp.databinding.FragmentChatlistBinding

class ChatListFragment:BindingFragment<FragmentChatlistBinding>(){


    override val layoutResId: Int
        get() = R.layout.fragment_chatlist
    override val color: Int
        get() = R.color.white
}