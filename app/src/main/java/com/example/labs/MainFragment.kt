package com.example.labs

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.labs.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    //Привязка разметки fragment_main.xml к переменным.
    private var _binding: FragmentMainBinding? = null
    private val binding get() = requireNotNull(_binding)

    //Объявление ViewModel через делегат.
    private val viewModel: MainVM by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //Подписываемся на обновление инкремента, находящийся в MainVM.
        viewModel.counter.observe(viewLifecycleOwner) {
            binding.tvCounterField.text = it.toString()
        }

        //Вызов функции увеличения инкремента из ViewModel.
        binding.btnCounterIncrease.setOnClickListener {
            viewModel.increaseCounter()
        }

        //Вызов функции уменьшения инкремента из ViewModel.
        binding.btnCounterDecrease.setOnClickListener {
            viewModel.decreaseCounter()
        }

        //Вызов функции сброса инкремента из ViewModel.
        binding.btnDropCounter.setOnClickListener {
            viewModel.dropCounter()
        }
    }

}