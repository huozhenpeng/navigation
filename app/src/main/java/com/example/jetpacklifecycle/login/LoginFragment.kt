package com.example.jetpacklifecycle.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.jetpacklifecycle.R
import com.example.jetpacklifecycle.databinding.FragmentLoginBinding

class LoginFragment :Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding:FragmentLoginBinding=DataBindingUtil.inflate(
            inflater, R.layout.fragment_login,container,false)

        return binding.root
    }

}