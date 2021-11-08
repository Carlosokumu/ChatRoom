package com.example.chatapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.chatapp.databinding.FragmentStatusBinding

class StatusFragment: BindingFragment<FragmentStatusBinding>() {
    override val layoutResId: Int
        get() = R.layout.fragment_status
    override val color: Int
        get() =R.color.white


}
