package com.example.labs.screens.coffee_machine

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.labs.R
import com.example.labs.databinding.FragmentCoffeeMachineBinding
import kotlinx.coroutines.flow.collectLatest

class CoffeeMachineFragment : Fragment() {

    private var _binding: FragmentCoffeeMachineBinding? = null
    private val binding get() = requireNotNull(_binding)

    private val viewModel: CoffeeMachineVM by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCoffeeMachineBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.setCoffeeMachine(requireContext())

        lifecycleScope.launchWhenStarted {
            viewModel.coffeeMachine.collectLatest {
                binding.tvCoffeeBeans.text =
                    getString(R.string.coffee_beans_resources, it.coffeeBeans)
                binding.tvMilk.text = getString(R.string.milk_resources, it.milk)
                binding.tvWater.text = getString(R.string.water_resources, it.water)
                binding.tvCash.text = getString(R.string.cash_resources, it.cash)
            }
        }

        binding.btnEspresso.setOnClickListener {
            lifecycleScope.launchWhenStarted {
                viewModel.makeEspresso()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        viewModel.saveCoffeeMachine(requireContext())
    }

    override fun onResume() {
        super.onResume()
        viewModel.setCoffeeMachine(requireContext())
    }
}