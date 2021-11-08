package com.example.chatapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapp.databinding.ChatListBinding
import com.example.chatapp.models.Message

 class ChatAdapter : RecyclerView.Adapter<ChatAdapter.ViewHolder>() {


     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
         val v = LayoutInflater.from(parent.context).inflate(R.layout.chat_list, parent)
         return ViewHolder(v)
     }

     override fun onBindViewHolder(holder: ViewHolder, position: Int) {


     }

     override fun getItemCount(): Int {
         return 3
     }

     inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
         fun bind(item: Message) {

         }
     }
 }


