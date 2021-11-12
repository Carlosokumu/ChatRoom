package com.example.chatapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapp.databinding.ChatIntoNotificationBinding
import com.example.chatapp.databinding.RowChatPartnerBinding
import com.example.chatapp.databinding.RowChatUserBinding
import com.example.chatapp.models.Message
import timber.log.Timber

class MessagesAdapter: RecyclerView.Adapter<MessagesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        val binding: ViewDataBinding
        when(viewType){

            0 ->{
                binding = DataBindingUtil.inflate(inflater,R.layout.row_chat_user,parent,false) as RowChatUserBinding
                Timber.d("$viewType")
            }

            1 ->
            {
                binding = DataBindingUtil.inflate(inflater,R.layout.row_chat_partner,parent,false) as RowChatPartnerBinding

                Timber.d("$viewType")
            }
            2 -> {
                binding = DataBindingUtil.inflate(inflater,R.layout.chat_into_notification,parent,false) as ChatIntoNotificationBinding
                Timber.d("$viewType")
            }
            else -> {
                throw IllegalStateException("Unimplemented list item type $viewType.")
            }

        }
        return ViewHolder(binding.root)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {


    }

    override fun getItemViewType(position: Int): Int {
        val list= listOf<Int>(0,1,2)
        return list[position]
    }

    override fun getItemCount(): Int {
        return 3
    }

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: Message) {

        }
    }
}