package com.example.chatapp

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


class FragmentAdapter(fragmentManager: FragmentManager):
        FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
    private val fragmentss = listOf(ChatListFragment(),StatusFragment())
    private val titles = listOf("Chats", "Status")
    override fun getCount(): Int = fragmentss.size

    override fun getItem(position: Int): Fragment = fragmentss[position] as Fragment
    override fun getPageTitle(position: Int): CharSequence? = titles[position]
}