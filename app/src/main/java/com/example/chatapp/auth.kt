package com.example.chatapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.Toast
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.hbb20.CountryCodePicker
import kotlinx.android.synthetic.main.activity_chat_room.*
import timber.log.Timber

class auth : Fragment(), CountryCodePicker.OnCountryChangeListener {
    private lateinit var ccp: CountryCodePicker
    private lateinit var mobileNumber: EditText
    private lateinit var fullNumber: String
    private lateinit var countrycode: String
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v=inflater.inflate(R.layout.fragment_auth,container,false)
        ccp=v.findViewById(R.id.ccp)
        mobileNumber=v.findViewById(R.id.mobile_number)
        ccp.setOnCountryChangeListener(this)
        return v
    }

    override fun onCountrySelected() {
        countrycode=ccp.selectedCountryCodeWithPlus
    }
    private fun setUpWaiting() {
        if (mobileNumber.text.isBlank() || (mobileNumber.text.length != 9)){
            YoYo.with(Techniques.Tada)
                .duration(700)
                .repeat(5)
                .playOn(mobileNumber)
            Toast.makeText(requireContext(),"Please enter a valid number",Toast.LENGTH_SHORT).show()
        }
        val phoneNumber=mobileNumber.text.trim().toString()
        fullNumber=phoneNumber.replace(" ","")
        fullNumber =countrycode+ fullNumber
        Timber.d(countrycode)
        Timber.d(fullNumber)
    }
}