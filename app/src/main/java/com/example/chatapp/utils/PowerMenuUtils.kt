package com.example.chatapp.utils

import android.R
import android.content.Context
import android.graphics.Color
import android.view.Gravity
import androidx.core.content.ContextCompat
import androidx.lifecycle.LifecycleOwner
import com.skydoves.powermenu.MenuAnimation
import com.skydoves.powermenu.OnMenuItemClickListener
import com.skydoves.powermenu.PowerMenu
import com.skydoves.powermenu.PowerMenuItem


object PowerMenuUtils {
    fun getProfilePowerMenu(
            context: Context,
            lifecycleOwner: LifecycleOwner,
            onMenuItemClickListener: OnMenuItemClickListener<PowerMenuItem>): PowerMenu? {
        return PowerMenu.Builder(context)
                .addItem(PowerMenuItem("New Group", false))
                .addItem(PowerMenuItem("Settings", false))
                .addItem(PowerMenuItem("Logout", false))
                .addItem(PowerMenuItem("Cancel", false))
                .setLifecycleOwner(lifecycleOwner)
                .setAnimation(MenuAnimation.SHOWUP_TOP_RIGHT)
                .setMenuRadius(20f)
                .setMenuShadow(10f)
                .setHeight(700)
                .setWidth(400)
                .setAutoDismiss(true)
                .setTextColor(ContextCompat.getColor(context, R.color.black))
                .setTextGravity(Gravity.CENTER)
                .setMenuColor(Color.WHITE)
                .setSelectedEffect(false)
                .setShowBackground(true)
                .setFocusable(true)
                .setOnMenuItemClickListener(onMenuItemClickListener)
                .build()
    }
}