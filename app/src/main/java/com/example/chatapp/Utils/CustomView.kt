package com.example.chatapp.Utils

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AlphaAnimation
import android.widget.*
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.example.chatapp.R
import timber.log.Timber

class CustomView(context: Context, attrs: AttributeSet?=null): ViewAnimator(context,attrs),
    View.OnClickListener {
    private val waiting: ViewGroup
    private val   phoneInput: View
    private lateinit var btnOtp: TextView
    private lateinit var    mobileNumber: EditText

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
        phoneInput= inflater.inflate(R.layout.phone_input,this,true) as ViewGroup
        btnOtp=phoneInput.findViewById(R.id.btnOtp)
        mobileNumber=phoneInput.findViewById(R.id.mobile_number)
        btnOtp.setOnClickListener(this)
        waiting= inflater.inflate(R.layout.waiting_view,this,true) as ViewGroup
        //Apply animation during the switch of the views
        inAnimation = AlphaAnimation(0.0f, 1.0f).apply { duration = FADE_DURATION_MS }
        outAnimation = AlphaAnimation(1.0f, 0.0f).apply { duration = FADE_DURATION_MS }
    }

    private fun showWaiting() {
        if (displayedChild != POSITION_WAITING) {
            displayedChild = POSITION_WAITING
        }
    }

    override fun onClick(button: View) {
        if (mobileNumber.text.isBlank() || (mobileNumber.text.length != 9)){
            YoYo.with(Techniques.Shake)
                .duration(700)
                .repeat(5)
                .playOn(mobileNumber)
            return
        }
        showWaiting()
        val phoneNumber=mobileNumber.text.trim().toString()

    }
   fun setUpData(phoneNumber: String,data: (String) -> Unit){
       data(phoneNumber)
   }

}