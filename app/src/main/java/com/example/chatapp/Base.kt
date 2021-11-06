package com.example.chatapp

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

    protected lateinit var binding: T



    override fun onDestroy() {
        if (::binding.isInitialized) {
            binding.unbind()
        }
        super.onDestroy()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
       binding= DataBindingUtil.inflate(
                inflater,layoutResId, container, false)
        return binding.root
    }
}