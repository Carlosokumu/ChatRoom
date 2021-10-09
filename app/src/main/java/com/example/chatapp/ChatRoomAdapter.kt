package com.example.chatapp

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.chatapp.models.OnlineStatus
import timber.log.Timber

class ChatRoomAdapter(val context : Context, val chatList : ArrayList<com.example.chatapp.models.Message>) : RecyclerView.Adapter<ChatRoomAdapter.ViewHolder>(){

    val CHAT_MINE = 0
    val CHAT_PARTNER = 1
    val USER_JOIN = 2
    val USER_LEAVE = 3
    private lateinit var status: OnlineStatus

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        Timber.d(chatList.size.toString())
        Toast.makeText(context,"onCreate called",Toast.LENGTH_SHORT).show()
        var view : View? = null
        when(viewType){

            0 ->{
                view = LayoutInflater.from(context).inflate(R.layout.row_chat_user,parent,false)
                Log.d("user inflating","viewType : ${viewType}")
            }

            1 ->
            {
                view = LayoutInflater.from(context).inflate(R.layout.row_chat_partner,parent,false)

                Log.d("partner inflating","viewType : ${viewType}")
            }
            2 -> {
                view = LayoutInflater.from(context).inflate(R.layout.chat_into_notification,parent,false)
                Log.d("someone in or out","viewType : ${viewType}")
            }
            3 -> {
                view = LayoutInflater.from(context).inflate(R.layout.chat_into_notification,parent,false)
                Log.d("someone in or out","viewType : ${viewType}")
            }
        }

        return ViewHolder(view!!)
    }
    fun setStatus(status: OnlineStatus){
        this.status=status
    }

    override fun getItemCount(): Int {
        return chatList.size
    }

    override fun getItemViewType(position: Int): Int {
        Timber.d("viewtype called")
        Toast.makeText(context,"View type first",Toast.LENGTH_SHORT).show()
        return chatList[position].viewType
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val messageData  = chatList[position]
        val userName = messageData.userName;
        val content = messageData.messageContent;
        val viewType = messageData.viewType;

        when(viewType) {

            CHAT_MINE -> {
                holder.message.text = content
            }
            CHAT_PARTNER ->{
                holder.online.text = status.online
                holder.message.text = content
            }
            USER_JOIN -> {
                val text = "$userName has entered the room"
                holder.text.text = text
            }
            USER_LEAVE -> {
                val text = "${userName} has leaved the room"
                holder.text.text = text
            }
        }

    }
    inner class ViewHolder(itemView : View):  RecyclerView.ViewHolder(itemView) {
        val online = itemView.findViewById<TextView>(R.id.online)
        val message = itemView.findViewById<TextView>(R.id.message)
        val text = itemView.findViewById<TextView>(R.id.text)
    }

}