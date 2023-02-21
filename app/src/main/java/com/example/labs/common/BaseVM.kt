package com.example.labs.common

import android.content.Context
import androidx.lifecycle.ViewModel
import com.example.labs.classes.Machine
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.flow.MutableStateFlow

open class BaseVM : ViewModel() {
    private var routerNull: Router? = null
    val router get() = requireNotNull(routerNull)

    fun setRouter(router: Router) {
        routerNull = router
    }

    val coffeeMachine = MutableStateFlow(Machine())

    fun setCoffeeMachine(ctx: Context) {
        coffeeMachine.value = SharedPreference(ctx).getMachine()
    }

    fun saveCoffeeMachine(ctx: Context) = SharedPreference(ctx).saveMachine(coffeeMachine.value)
}