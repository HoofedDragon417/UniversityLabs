package com.example.labs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class MainVM : ViewModel() {

    /**Хранит текущее значение инкремента.*/
    val counter = MutableStateFlow(0)

    /**Увеличивает инкремент на 1.
     *
     * [viewModelScope] запускает отдельный поток для изменения значения инкремента вне потока UI.
     * */
    fun increaseCounter() {
        viewModelScope.launch { counter.value+=1 }
    }

    /**Уменьшает инкремент на 1. Не позволяет выйти за 0.*/
    fun decreaseCounter() {
        viewModelScope.launch {
            if (counter.value > 0) counter.value -=1
        }
    }

    /**Сбрасывает инкремент до 0.*/
    fun dropCounter() {
        viewModelScope.launch { counter.value = 0 }
    }

}