package com.example.chatapp

import android.os.Bundle
import android.view.*
import com.example.chatapp.databinding.FragmentChatpageBinding


class ChatPage : BindingFragment<FragmentChatpageBinding>() {
    private val mainPagerAdapter: FragmentAdapter by lazy {
        FragmentAdapter(requireActivity().supportFragmentManager)
    }
    private lateinit var settings: MenuItem

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding.adapter =mainPagerAdapter
        binding.tabs.setupWithViewPager(binding.viewpager)
        return binding.root
    }

    override val layoutResId: Int
        get() = R.layout.fragment_chatpage
    override val color: Int
        get() = R.color.white

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
       inflater.inflate(R.menu.top_menu,menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.action_settings ->{
                
            }
        }
        return super.onOptionsItemSelected(item)
    }


}