package com.example.labs.screens.delivery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.labs.databinding.FragmentDeliveryBinding

class DeliveryFragment : Fragment() {

    private var _binding: FragmentDeliveryBinding? = null
    private val binding get() = requireNotNull(_binding)

    private val viewModel: DeliveryVM by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDeliveryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.setCoffeeMachine(requireContext())

        binding.btnAddResources.setOnClickListener {
            lifecycleScope.launchWhenStarted {
                val beans =
                    if (binding.etCoffeeBeans.text.isNullOrEmpty()) 0 else binding.etCoffeeBeans.text.toString()
                        .toInt()
                val milk =
                    if (binding.etMilk.text.isNullOrEmpty()) 0 else binding.etMilk.text.toString()
                        .toInt()
                val water =
                    if (binding.etWater.text.isNullOrEmpty()) 0 else binding.etWater.text.toString()
                        .toInt()

                viewModel.addResources(beans, milk, water, requireContext())
            }
        }
    }
}