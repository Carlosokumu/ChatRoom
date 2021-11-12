package com.example.chatapp

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.chatapp.databinding.FragmentChatpageBinding
import com.example.chatapp.utils.PowerMenuUtils
import com.skydoves.powermenu.MenuAnimation
import com.skydoves.powermenu.OnMenuItemClickListener
import com.skydoves.powermenu.PowerMenu
import com.skydoves.powermenu.PowerMenuItem


class ChatPage : BindingFragment<FragmentChatpageBinding>(),
    OnMenuItemClickListener<PowerMenuItem>, MenuItem.OnMenuItemClickListener {
    private val mainPagerAdapter: FragmentAdapter by lazy {
        FragmentAdapter(requireActivity().supportFragmentManager)
    }
    private lateinit var settings: MenuItem
    private var profileMenu: PowerMenu? = null
    private val onProfileItemClickListener = OnMenuItemClickListener<PowerMenuItem> { position, item ->
        Toast.makeText(activity, item.title, Toast.LENGTH_SHORT).show()
        profileMenu!!.dismiss()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding.adapter =mainPagerAdapter
        binding.tabs.setupWithViewPager(binding.viewpager)
         binding.toolbar.inflateMenu(R.menu.top_menu)
        settings= binding.toolbar.menu.findItem(R.id.action_settings)
        profileMenu =PowerMenuUtils.getProfilePowerMenu(requireContext(), requireActivity(), onProfileItemClickListener)
        settings.setOnMenuItemClickListener(this)
        return binding.root
    }

    override val layoutResId: Int
        get() = R.layout.fragment_chatpage
    override val color: Int
        get() = R.color.light_chat


                /*

                override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
                    super.onCreateOptionsMenu(menu, inflater)
                   inflater.inflate(R.menu.top_menu,menu)
                }

                override fun onOptionsItemSelected(item: MenuItem): Boolean {
                    val list= mutableListOf(
                        PowerMenuItem("New Group", false), PowerMenuItem("Settings", false)
                    )
                    when(item.itemId){
                        R.id.action_settings -> {
                            val popMenu = PowerMenu.Builder(requireContext())
                                .addItemList(list)
                                .setAnimation(MenuAnimation.SHOWUP_TOP_LEFT)
                                .setMenuRadius(10f)
                                .setMenuShadow(10f)
                                .setTextColor(ContextCompat.getColor(requireContext(), R.color.beige))
                                .setTextGravity(Gravity.CENTER)
                                .setTextTypeface(Typeface.create("sans-serif-medium", Typeface.BOLD))
                                .setSelectedTextColor(Color.WHITE)
                                .setMenuColor(Color.WHITE)
                                .setSelectedMenuColor(
                                    ContextCompat.getColor(
                                        requireContext(),
                                        R.color.colorPrimary
                                    )
                                )
                                .setOnMenuItemClickListener(this)
                                .build()
                            popMenu.showAsDropDown(requireView())
                        }
                    }
                    return super.onOptionsItemSelected(item)
                }

                 */

    override fun onItemClick(position: Int, item: PowerMenuItem?) {

    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        val list= mutableListOf(
                PowerMenuItem("New Group", false), PowerMenuItem("Settings", false)
        )
        when(item?.itemId) {
            R.id.action_settings -> {
                profileMenu?.showAsDropDown(requireView())
                Toast.makeText(requireContext(), "Yeah", Toast.LENGTH_SHORT).show()
            }
        }
        return true
    }


}