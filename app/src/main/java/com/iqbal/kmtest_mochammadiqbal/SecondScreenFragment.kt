package com.iqbal.kmtest_mochammadiqbal

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.iqbal.kmtest_mochammadiqbal.databinding.FragmentSecondScreenBinding


class SecondScreenFragment : Fragment() {

    lateinit var binding : FragmentSecondScreenBinding
    lateinit var sharedpref : SharedPreferences
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSecondScreenBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedpref = requireActivity().getSharedPreferences("username",Context.MODE_PRIVATE)

        binding.toolbarBack.setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_secondScreenFragment_to_fristScreenFragment)
        }

        binding.txtUser.text = sharedpref.getString("name","")
    }

}