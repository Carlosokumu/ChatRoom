package com.example.chatapp.Utils

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.widget.ViewAnimator
import com.example.chatapp.R

class CustomView(context: Context, attrs: AttributeSet?=null): ViewAnimator(context,attrs) {
    private val waiting: ViewGroup
    private val   phoneInput: View

    companion object {
        //STATES
        const val  POSITION_PHONE=0
        const val  POSITION_WAITING=1
        //Fade animation time
        private const val FADE_DURATION_MS = 200L
    }
    init {
        //get An instance of the inflater to inflate the views
        val inflater= LayoutInflater.from(context)
        //Order matters as we will be displaying children views from top
        waiting= inflater.inflate(R.layout.loading_view,this,true) as ViewGroup
        val customResId: Int
        context.theme.obtainStyledAttributes(R.styleable.SwitcherView).apply {
            try {
                customResId=getResourceId(R.styleable.SwitcherView_contentView,R.layout.phone_input)
            }
            finally {
                recycle()
            }
        }
        phoneInput=inflater.inflate(customResId,this,true)
        //Apply animation during the switch of the views
        inAnimation = AlphaAnimation(0.0f, 1.0f).apply { duration = FADE_DURATION_MS }
        outAnimation = AlphaAnimation(1.0f, 0.0f).apply { duration = FADE_DURATION_MS }
    }

    private fun showWaiting() {
        if (displayedChild != POSITION_WAITING) {
            displayedChild = POSITION_WAITING
        }
    }

}