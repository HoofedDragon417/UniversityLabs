package com.example.labs

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainVM : ViewModel() {

    //Показывает текущее значение инкремента.
    val counter = MutableLiveData(0)

    //Увеличивает инкремент на 1.
    fun increaseCounter() {
        counter.value = requireNotNull(counter.value) + 1
    }

    //Уменьшает инкремент на 1. Не позволяет выйти за 0.
    fun decreaseCounter() {
        if (requireNotNull(counter.value) > 0)
            counter.value = requireNotNull(counter.value) - 1
    }

    //Сбрасывает инкремент до 0.
    fun dropCounter() {
        counter.value = 0
    }

}