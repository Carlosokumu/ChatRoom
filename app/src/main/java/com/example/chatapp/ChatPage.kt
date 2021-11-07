package com.example.chatapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.chatapp.databinding.FragmentChatpageBinding


class ChatPage : BindingFragment<FragmentChatpageBinding>() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding.toolbar.inflateMenu(R.menu.top_menu)
        return binding.root
    }

    override val layoutResId: Int
        get() = R.layout.fragment_chatpage
    override val color: Int
        get() = R.color.white


}