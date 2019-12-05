package com.example.jetpacklifecycle.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.jetpacklifecycle.R
import com.example.jetpacklifecycle.databinding.FragmentRegisterBinding

class RegisterFragment :Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding:FragmentRegisterBinding=DataBindingUtil.inflate(inflater, R.layout.fragment_register,container,false)
        return binding.root
    }
}