package com.example.labs.screens.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.labs.R
import com.example.labs.adapters.ViewPagerAdapter
import com.example.labs.common.BaseVM
import com.example.labs.databinding.FragmentMainBinding
import com.example.labs.screens.coffee_machine.CoffeeMachineFragment
import com.example.labs.screens.delivery.DeliveryFragment
import com.google.android.material.tabs.TabLayoutMediator

class MainFragment : Fragment() {

    /**Привязка разметки fragment_main.xml к переменным.*/
    private var _binding: FragmentMainBinding? = null
    private val binding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        createFragments()
    }

    private fun createFragments() {
        val fragments = listOf(CoffeeMachineFragment(), DeliveryFragment())

        val tabs = listOf(getString(R.string.coffee_machine), getString(R.string.delivery))

        val adapter = ViewPagerAdapter(fragments, requireActivity())
        binding.pager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.pager) { tab, position ->
            tab.text = tabs[position]
        }.attach()
    }

}