package com.example.chatapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.navigation.Navigation
import com.example.chatapp.databinding.FragmentAuthBinding
import com.hbb20.CountryCodePicker

class Auth : BindingFragment<FragmentAuthBinding>(), OnNumber {
    private lateinit var ccp: CountryCodePicker
    private lateinit var mobileNumber: EditText
    private lateinit var otpBtn: Button
    private lateinit var fullNumber: String
    private lateinit var countrycode: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.lifecycleOwner=requireActivity()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        /*
        val v=inflater.inflate(R.layout.fragment_auth,container,false)
        val customView=v.findViewById<CustomView>(R.id.customView)
        customView.setOnNumber(this)
        val phone=customView.getChildAt(1)
        phone.findViewById<ImageView>(R.id.imageView).setOnClickListener {
            val action=AuthDirections.actionAuthToChatpage()
            val navController = Navigation.findNavController(requireView())
            navController.navigate(action)
        }
        /*
        ccp=phone.findViewById(R.id.ccp)
        mobileNumber=phone.findViewById(R.id.mobile_number)
        otpBtn=phone.findViewById(R.id.btnOtp)
        otpBtn.setOnClickListener(this)
        ccp.setOnCountryChangeListener(this)

         */

         */
        binding.myFlipper.setOnNumber(this)
        binding.myFlipper.getChildAt(1).findViewById<ImageView>(R.id.imageView).setOnClickListener {
            val action=AuthDirections.actionAuthToChatpage()
            val navController = Navigation.findNavController(requireView())
            navController.navigate(action)
        }
        return binding.root

    }




    override fun onNumber(number: String) {
        Toast.makeText(requireContext(),number,Toast.LENGTH_SHORT).show()
    }


    override val layoutResId: Int
        get() = R.layout.fragment_auth
    override val color: Int
        get() = R.color.white


}