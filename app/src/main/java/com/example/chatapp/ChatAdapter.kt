package com.example.chatapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapp.databinding.ChatListBinding
import com.example.chatapp.models.Message


object MessageDiff : DiffUtil.ItemCallback<Message>() {

    override fun areItemsTheSame(oldItem: Message, newItem: Message) =
            oldItem.messageContent == newItem.messageContent

    override fun areContentsTheSame(oldItem: Message, newItem: Message) =
            oldItem == newItem
}

internal class FollowersAdapter :
        ListAdapter<Message, FollowersAdapter.ViewHolder>(MessageDiff) {

    companion object {
        private const val ITEM_WIDTH_RATIO = 0.75f
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
            ViewHolder(
                    ChatListBinding.inflate(
                            LayoutInflater.from(parent.context),
                            parent,
                            false
                    )
            )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
            holder.bind(getItem(position))

    inner class ViewHolder(val binding: ChatListBinding) :
            RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Message) {

        }
    }
}