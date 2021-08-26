package com.example.chatapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity

class EntryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button.setOnClickListener {
            enterChatroom()
        }
    }
    private fun enterChatroom(){
        val userName = userName.text.toString()
        val roomName = roomname.text.toString()

        if(!roomName.isNullOrBlank()&&!userName.isNullOrBlank()) {
            startActivity<ActivityChatRoom>(
                "userName" to userName,
                "roomName" to roomName
            )
        }
        else{
            Toast.makeText(this,"Nickname and Roomname should be filled!", Toast.LENGTH_SHORT)
        }
    }
}