package com.example.chatapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapp.databinding.ChatListBinding
import com.example.chatapp.models.Message
import com.example.chatapp.utils.OnclickListener

class ChatAdapter(val action: () -> Unit) : RecyclerView.Adapter<ChatAdapter.ViewHolder>() {


     override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
         val v = LayoutInflater.from(parent.context).inflate(R.layout.chat_list, parent,false)
         return ViewHolder(v)
     }

     override fun onBindViewHolder(holder: ViewHolder, position: Int) {
         holder.bind()
     }

     override fun getItemCount(): Int {
         return 3
     }

     inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
         fun bind() {
             view.setOnClickListener {
                 action()
                 Toast.makeText(itemView.context,"Called",Toast.LENGTH_SHORT).show()
             }
         }
     }
 }


