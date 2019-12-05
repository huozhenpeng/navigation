package com.example.jetpacklifecycle.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.jetpacklifecycle.R
import com.example.jetpacklifecycle.databinding.FragmentWelcomeBinding

class WelcomeFragment :Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentWelcomeBinding =DataBindingUtil.inflate(inflater, R.layout.fragment_welcome,container,false)

        binding.btnLogin.setOnClickListener{
            //第一种方式导航：id
            //findNavController().navigate(R.id.loginFragment)

            //第二种方式导航：action
            //findNavController().navigate(R.id.action_welcomeFragment_to_loginFragment);


            //第三种方式导航：safe args
            findNavController().navigate(WelcomeFragmentDirections.actionWelcomeFragmentToRegisterFragment().setEmail("aa"))
        }

        return binding.root
    }
}