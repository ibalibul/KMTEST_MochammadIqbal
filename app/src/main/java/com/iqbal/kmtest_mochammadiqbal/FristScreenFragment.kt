package com.iqbal.kmtest_mochammadiqbal

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.iqbal.kmtest_mochammadiqbal.databinding.FragmentFristScreenBinding


class FristScreenFragment : Fragment() {


    lateinit var binding : FragmentFristScreenBinding
    lateinit var sharedpref : SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFristScreenBinding.inflate(layoutInflater,container,false)
        return binding.root

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        sharedpref = requireActivity().getSharedPreferences("username",Context.MODE_PRIVATE)

        binding.btnNext.setOnClickListener{
            saveData()
            Toast.makeText(context, "Data Berhasil Di Simpan", Toast.LENGTH_SHORT).show()
            Navigation.findNavController(view).navigate(R.id.action_fristScreenFragment_to_secondScreenFragment)
        }

    }


    fun saveData() {

        var getUsername = binding.edUsername.text.toString()

        var addData = sharedpref.edit()
        addData.putString("name",getUsername)
        addData.apply()

    }

    

}