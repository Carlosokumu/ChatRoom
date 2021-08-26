package com.example.chatapp

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chatapp.models.Message
import com.example.chatapp.models.MessageType
import com.example.chatapp.models.SendMessage
import com.example.chatapp.models.initialData
import com.google.gson.Gson
import io.socket.client.IO
import io.socket.client.Socket
import io.socket.emitter.Emitter
import kotlinx.android.synthetic.main.activity_chat_room.*
import java.net.URISyntaxException

class ActivityChatRoom : AppCompatActivity() {
    lateinit var mSocket: Socket
    lateinit var userName: String
    lateinit var roomName: String
    val TAG = ActivityChatRoom::class.java.simpleName
    val gson: Gson = Gson()
    //For setting the recyclerView.
    val chatList: ArrayList<Message> = arrayListOf()
    lateinit var chatRoomAdapter: ChatRoomAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat_room)
       //Get the nickname and roomname from entrance activity.
        try {
            userName = intent.getStringExtra("userName")!!
            roomName = intent.getStringExtra("roomName")!!
        } catch (e: Exception) {
            e.printStackTrace()
        }
        try {
            mSocket = IO.socket("http://192.168.43.209:3000")
            Toast.makeText(this,"we got here",Toast.LENGTH_SHORT).show()
            Log.d("success","connected")

        } catch (e: URISyntaxException) {
            e.printStackTrace()
            Log.d("fail", "Failed to connect")
            Log.d("could not connect",e.message!!)
            Toast.makeText(this,"we got here again",Toast.LENGTH_SHORT).show()
        }
        mSocket.connect()
        mSocket.on(Socket.EVENT_CONNECT, onConnect)
        mSocket.on("newUserToChatRoom", onNewUser)
        mSocket.on("updateChat", onUpdateChat)
        mSocket.on("userLeftChatRoom", onUserLeft)
        chatRoomAdapter = ChatRoomAdapter(this, chatList)
        recyclerView.adapter = chatRoomAdapter
        recyclerView.layoutManager=LinearLayoutManager(this)
        send.setOnClickListener {
            sendMessage()
        }
    }
    var onUserLeft = Emitter.Listener {
        val leftUserName = it[0] as String
        val chat= Message(leftUserName, "", "", MessageType.USER_LEAVE.index)
        addItemToRecyclerView(chat)
    }
    var onUpdateChat = Emitter.Listener {
        val chat: Message = gson.fromJson(it[0].toString(), Message::class.java)
        chat.viewType = MessageType.CHAT_PARTNER.index
        addItemToRecyclerView(chat)
    }
    var onConnect = Emitter.Listener {
        val data = initialData(userName, roomName)
        val jsonData = gson.toJson(data)
        mSocket.emit("subscribe", jsonData)

    }
    var onNewUser = Emitter.Listener {
        val name = it[0] as String //This pass the userName!
        val chat = Message(name, "", roomName, MessageType.USER_JOIN.index)
        addItemToRecyclerView(chat)
        Log.d(TAG, "on New User triggered.")
    }



        private fun sendMessage() {
            val content = editText.text.toString()
            val sendData = SendMessage(userName, content, roomName)
            val jsonData = gson.toJson(sendData)
            mSocket.emit("newMessage", jsonData)

            val message = Message(userName, content, roomName, MessageType.CHAT_MINE.index)
            addItemToRecyclerView(message)
        }

        private fun addItemToRecyclerView(message: Message) {

            //Since this function is inside of the listener,
            // You need to do it on UIThread!
            runOnUiThread {
                chatList.add(message)
                chatRoomAdapter.notifyItemInserted(chatList.size)
                editText.setText("")
                recyclerView.scrollToPosition(chatList.size - 1) //move focus on last message
            }
        }


        override fun onDestroy() {
            super.onDestroy()
            val data = initialData(userName, roomName)
            val jsonData = gson.toJson(data)
            mSocket.emit("unsubscribe", jsonData)
            mSocket.disconnect()
        }

    }



