package com.example.chatapp.utils

import androidx.databinding.BindingAdapter
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

@BindingAdapter("fragmentAdapter")
fun bindViewPager(view: ViewPager, adapter: FragmentPagerAdapter) {
    view.adapter = adapter
}
@BindingAdapter("viewPager")
fun bindTab(view: TabLayout,pager: ViewPager) {
    view.setupWithViewPager(pager)
}