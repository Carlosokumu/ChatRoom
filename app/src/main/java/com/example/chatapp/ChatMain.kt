package com.example.chatapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.chatapp.databinding.FragmentChatMainBinding


class ChatMain : BindingFragment<FragmentChatMainBinding>() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        binding.adapter=MessagesAdapter()
        return binding.root
    }

    override val layoutResId: Int
        get() = R.layout.fragment_chat_main
    override val color: Int
        get() = R.color.anotherWhats


}