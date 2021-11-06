package com.example.chatapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.chatapp.databinding.FragmentAuthBinding
import com.example.chatapp.databinding.FragmentChatpageBinding


class ChatPage : BindingFragment<FragmentChatpageBinding>() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        
        return binding.root
    }

    override val layoutResId: Int
        get() = R.layout.fragment_chatpage


}