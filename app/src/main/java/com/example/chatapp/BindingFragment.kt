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


abstract class BindingFragment<T : ViewDataBinding> : Fragment() {

    abstract val layoutResId: Int

     lateinit var binding: T


    override fun onAttach(context: Context) {
        super.onAttach(context)
        binding= DataBindingUtil.inflate(LayoutInflater.from(context),layoutResId,null,false)
    }
}