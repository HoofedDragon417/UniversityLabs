package com.example.labs.screens.delivery

import android.content.Context
import androidx.lifecycle.viewModelScope
import com.example.labs.common.BaseVM
import com.example.labs.common.SharedPreference
import kotlinx.coroutines.launch

class DeliveryVM : BaseVM() {
    fun addResources(coffeeBeans: Int, milk: Int, water: Int, requireContext: Context) {
        viewModelScope.launch {
            coffeeMachine.value.coffeeBeans += coffeeBeans
            coffeeMachine.value.milk += milk
            coffeeMachine.value.water += water

            SharedPreference(requireContext).saveMachine(coffeeMachine.value)
        }
    }
}