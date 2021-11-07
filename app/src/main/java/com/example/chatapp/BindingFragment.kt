package com.example.chatapp

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.seanghay.statusbar.statusBar


abstract class BindingFragment<T : ViewDataBinding> : Fragment() {

    abstract val layoutResId: Int
    abstract val color: Int

     lateinit var binding: T


    override fun onAttach(context: Context) {
        super.onAttach(context)
        binding= DataBindingUtil.inflate(LayoutInflater.from(context),layoutResId,null,false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        statusBar.color(color).light(true)
    }
}