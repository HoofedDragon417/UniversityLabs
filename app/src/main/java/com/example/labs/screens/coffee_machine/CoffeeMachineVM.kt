package com.example.labs.screens.coffee_machine

import com.example.labs.classes.Coffees
import com.example.labs.common.BaseVM

class CoffeeMachineVM : BaseVM() {
    fun makeEspresso() {
        coffeeMachine.value.makeCoffee(Coffees.Espresso)
    }
}