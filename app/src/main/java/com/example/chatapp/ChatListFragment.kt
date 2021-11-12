package com.example.chatapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
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
            val action =ChatListFragmentDirections.ActionChatpageToChatmain()
            //val action=ChatListFragmentDirections.ActionChatpageToChatmain()
             val navController = Navigation.findNavController(requireView())
            navController.navigate(action)
        })
        return binding.root
    }
}